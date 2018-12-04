package edu.iot.libra.command;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScheduleListCommandTest {
	@Test
	public void testList() throws Exception {
		Command command = new ScheduleListCommand();
		command.execute();		
	}
}
