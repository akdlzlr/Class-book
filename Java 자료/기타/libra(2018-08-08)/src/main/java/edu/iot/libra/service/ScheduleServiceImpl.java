package edu.iot.libra.service;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import edu.iot.libra.model.Schedule;

/**
 * <pre>
 * edu.iot.libra.service
 * ScheduleServiceImpl.java
 * 
 * Schedule 객체를 List로 관리하는 싱글톤 서비스 객체
 * 예)
 * 	ScheduleService service = 
				ScheduleServiceImpl.getInstance();
 * </pre>
 *
 * @author student
 *
 */
public class ScheduleServiceImpl implements ScheduleService {
	
	static final String FILE_PATH = "c:/temp/schedule.dat";
	
	/**
	 * Schedule 객체 관리 List 콜렉션
	 */
	private List<Schedule> list;
	
	
	/**
	 * 싱글톤을 위한 private static 필드 
	 */
	private static ScheduleServiceImpl instance = new ScheduleServiceImpl();

	
	/**
	 * 싱글톤 객체를 위한 private 생성자
	 */
	private ScheduleServiceImpl() {
		File file = new File(FILE_PATH);
		if(file.exists()) {
			load();
		}else {
			list = new LinkedList<>();
			init();
		}
	}

	/**
	 * 싱글톤 객체 참조를 리턴하는 static 메서드
	 * 
	 * @return 싱글톤 객체 참조
	 */
	public static ScheduleServiceImpl getInstance() {
		return instance;
	}
	
	
	/**
	 * 테스트를 위한 초기 데이터 구축 메서드 
	 */
	private void init() {
		SimpleDateFormat sdf = new SimpleDateFormat(
										"yyyy-MM-dd HH:mm");

			try {
				list.add(new Schedule(
								sdf.parse("2018-07-17 10:00"), 
								"제헌절 기념식 참가", "국회"));
				list.add(new Schedule(
						sdf.parse("2018-08-15 20:00"), 
						"심야영화 보기", "신촌"));

				list.add(new Schedule(
						sdf.parse("2018-08-15 15:00"), 
						"영화보기", "강남"));
	
				list.add(new Schedule(
								sdf.parse("2018-08-15 10:00"), 
								"광복절 기념식 참가", "광화문"));
				
				list.add(new Schedule(
								sdf.parse("2018-09-10 10:00"), 
								"추석 귀향", ""));
				list.add(new Schedule(
								sdf.parse("2018-01-01 06:00"), 
								"해돋이", "호미곳"));
				list.add(new Schedule(sdf.parse("2018-02-15 10:00"), "설 귀향", ""));
				list.add(new Schedule(sdf.parse("2018-03-01 10:00"), "삼일절 기념식 참가", "독립기념관"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	/* (non-Javadoc)
	 * @see edu.iot.libra.service.ScheduleService#add(edu.iot.libra.model.Schedule)
	 */
	
	public void add(Schedule sch) {
		list.add(sch);
	}
	
	
	public List<Schedule> list() {
		return list;
	}
	
	
	public List<Schedule> list(String yearMonth) {
		List<Schedule> temp = new LinkedList<>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		// 순회하면서 조건을 만족하는 스케줄 담기
		for(Schedule sch : list) {
			Date date = sch.getDate();
			String strDate = sdf.format(date);
			if(yearMonth.equals(strDate)) {
				temp.add(sch);
			}
		}
		return temp;
	}

	
	public Schedule getSchedule(int index) {
		return list.get(index);
	}

	
	public void setSchedule(int index, Schedule sch) {
		list.set(index, sch);

	}

	
	public void removeSchedule(int index) {
		list.remove(index);
	}


	public int findById(int id) {
		for(int i=0; i<list.size(); i++) {
			Schedule sch = list.get(i);
			if(id == sch.getId()) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void save() {
		try( 
			FileOutputStream fos = new FileOutputStream(FILE_PATH);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
				
			){
				oos.writeObject(Schedule.scheduleId);
				oos.writeObject(list);
				oos.flush(); 
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void load() {
		try(
			FileInputStream fis = new FileInputStream(FILE_PATH);
			ObjectInputStream ois = new ObjectInputStream(fis);	
		){
			Schedule.scheduleId = (int)ois.readObject();
			list = (List<Schedule>)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}