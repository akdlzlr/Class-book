package edu.iot.Scorpio.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TourSpotTest {
	
	@Test
	public void testBuild() throws Exception {
		TourSpot spot = TourSpot.builder()
								.id(1)
								.name("광화문")
								.homePage("www.kwang.go.kr")
								.address("서울시 ")
								.build();
		System.out.println(spot);
	}
}