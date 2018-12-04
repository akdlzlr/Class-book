package edu.iot.libra.command;

import java.util.List;

import org.junit.Test;

import edu.iot.libra.Context;
import edu.iot.libra.model.Schedule;
import edu.iot.libra.service.ScheduleService;
import edu.iot.libra.service.ScheduleServiceImpl;

public class ScheduleAddCommandTest {
	@Test
	public void testExecute() throws Exception {
		Command command = new ScheduleAddCommand();
		command.execute();
		
		ScheduleService service = 
				ScheduleServiceImpl.getInstance();
		List<Schedule> list = service.list();
		System.out.println(list);
		
	}
}
