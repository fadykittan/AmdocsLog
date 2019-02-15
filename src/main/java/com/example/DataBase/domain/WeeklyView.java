package com.example.DataBase.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class WeeklyView {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String sName;
	private int totalWeekly;

//--------------------------------------------------------------getters and setters------------------------------------------------

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getTotalWeekly() {
		return totalWeekly;
	}

	public void setTotalWeekly(int totalWeekly) {
		this.totalWeekly = totalWeekly;
	}

//-------------------------------------------------------constructors--------------------------------------------------------------

	public WeeklyView() {
	}

	public WeeklyView(String sName, int totalWeekly) {
		super();
		this.sName = sName;
		this.totalWeekly = totalWeekly;
	}
}
