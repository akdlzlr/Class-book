package edu.iot.common.util;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

public class FileUtilTest {
	@Test
	public void loadTest() throws Exception {
		File file = new File("c:/temp/tour100.txt");
		// List<String> list = FileUtil.readLines(file);
		List<String> list = FileUtil.readLines(file, "euc-kr");
		for(String spot : list) {
			System.out.println(spot);
		}
	}
}	
