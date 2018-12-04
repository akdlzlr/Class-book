package edu.iot.Scorpio.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import edu.iot.Scorpio.model.TourItem;
import edu.iot.Scorpio.model.TourPlan;
import edu.iot.Scorpio.model.TourSpot;
import edu.iot.common.util.FileUtil;
import lombok.Getter;

public class TourPlanServiceImpl implements TourPlanService {

	private static TourPlanServiceImpl instance = new TourPlanServiceImpl();
	
	private TourPlanServiceImpl(){
	}
	
	public static TourPlanServiceImpl getInstance(){
		return instance;
	}
	
	@Getter
	TourPlan plan;
	@Getter
	boolean dirty;
	String filePath;
	
	@Override
	public void newPlan(String title, Date begin, Date end, String description) {
		plan = new TourPlan(title, begin, end, description);
		dirty = true;
		filePath = null;
	}

	@Override
	public void load(String fname) throws Exception {			//	직렬화
		filePath = fname;
		plan = (TourPlan)FileUtil.deserialize(fname);
		dirty = false;
	}

	@Override
	public void save(String fname) throws Exception {			//	역직렬화
		filePath = fname;
		FileUtil.serialize(fname, plan);
		dirty = false;
	}

	@Override
	public void save() throws Exception {
		FileUtil.serialize(filePath, plan);
		dirty = false;
		
	}

	@Override
	public boolean isFirst() {
		return filePath == null;	//	새로운 일정을 할 때 널이 되어야한다.
	}

	@Override
	public void addSchedule(Date date, int spotID) {
		TourSpotService spotService = TourSpotServiceImpl.getInstance();
		TourSpot spot = spotService.findById(spotID);
		
		TourItem item = new TourItem(date,spot);
		
		List<TourItem> tourList = plan.getTourList();
		
		tourList.add(item);
		
		Collections.sort(tourList);
	}

	@Override
	public void deleteSchedule(int ix) {
		List<TourItem>	tourList = plan.getTourList();
		if(ix >=0 && ix < tourList.size()) {
			tourList.remove(ix);
		}
		
	}
}