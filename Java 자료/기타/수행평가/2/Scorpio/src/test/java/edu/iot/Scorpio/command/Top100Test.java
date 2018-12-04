package edu.iot.Scorpio.command;

import static org.junit.Assert.*;

import org.junit.Test;

public class Top100Test {
	
	
	
	@Test
	public void testName() throws Exception {
		Top100Command top100Command = new Top100Command();
		top100Command.execute();
	}
}
