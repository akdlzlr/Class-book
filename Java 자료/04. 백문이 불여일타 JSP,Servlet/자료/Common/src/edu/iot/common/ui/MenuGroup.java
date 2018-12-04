package edu.iot.common.ui;

import java.util.ArrayList;

import lombok.NoArgsConstructor;

public class MenuGroup extends Menu {
	
	public MenuGroup() {
		this(null);
	}
	
	public MenuGroup(String title) {
		super(title);
		menuList = new ArrayList<Menu>();
	}
	
	@Override
	public void execute() throws Exception {
		if(title!=null) {
			System.out.printf("[%s] ", title);
		}
		for(int i=0; i<menuList.size(); i++) {
			Menu menu = menuList.get(i);
			if(menu.getMenuList() != null) {
				System.out.printf("[%d) %s] ", i, menu.getTitle());
			} else {
				System.out.printf("%d) %s ", i, menu.getTitle());
			}
			
		}
		System.out.println();
		Prompt prompt = new Prompt();
		int select = prompt.getInt("선택");
		if(select >=0 && select<menuList.size()) {
			menuList.get(select).execute();
		}		
	}
}
