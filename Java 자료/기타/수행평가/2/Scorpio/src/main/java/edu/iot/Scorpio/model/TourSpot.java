package edu.iot.Scorpio.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//		관광지 클래스 정의
public class TourSpot implements Serializable{
	private static final long serialVersionUID =  1L;
	
	int id;
	String name;
	String region;
	String location;
	String content;
	String address;
	String homePage;
}
