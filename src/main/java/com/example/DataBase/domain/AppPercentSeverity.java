package com.example.DataBase.domain;

import java.math.BigInteger;

public class AppPercentSeverity {
	private String name;
	private BigInteger defnum;
	private String percentage;
	
//-------------------------------------------------getters and setters-------------------------------------------------------------
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigInteger getDefnum() {
		return defnum;
	}
	public void setDefnum(BigInteger defnum) {
		this.defnum = defnum;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

//----------------------------------------------------constructors----------------------------------------------------------------
	
	public AppPercentSeverity() {}
	
	public AppPercentSeverity(String name, BigInteger defnum, String percentage) {
		super();
		this.name = name;
		this.defnum = defnum;
		this.percentage = percentage;
		
		
}
}
