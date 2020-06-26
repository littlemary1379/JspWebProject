package com.dailyT.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
	private int custid;
	private String userId;
	private String password;
	private String username;
	private String nickname;
	private String email;
	private String address;
	private String cellphone;
	private String userrole;
	private Timestamp createdate;
}