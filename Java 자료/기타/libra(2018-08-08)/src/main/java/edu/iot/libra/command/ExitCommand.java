package edu.iot.libra.command;

import edu.iot.libra.service.ScheduleService;
import edu.iot.libra.service.ScheduleServiceImpl;

public class ExitCommand implements Command {

	
	public void execute() throws Exception{
		
		ScheduleService service = ScheduleServiceImpl.getInstance();
		
		service.save();
		System.out.println("종료합니다.");
		System.exit(0);
	}

}