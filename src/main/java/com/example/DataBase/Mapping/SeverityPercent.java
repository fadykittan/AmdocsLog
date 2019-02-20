package com.example.DataBase.Mapping;

import java.math.BigInteger;

public class SeverityPercent {

	private String severity;
	private BigInteger defnum;
	private String percentage;
	
	
//----------------------------------------------getters and setters-------------------------------------------------------------------
	
	public String getSeverity() 
	{
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
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


//-----------------------------------------------------constructors------------------------------------------------------------------
	public SeverityPercent() {}
	
	public SeverityPercent(String severity, BigInteger defnum, String percentage) {
		super();
		this.severity = severity;
		this.defnum = defnum;
		this.percentage = percentage;
	}
}
