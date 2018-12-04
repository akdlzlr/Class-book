package edu.iot.libra.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Prompt {
	private Scanner scanner;
	
	public Prompt() {
		scanner = new Scanner(System.in);
	}
	
	public String getString(String prompt) {
		System.out.print(prompt + ": ");
		return scanner.nextLine();
	}
	
	public int getInt(String prompt) {
		String str = getString(prompt);
		return Integer.parseInt(str);
	}
	
	public Date getDate(String prompt) throws ParseException {
		return getDate(prompt, "yyyy-MM-dd");
	}
	
	public Date getDate(String prompt, String pattern) throws ParseException {
		String str = getString(prompt + "(" + pattern + ")");
		if(str.equals("")) {
			return new Date();	// 오늘 날짜
		}
		
		SimpleDateFormat sdf = 
				new SimpleDateFormat(pattern);
		return sdf.parse(str);
	}

	
}







