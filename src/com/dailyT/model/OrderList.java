package com.dailyT.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderList {
	private int custid;
	private String orderProName;
	private String orderPhoto;
	private int orderProPrice;
	private int count;
}