package edu.iot.libra.command;

import edu.iot.libra.service.ScheduleService;
import edu.iot.libra.service.ScheduleServiceImpl;
import edu.iot.libra.ui.Prompt;

public class ScheduleDeleteCommand implements Command {

	
	public void execute() throws Exception {
		ScheduleService service = 
				ScheduleServiceImpl.getInstance();
		
		Prompt prompt = new Prompt();
		int id = prompt.getInt("스케줄 ID");
		int index = service.findById(id);
		if(index == -1) {
			System.out.println("존재하지 않는 IDd입니다.");
			return;
		}
		
		String select = prompt.getString("정말 삭제할까요(y/n)?");
		if(select.equals("y")) {
			service.removeSchedule(index);
			// 테스트 확인용
			// System.out.println(service.list());
		}
		
		
	}
}
