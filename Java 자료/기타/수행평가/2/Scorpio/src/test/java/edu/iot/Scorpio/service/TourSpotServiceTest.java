package edu.iot.Scorpio.service;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import edu.iot.Scorpio.model.TourSpot;

public class TourSpotServiceTest {
	
	TourSpotService service;
	
	@Before
	public void setup() {
		service = TourSpotServiceImpl.getInstance();
	}
	
	
	@Test
	public void testLoad() throws Exception {
		List<TourSpot> list = service.getList();
//		for(TourSpot spot : list) {
//			System.out.println(spot);
//		}
		assertTrue(list.size()>0);
		
		List<String> regionList = service.getRegionList();
//		for(String region : regionList) {
//			System.out.println(region);
//		}
		assertTrue(regionList.size()>0);
	}
}
