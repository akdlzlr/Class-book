package edu.iot.common.util;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Property {
	Class clazz;
	HashMap<String, Method> propMap;

	interface Editor {
		Object convert(String str);
	}
	
	HashMap<Class, Editor> editorMap;

	Property(Class clazz) {
		this.clazz = clazz;
		makeEditorMap();
		makeMethodMap();
	}
	
	public void makeEditorMap() {
		editorMap = new HashMap<>();
		editorMap.put(int.class, Integer::parseInt);
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
	
	public Object parse(Map<String, String> map) {
		Object obj = null;
		try {
			obj = clazz.newInstance();
			Set<String> keys = map.keySet();
			for(String key : keys) {
				String value = map.get(key);
				
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
	
	public static <T> T parse(Class<T> clazz, Map<String, String> map) {
		Property prop = new Property(clazz);
		return clazz.cast(prop.parse(map));
	}
}


