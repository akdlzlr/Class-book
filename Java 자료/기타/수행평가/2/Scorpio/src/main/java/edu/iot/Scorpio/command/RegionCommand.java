package edu.iot.Scorpio.command;

import java.io.IOException;
import java.util.List;

import edu.iot.Scorpio.model.TourSpot;
import edu.iot.Scorpio.service.TourSpotService;
import edu.iot.Scorpio.service.TourSpotServiceImpl;
import edu.iot.common.command.Command;
import edu.iot.common.ui.Pagination;
import edu.iot.common.ui.Prompt;

public class RegionCommand implements Command {
	
	TourSpotService service = TourSpotServiceImpl.getInstance();
	
	@Override
	public void execute() throws Exception {
		// 권역 리스트 얻기
		List<String> list = service.getRegionList();
		Prompt prompt = new Prompt();
		
		int select = prompt.selectList("권역선택", list);
		String region = list.get(select);
		
		// test
		System.out.println(region+"을 선택했습니다.");
		
		// 선택한 권역 리스트 얻기
		List<TourSpot> spotList = service.findByRegion(region);
		System.out.printf("\n%s (%d건)===============================================\n",
				region,spotList.size());
		for(TourSpot spot : spotList) {
			System.out.printf("%3d] %s\t%s\n",
								spot.getId(),
								spot.getName(),
								spot.getAddress());
		}
		System.out.println("=======================================================");
		
		while(true) {
			String command = prompt.getString("숫자/q");
			
			if (command.equals("q")){
				System.out.println("메인메뉴로 간당~");
				break;
			}else {
				int id = Integer.parseInt(command);
				viewTourSpot(id);
			}
		}
		
	}
	
	public void viewTourSpot(int id) {
		Prompt prompt = new Prompt();
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