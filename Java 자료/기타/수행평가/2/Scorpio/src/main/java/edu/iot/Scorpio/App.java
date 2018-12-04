package edu.iot.Scorpio;

import edu.iot.Scorpio.command.ExitCommand;
import edu.iot.Scorpio.command.LoadCommand;
import edu.iot.Scorpio.command.NewPlanCommand;
import edu.iot.Scorpio.command.PlanManageCommand;
import edu.iot.Scorpio.command.PrintCommnd;
import edu.iot.Scorpio.command.RegionCommand;
import edu.iot.Scorpio.command.SaveCommand;
import edu.iot.Scorpio.command.Top100Command;
import edu.iot.common.app.Application;
import edu.iot.common.ui.Menu;
import edu.iot.common.ui.MenuGroup;
import edu.iot.common.ui.MenuItem;

public class App extends Application{
	
	@Override
	public void createMenu(Menu menu) {
		menu.add(new MenuItem("Top 100", new Top100Command()));
		menu.add(new MenuItem("권역별 보기", new RegionCommand()));
		
		MenuGroup planMenu = new MenuGroup("여행 일정");
		planMenu.add(new MenuItem("새 일정",new NewPlanCommand()));
		planMenu.add(new MenuItem("저장",new SaveCommand()));
		planMenu.add(new MenuItem("열기",new LoadCommand()));
		planMenu.add(new MenuItem("일정관리",new PlanManageCommand()));
		planMenu.add(new MenuItem("출력",new PrintCommnd()));
		menu.add(planMenu);
		
		menu.add(new MenuItem("종료", new ExitCommand()));
	}
	
	
	
    public static void main( String[] args )
    {
        System.out.println( "=============한국 관광 명소 100선=============" );
        System.out.println();
        App app = new App();
        app.run();
        
    }
}
//	cmd에서 실행 시 프로젝트 export로 jar파일을 만들어서 실행해야함
//	java -jar Tour.jar