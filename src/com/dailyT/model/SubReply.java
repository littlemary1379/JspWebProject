package com.dailyT.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubReply {
	private int replyid;
	private int custid;
	private int subid;
	private int score;
	private String content;
}
