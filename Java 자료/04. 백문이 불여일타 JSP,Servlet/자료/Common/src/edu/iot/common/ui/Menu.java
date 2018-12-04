package edu.iot.common.ui;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Menu {
	String title;			// 메뉴 명
	List<Menu> menuList;	// 메뉴 목록(MenuGroup만 사용)

	public Menu(String title) {	
		this.title = title;
	}
	
	public void add(Menu menu) {
		menuList.add(menu);		
	}

	abstract public void execute() throws Exception;
}
