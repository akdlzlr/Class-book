package edu.iot.Scorpio.command;

import java.io.IOException;
import java.util.List;

import edu.iot.Scorpio.model.TourSpot;
import edu.iot.Scorpio.service.TourSpotService;
import edu.iot.Scorpio.service.TourSpotServiceImpl;
import edu.iot.common.command.Command;
import edu.iot.common.ui.Pagination;
import edu.iot.common.ui.Prompt;

public class Top100Command implements Command {

	TourSpotService service = TourSpotServiceImpl.getInstance();

	@Override
	public void execute() throws Exception {
		// 100선 리스트 얻기
		List<TourSpot> list = service.getList();
		Pagination<TourSpot> pagination = new Pagination(list);

		int page = 1;

		while (true) {
			List<TourSpot> pageList = pagination.getPage(page);
			for (TourSpot spot : pageList) {
				System.out.printf("%3d] %s\t%s\n", spot.getId(), 
											spot.getName(), spot.getRegion());
			}
			pagination.printPages();

			Prompt prompt = new Prompt();
			String command = prompt.getString("p/n/v/숫자/q");

			if (command.equals("p")) {
				page = pagination.previous();
			} else if (command.equals("n")) {
				page = pagination.next();
			} else if (command.equals("v")) {
				viewTourSpot();
				
			} else if (command.equals("q")) {
				System.out.println("메인 메뉴로 간당~");
				break;
			} else {
				page = Integer.parseInt(command);
			}
			System.out.println();
		}
	}
	
	public void viewTourSpot() {
		Prompt prompt=new Prompt();
		String select = prompt.getString("ID 입력");
		
		int id = Integer.parseInt(select);
		TourSpot info = service.findById(id);
		if(info == null) {
			System.out.println("해당사항이 없습니다.");
			return;
		}
		System.out.printf("번호 : %d\n이름 : %s\n시도 : %s\n지역 : %s\n내용 : %s\n위치 : %s\n홈페이지 : %s\n",
									info.getId(),
									info.getName(),
									info.getRegion(),
									info.getLocation(),
									info.getContent(),
									info.getAddress(),
									info.getHomePage());
		String visit = prompt.getString("홈페이지 방문 여부(y/n)");
		if(visit.equals("y")) {
			// 홈페이지 방문
			try {
				new ProcessBuilder("cmd","/c","start",info.getHomePage()).start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		prompt.getString("END");
	}
}