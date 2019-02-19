package com.example.DataBase.domain;



public class ViewDefects {
	


	long seqid;
	String appName;
	String appType;
	String defCode;
	String severity;
	String solname;
	String description;
	String Idid;
	String Ido;

//---------------------------------------------------------------getters and setters---------------------------------------------------------
	public long getSeqid() {
		return seqid;
	}
	public void setSeqid(long seqid) {
		this.seqid = seqid;
	}
	
	public String getSolname() {
		return solname;
	}
	public void setSolname(String solname) {
		this.solname = solname;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppType() {
		return appType;
	}
	public void setAppType(String appType) {
		this.appType = appType;
	}
	public String getDefCode() {
		return defCode;
	}
	public void setDefCode(String defCode) {
		this.defCode = defCode;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getIdid() {
		return Idid;
	}

	public void setIdid(String idid) {
		Idid = idid;
	}

	public String getIdo() {
		return Ido;
	}

	public void setIdo(String ido) {
		Ido = ido;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
//------------------------------------------------------constructors------------------------------------------------------------------------
	
	public ViewDefects() {}
	
	public ViewDefects(long seqid,String appName, String appType, String defCode, String severity, String solname, String description) {
		super();
		this.seqid = seqid;
		this.appName = appName;
		this.appType = appType;
		this.defCode = defCode;
		this.severity = severity;
		this.solname = solname;
		this.description = description;
	}
	
	

}
