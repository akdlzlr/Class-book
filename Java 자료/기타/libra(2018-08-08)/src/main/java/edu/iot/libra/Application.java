package edu.iot.libra;

import edu.iot.libra.ui.Menu;

/**
 * <pre>
 * edu.iot.libra
 * Application.java
 * </pre>
 *
 * @author student
 *
 */
public abstract class Application {
	/**
	 * 
	 */
	Menu menu;
	
	public Application() {
		menu = new Menu();
		createMenu(menu);
	}

	/**
	 * @param menu
	 */
	abstract public void createMenu(Menu menu);
	
	public static void clearScreen() {
		for(int i=0; i<24; i++) {
			System.out.println();
		}
	}
	
	public void run() {
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
