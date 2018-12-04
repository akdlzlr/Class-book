package edu.iot.Scorpio.command;

import java.io.File;

import edu.iot.Scorpio.service.TourPlanService;
import edu.iot.Scorpio.service.TourPlanServiceImpl;
import edu.iot.common.command.Command;
import edu.iot.common.util.FileSelect;

public class LoadCommand implements Command{

	TourPlanService service = TourPlanServiceImpl.getInstance();
	
	@Override
	public void execute() throws Exception {
		// 더티 체크
		if(service.isDirty()) {
			Command sc = new SaveCommand();
			sc.execute();
		}
		FileSelect fileSelect = new FileSelect("c:/temp", ".tsc");
		File file = fileSelect.select();
		
		service.load(file.getPath());
		new PlanManageCommand().execute();
	}
}