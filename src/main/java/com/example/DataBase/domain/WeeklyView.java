package com.example.DataBase.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class WeeklyView {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String severity;
	private int total;
    
//----------------------------------------------------getters and setters-------------------------------------------------------------
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

//-------------------------------------------------------constructors------------------------------------------------------------------
	
    public WeeklyView() {}
	public WeeklyView(String severity, int total) {
		super();
		this.severity = severity;
		this.setTotal(total);
	}



}
