package edu.iot.libra.service;

import java.util.List;

import edu.iot.libra.model.Schedule;

/**
 * <pre>
 * edu.iot.libra.service
 * ScheduleService.java
 * 
 * Schedule 관리 서비스 객체를 위한 인터페이스
 * </pre>
 *
 * @author student
 *
 */
public interface ScheduleService {
	
	/**
	 * Schedule 객체를 컬렉션에 추가함
	 * @param sch 컬렉션에 추가할 Schedule 인스턴스
	 */
	void add(Schedule sch);
	
	/**
	 * 전체 Schedule 리스트 반환
	 * @return Schedule 리스트 
	 */
	List<Schedule> list();
	
	/**
	 * 지정한 년/월의 스케줄 리스트를 반환함
	 * @param yearMonth 검색할 "yyyy-MM" 형식의 년월 문자열
	 * @return Schedule 리스트
	 */
	List<Schedule> list(String yearMonth);
	
	/**
	 * @param index
	 * @return
	 */
	Schedule getSchedule(int index);
	
	public int findById(int id);
	
	void setSchedule(int index, Schedule sch);
	
	void removeSchedule(int index);
	
	void save();
	
}
