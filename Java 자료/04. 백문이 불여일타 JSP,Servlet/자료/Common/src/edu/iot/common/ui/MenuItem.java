package edu.iot.common.ui;

import edu.iot.common.command.Command;

public class MenuItem extends Menu {

	Command command;		// 관련 명령
	
	public MenuItem(String title, Command command) {
		super(title);
		this.command = command;
	}
	
	@Override
	public void execute() throws Exception {
		if(command != null) {
			command.execute();
		}
		
	}
}
