package edu.iot.Scorpio.command;

import edu.iot.Scorpio.service.TourPlanService;
import edu.iot.Scorpio.service.TourPlanServiceImpl;
import edu.iot.common.command.Command;

public class ExitCommand implements Command{
	TourPlanService service = TourPlanServiceImpl.getInstance();
	@Override
	public void execute() throws Exception {
		
		if(service.isDirty()) {
			new SaveCommand().execute();
		}
		
		System.out.println("종료합니다.");
		System.exit(0);
	}
}