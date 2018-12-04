package edu.iot.libra.command;

import java.util.Date;

import edu.iot.libra.Context;
import edu.iot.libra.model.Schedule;
import edu.iot.libra.service.ScheduleService;
import edu.iot.libra.service.ScheduleServiceImpl;
import edu.iot.libra.ui.Prompt;

public class ScheduleAddCommand implements Command {

	
	public void execute() throws Exception{
		Prompt prompt = new Prompt();
		
		Date date 		= prompt.getDate("날짜", "yyyy-MM-dd HH:mm");
		String content 	= prompt.getString("일정");
		String location = prompt.getString("장소");
		
		Schedule sch = new Schedule(date, content, location);
		
		ScheduleService service = 
					ScheduleServiceImpl.getInstance();
		service.add(sch);		
	}

}






