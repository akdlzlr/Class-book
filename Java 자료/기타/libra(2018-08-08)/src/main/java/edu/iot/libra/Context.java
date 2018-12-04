package edu.iot.libra;

import java.util.HashMap;
import java.util.Map;

import edu.iot.libra.service.ScheduleService;
import edu.iot.libra.service.ScheduleServiceImpl;

public class Context {
	private static Map<Class, Object> map = new HashMap<>();
	/*
	static {
		map.put(ScheduleService.class, new ScheduleServiceImpl() );
	}
	 
	public static <T> T get(Class<T> clazz) {
		Object obj = map.get(clazz);
		
		try {
			return clazz.cast(obj);
		} catch (Exception e) {
			return null;
		}
	}*/
	
}
