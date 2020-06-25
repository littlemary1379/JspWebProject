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
public class Product {
	private int proId;
	private String proName;
	private int proPrice;
	private int proSale;
	private String prokind;
	private int proStock;
	private String proDate;
	private String proPhoto;
	private String proContent;
}
