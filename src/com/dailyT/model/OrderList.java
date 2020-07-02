package com.dailyT.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderList {
	ArrayList<OrderLists> OrderLists;
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class OrderLists{
	private String orderProName;
	private String orderPhoto;
	private int orderProPrice;
	private int count;
	}
}