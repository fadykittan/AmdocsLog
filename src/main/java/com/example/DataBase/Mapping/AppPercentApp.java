package com.example.DataBase.Mapping;

import java.math.BigInteger;

public class AppPercentApp {
	
	private String errorCode;
	private BigInteger defnum;
	private String percentage;
	private BigInteger critical;
	private BigInteger error;
	private BigInteger warning;
//-------------------------------------------------getters and setters-------------------------------------------------------------

	public String geterrorCode() {
		return errorCode;
	}

	public void seterrorCode(String errorCode) {
		this.errorCode = errorCode;
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

	public AppPercentApp() {
	}



	public AppPercentApp(String errorCode, BigInteger defnum, String percentage, BigInteger critical, BigInteger error,
			BigInteger warning) {
		super();
		this.errorCode = errorCode;
		this.defnum = defnum;
		this.percentage = percentage;
		this.critical = critical;
		this.error = error;
		this.warning = warning;
	}

	public BigInteger getCritical() {
		return critical;
	}

	public void setCritical(BigInteger critical) {
		this.critical = critical;
	}

	public BigInteger getError() {
		return error;
	}

	public void setError(BigInteger error) {
		this.error = error;
	}

	public BigInteger getWarning() {
		return warning;
	}

	public void setWarning(BigInteger warning) {
		this.warning = warning;
	}
}
