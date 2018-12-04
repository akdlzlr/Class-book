package edu.iot.Scorpio.service;

import java.util.List;

import edu.iot.Scorpio.model.TourSpot;

public interface TourSpotService {

	List<TourSpot> getList();

	List<String> getRegionList();

	TourSpot findById(int id);

	List<TourSpot> findByRegion(String region);
}
//		서비스 인터페이스하는 부분