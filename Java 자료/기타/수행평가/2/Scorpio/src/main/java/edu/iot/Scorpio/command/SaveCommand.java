package edu.iot.Scorpio.command;

import edu.iot.Scorpio.service.TourPlanService;
import edu.iot.Scorpio.service.TourPlanServiceImpl;
import edu.iot.common.command.Command;
import edu.iot.common.ui.Prompt;

public class SaveCommand implements Command{
	
	TourPlanService service = TourPlanServiceImpl.getInstance();
	
	@Override
	public void execute() throws Exception {
		// 저장 유무 확인
		if(service.isFirst()) {
		// 새로 저장하는 경우
			Prompt prompt = new Prompt();
			
			String defaultName = service.getPlan().getTitle();
			String fname = prompt.getString("파일명("+defaultName+")");
			if(fname.equals("")) {		//	엔터만 친 경우
				fname = defaultName;
			}
			
			String path = "c:/temp/"+fname+".tsc";	//	바이너리 데이터여서 txt로 저장하면 깨짐
			
			service.save(path);
		}else {		//		다시 저장하는 경우
			service.save();
		}
		//	저장이 실패한 경우 Command에서 예외처리 발생
		System.out.println("저장하였습니다.");
	}
}