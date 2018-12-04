package edu.iot.capricorn.util;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class Property {
	Class<?> clazz;
	HashMap<String, Method> propMap;

	interface Editor {
		Object convert(String str);
	}
	
	HashMap<Class<?>, Editor> editorMap;

	Property(Class<?> clazz) {
		this.clazz = clazz;
		makeEditorMap();
		makeMethodMap();
	}
	
	public void makeEditorMap() {
		editorMap = new HashMap<>();
		editorMap.put(int.class, Integer::parseInt);
		editorMap.put(long.class, Long::parseLong);
		editorMap.put(float.class, Float::parseFloat);
		editorMap.put(double.class, Double::parseDouble);
		editorMap.put(String.class, String::new);
		editorMap.put(Date.class, this::convertDate);
	}
	
	public Date convertDate(String str )  {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	public void makeMethodMap() {
		propMap = new HashMap<>();
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method : methods) {
			String name = method.getName();

			if(name.startsWith("set")) {
				name = name.substring(3);
				name = Character.toLowerCase(name.charAt(0)) +
						name.substring(1);
				propMap.put(name, method);
			}
		}
	}
	
	public Object parse(HttpServletRequest request) {
		Object obj = null;
		try {
			obj = clazz.newInstance();
			
			
			Enumeration<String> keys = request.getParameterNames();
			while(keys.hasMoreElements()) {
				String key = keys.nextElement();
				String value = request.getParameter(key);
				
				System.out.println(key + "," + value);
				
				Method method = propMap.get(key);
				if(method==null) continue;
				Class param = method.getParameterTypes()[0];
				System.out.println(param);
				Editor editor = editorMap.get(param);
				if(editor != null) {
					Object paramValue = editor.convert(value);
					method.invoke(obj, paramValue);
				} else {
					System.out.println(param + " Editor 없음");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public static <T> T parse(HttpServletRequest request, Class<T> clazz) {
		Property prop = new Property(clazz);
		return clazz.cast(prop.parse(request));
	}
}


