package edu.iot.libra.ui;

import java.util.ArrayList;
import java.util.List;

import edu.iot.libra.Application;

public class Menu {
	List<MenuItem> menuList;

	public Menu() {
		menuList = new ArrayList<>();
	}

	public void add(MenuItem menu) {
		menuList.add(menu);
	}
	
	public void printMenu() {
		for(int i=0; i<menuList.size(); i++) {
			MenuItem menu = menuList.get(i);
			System.out.printf("%d) %s ", i, menu.getTitle());
		}

		System.out.println();
	}
	
	public void execute() throws Exception {
		printMenu();
		Prompt prompt = new Prompt();
		int ix = prompt.getInt("선택");
		if(ix >= 0 && ix <menuList.size()) {
			Application.clearScreen();
			menuList.get(ix).execute();
		} else {
			System.out.println("잘못된 메뉴 선택입니다.");
		}
	}

}
