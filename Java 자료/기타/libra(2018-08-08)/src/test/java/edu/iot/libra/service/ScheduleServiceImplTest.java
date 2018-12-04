package edu.iot.libra.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.iot.libra.model.Schedule;

public class ScheduleServiceImplTest {

	ScheduleService service;
	
	@Before
	public void setup() {
		//service = new ScheduleServiceImpl();
		service = ScheduleServiceImpl.getInstance();
	}

	@Test
	public void testAdd() {
		Schedule sch = new Schedule(
						new Date(), "테스트", "강의실");
		service.add(sch);
		assertEquals(service.list().size(), 1);
	}
	
	@Test
	public void testList() {
		Schedule sch = new Schedule(
						new Date(), "테스트", "강의실");
		service.add(sch);
		service.add(sch);
		
		List<Schedule> list = service.list("2018-08");
		assertEquals(list.size(), 2);
		
		list = service.list("2018-09");
		assertEquals(list.size(), 0);
		
	}
	
	@Test
	public void testName() throws Exception {
		int id = service.findById(2);
		assertTrue(id != -1);
	}
	
	
	
	
}
