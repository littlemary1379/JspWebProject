package com.dailyT.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class subReplyView {
	private int replyid;
	private int custid;
	private String nickname;
	private int subid;
	private int score;
	private String content;
}
