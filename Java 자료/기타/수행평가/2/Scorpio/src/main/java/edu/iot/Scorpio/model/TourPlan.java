package edu.iot.Scorpio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;


@Data
public class TourPlan implements Serializable {

	private static final long serialVersionUID = 1L;

	String title;			// 여행 제목
	Date begin;				// 여행 시작일
	Date end;				// 여행 마지막일
	String description;		// 여행 설명
	List<TourItem> tourList;// 세부 여행 일정
	
	public TourPlan() {
		tourList = new ArrayList<>();		
	}

	public TourPlan(String title, Date begin, Date end, String description) {
		super();
		this.title = title;
		this.begin = begin;
		this.end = end;
		this.description = description;
		tourList = new ArrayList<>();
	}
}