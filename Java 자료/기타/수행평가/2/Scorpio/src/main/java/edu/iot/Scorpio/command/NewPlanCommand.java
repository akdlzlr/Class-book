package edu.iot.Scorpio.command;

import java.util.Date;

import edu.iot.Scorpio.service.TourPlanService;
import edu.iot.Scorpio.service.TourPlanServiceImpl;
import edu.iot.common.command.Command;
import edu.iot.common.ui.Prompt;

public class NewPlanCommand implements Command{
	TourPlanService service = TourPlanServiceImpl.getInstance();

	@Override
	public void execute() throws Exception {
		//	더티 체크
		if(service.isDirty()) {
			//	저장
			Command sc = new SaveCommand();
			sc.execute();
			//	SaveCommand와 코드가 중복 = Command를 인스턴스화 시켜서 실행 시켜 코드 중복 해결
		}
		
		//	여행 개요 입력
		Prompt prompt = new Prompt();
		String title = prompt.getString("제목");
		Date begin = prompt.getDate("시작일");
		Date end = prompt.getDate("종료일");
		String description = prompt.getLines("내용");
		
		service.newPlan(title, begin, end, description);
		
		new PlanManageCommand().execute();
	}
	
	
}