package edu.iot.libra.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
public class Schedule implements Comparable<Schedule>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int scheduleId=0;

	private int id;
	private Date date;
	private String content;
	private String location;
	
	public Schedule(Date date, String content, String location) {
		super();
		this.id = scheduleId++;
		this.date = date;
		this.content = content;
		this.location = location;
	}

	
	public int compareTo(Schedule o) {
		return date.compareTo(o.date);
	}
}