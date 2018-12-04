package edu.iot.libra.ui;

import edu.iot.libra.command.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {
	@Getter
	String title;			// 메뉴명
	Command command;		// 실행할 명령
	
	public void execute() throws Exception {
		if(command != null) {
			command.execute();
		}
	}
}
