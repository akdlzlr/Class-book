package edu.iot.Scorpio.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourItem implements Serializable, Comparable<TourItem> {

	private static final long serialVersionUID = 1L;

	Date date;
	TourSpot spot;
	
	@Override
	public int compareTo(TourItem item) {
		return date.compareTo(item.date);
	}
}