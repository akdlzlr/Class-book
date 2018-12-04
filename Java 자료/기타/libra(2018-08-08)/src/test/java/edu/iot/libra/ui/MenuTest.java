package edu.iot.libra.ui;

import org.junit.Test;

import edu.iot.libra.command.ExitCommand;
import edu.iot.libra.command.ScheduleAddCommand;

public class MenuTest {
	@Test
	public void testMenu() {
		Menu menu = new Menu();
		
		menu.add(new MenuItem("추가", new ScheduleAddCommand()));
		menu.add(new MenuItem("종료", new ExitCommand()));
		
		while(true) {
			try {
				menu.execute();
			} catch (Exception e) {
				System.out.println("명령 처리 중 에러가 발생했습니다.");
				System.out.println(e.getMessage());
			}
		}		
	}
}
