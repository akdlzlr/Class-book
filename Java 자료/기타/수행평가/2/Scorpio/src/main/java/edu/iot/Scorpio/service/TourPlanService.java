package edu.iot.Scorpio.service;

import java.util.Date;

import edu.iot.Scorpio.model.TourPlan;

public interface TourPlanService {
	
	boolean isFirst();
	boolean isDirty();
	TourPlan getPlan();
	
	void newPlan(String title, Date begin, Date end, String description);
	void save(String fname) throws Exception;
	void load(String fname) throws Exception;
	void save() throws Exception;
	void addSchedule(Date date, int spotID);
	void deleteSchedule(int ix);
}