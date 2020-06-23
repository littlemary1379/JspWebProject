package com.dailyT.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class customer {
	private int custid;
	private String nickname;
	private String password;
	private String email;
	private String address;
	private String cellphone;
	private String userrole;
	private Timestamp createdate;
}