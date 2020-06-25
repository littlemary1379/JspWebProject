package com.dailyT.model;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubProduct {
	private int subId;
	private String subName;
	private int subPrice;
	private int subSale;
	private String subPhoto;
	private String subContent;
	private String subdate;
}
