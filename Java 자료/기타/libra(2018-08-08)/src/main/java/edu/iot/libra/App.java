package edu.iot.libra;

import edu.iot.libra.command.ExitCommand;
import edu.iot.libra.command.ScheduleAddCommand;
import edu.iot.libra.command.ScheduleDeleteCommand;
import edu.iot.libra.command.ScheduleListCommand;
import edu.iot.libra.command.ScheduleUpdateCommand;
import edu.iot.libra.ui.Menu;
import edu.iot.libra.ui.MenuItem;

public class App extends Application {
	
	@Override
	public void createMenu(Menu menu) {
		menu.add(new MenuItem("추가", new ScheduleAddCommand()));
		menu.add(new MenuItem("목록", new ScheduleListCommand()));
		menu.add(new MenuItem("수정", new ScheduleUpdateCommand()));
		menu.add(new MenuItem("삭제", new ScheduleDeleteCommand()));
		menu.add(new MenuItem("종료", new ExitCommand()));
	}
	
	public static void main(String[] args) {
		App app = new App();
		app.run();		
	}
}
//	포토폴리오 Tip!!
//	사용한 패턴 - 전략패턴, 싱글톤, 템플릿, 커맨드(수행할 것을 추상화 했다? ex. exit 등), 빌더(X)
//	객체 직렬화 기법을 사용하여 저장과 로드를 적용시켰다.
//	롬복 라이브러리를 사용하였다.
//	junit으로 단위 테스트를 할 수 있다.