package edu.iot.common.model;

import java.util.Date;

import lombok.Data;

@Data
public class Reply {
	private long	replyId;
	private long	boardId;
	private int		level;
	private int		parent;
	private String	password;
	private String	writer;
	private String	content;
	private int		deleted;
	private Date	regDate;
	private Date	updateDate;
}
