package edu.iot.Scorpio.command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import edu.iot.Scorpio.model.TourItem;
import edu.iot.Scorpio.model.TourPlan;
import edu.iot.Scorpio.service.TourPlanService;
import edu.iot.Scorpio.service.TourPlanServiceImpl;
import edu.iot.common.command.Command;
import edu.iot.common.ui.Prompt;

public class PlanManageCommand implements Command{
	TourPlanService service = TourPlanServiceImpl.getInstance();

	@Override
	public void execute() throws Exception {
		TourPlan plan = service.getPlan();
		
		if(plan==null) {
			System.out.println("여행 계획이 없당");
			return;
		}

		printSummary(plan);
		
		Prompt prompt = new Prompt();
		while(true) {
			printSchedule(plan.getTourList());
			String select = prompt.getString("a/d/q");
			if(select.equals("a")) {
				addSchedule();
			}else if(select.equals("d")) {
				deleteSchedule();
			}else if(select.equals("q")) {
				break;
			}
		}
	}
	
	private void deleteSchedule() {
		Prompt prompt = new Prompt();
		int ix = prompt.getInt("일정번호");
		if (ix!=-1) {
			service.deleteSchedule(ix);
		}
	}
	private void addSchedule() {
		Prompt prompt = new Prompt();
		try {
			Date date = prompt.getDate("날짜/시간","yyyy-MM-dd HH:mm");
			
			int spotId = prompt.getInt("방문지 id");
			service.addSchedule(date, spotId);
			
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void printSummary(TourPlan plan) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println();
		System.out.println("=================================================");
		System.out.println("제목 : "+plan.getTitle());
		System.out.printf("기간 : %s~%s\n",
								sdf.format(plan.getBegin()),
								sdf.format(plan.getEnd()));
		System.out.println("내용 : \n"+plan.getDescription());
		System.out.println("=================================================");
	}
	
	private void printSchedule(List<TourItem> tourList) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.printf("세부일정(%d건)\n",tourList.size());
		System.out.println("=================================================");
		for(int i=0; i<tourList.size();i++) {
			TourItem item = tourList.get(i);
			System.out.printf("%d] %s %s\n",
					i, sdf.format(item.getDate()),
					item.getSpot());
		}
		System.out.println("=================================================");
	}
}