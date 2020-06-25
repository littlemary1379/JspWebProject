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
	private int proid;
	private String proname;
	private int proPrice;
	private int proSale;
	private String prokind;
	private String proDate;
	private String proPhoto;
	private String proContent;
}
