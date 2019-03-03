package com.example.DataBase.Mapping;

public class SeverityAppPercent {

	private String percentage;
	private String severity;
	
	
	public SeverityAppPercent(String percentage, String severity) {
		super();
		this.percentage = percentage;
		this.severity = severity;
	}


	public SeverityAppPercent(String percentage) {
		super();
		this.percentage = percentage;
	}


	public SeverityAppPercent() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getPercentage() {
		return percentage;
	}


	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}


	public String getSeverity() {
		return severity;
	}


	public void setSeverity(String severity) {
		this.severity = severity;
	}
	
	
	
	

	
	
	
	
}
