package edu.iot.Scorpio.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.iot.Scorpio.model.TourSpot;
import edu.iot.common.util.FileUtil;
//	서비스 인터페이스를 구현하는 부분
public class TourSpotServiceImpl implements TourSpotService {

	//	필드
	private static TourSpotServiceImpl instance = new TourSpotServiceImpl();
	final static String FILE_PATH = "C:/temp/tour100.txt";
	
	List<TourSpot> list;
	List<String> regionList;
	
	//	생성자
	private TourSpotServiceImpl() {
		load();
	}
	
	//	메서드
	public static TourSpotServiceImpl getInstance() {
		return instance;
	}
	
	private void load() {
		File file = new File(FILE_PATH);
		List<String> spotlist = FileUtil.readLines(file, "euc-kr");
		
		Set<String> regionSet = new HashSet<>();
		
		list = new ArrayList<>();
		for(String spot : spotlist) {
			String[] info = spot.split("\t");
			TourSpot ts = TourSpot.builder()
								  .id(Integer.parseInt(info[0]))
								  .name(info[1])
								  .region(info[2])
								  .location(info[3])
								  .content(info[4])
								  .address(info[5])
								  .homePage(info[6])
								  .build();
			list.add(ts);
			regionSet.add(ts.getRegion());
		}
		regionList = new ArrayList<>(regionSet);
		//	권역별 이름 오름차순 정열
		Collections.sort(regionList);
	}
	
	public List<TourSpot> getList() {
		return list;
	}

	@Override
	public List<String> getRegionList() {
		
		return regionList;
	}

	@Override
	public TourSpot findById(int id) {
		for(TourSpot spot : list) {		
			if(id == spot.getId()) {
				return spot;
			}
		}
		return null;		
//		return list.get(id-1);
	}

	@Override
	public List<TourSpot> findByRegion(String region) {
		List<TourSpot> spotList = new ArrayList<>();
		for(TourSpot spot : list) {
			if(region.equals(spot.getRegion())) {
				spotList.add(spot);
			}
		}
		return spotList;
	}
	
	
	
}