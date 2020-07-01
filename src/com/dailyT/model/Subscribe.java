package com.dailyT.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subscribe {
	private int subscribeId;
	private int custid;
	private String subscribeName;
	private String subscribeDate;
	private int subscribeTerm;
	private String subscribeAddr;
	private String subscribePhone;
	private String subscribeKind;
}	
