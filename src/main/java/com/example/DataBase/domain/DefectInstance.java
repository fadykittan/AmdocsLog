package com.example.DataBase.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.ConstructorResult;

import java.math.BigInteger;

import javax.persistence.ColumnResult;

@Entity

//------------------------------------------------------sql result mapping------------------------------------------------------------
//-----------------------------------------------------mapping for view defects------------------------------------------------------
@SqlResultSetMapping(
		name="DefectViewMapping",
	    classes={
	        @ConstructorResult(
	        		targetClass=ViewDefects.class,
	            columns={
	            	@ColumnResult(name="id", type = long.class),
	            	@ColumnResult(name="name", type = String.class),
	                @ColumnResult(name="type", type = String.class),
	                @ColumnResult(name="error_code", type = String.class),
	                @ColumnResult(name="severity", type = String.class),
	                @ColumnResult(name="sname", type = String.class)
	            }
	        )
	    }
	)

@SqlResultSetMapping(
		name="DefectViewAppMapping",
	    classes={
	        @ConstructorResult(
	        		targetClass=ViewDefectsApp.class,
	            columns={
	            	@ColumnResult(name="id", type = long.class),
	            	@ColumnResult(name="name", type = String.class),
	                @ColumnResult(name="type", type = String.class),
	                @ColumnResult(name="error_code", type = String.class),
	                @ColumnResult(name="severity", type = String.class),
	                @ColumnResult(name="sname", type = String.class)
	            }
	        )
	    }
	)

@SqlResultSetMapping(
		name="DefectViewSeverityMapping",
	    classes={
	        @ConstructorResult(
	        		targetClass=ViewDefectsApp.class,
	            columns={
	            	@ColumnResult(name="id", type = long.class),
	            	@ColumnResult(name="name", type = String.class),
	                @ColumnResult(name="type", type = String.class),
	                @ColumnResult(name="error_code", type = String.class),
	                @ColumnResult(name="severity", type = String.class),
	                @ColumnResult(name="sname", type = String.class)
	            }
	        )
	    }
	)
//-----------------------------------------------------mapping for apppercent(lefttable)------------------------------------------------------
@SqlResultSetMapping(
        name="AppPercentMapping",
        classes={
            @ConstructorResult(
                    targetClass=AppPercent.class,
                columns={
                    @ColumnResult(name="name", type = String.class),
                    @ColumnResult(name="defnum", type = BigInteger.class),
                    @ColumnResult(name="percentage", type = String.class),
                    @ColumnResult(name="critical", type = BigInteger.class),
                    @ColumnResult(name="error", type = BigInteger.class),
                    @ColumnResult(name="warning", type = BigInteger.class)
                }
            )
        }
    )

@SqlResultSetMapping(
		name="AppPercentAppMapping",
	    classes={
	        @ConstructorResult(
	        		targetClass=AppPercentApp.class,
	            columns={
	                @ColumnResult(name="error_code", type = String.class),
	                @ColumnResult(name="defnum", type = BigInteger.class),
	                @ColumnResult(name="percentage", type = String.class)
	            }
	        )
	    }
	)

@SqlResultSetMapping(
		name="AppPercentSeverityMapping",
	    classes={
	        @ConstructorResult(
	        		targetClass=AppPercentSeverity.class,
	            columns={
	                @ColumnResult(name="name", type = String.class),
	                @ColumnResult(name="defnum", type = BigInteger.class),
	                @ColumnResult(name="percentage", type = String.class)
	            }
	        )
	    }
	)
//-----------------------------------------------------mapping for severitypercent(righttable)------------------------------------------------------
@SqlResultSetMapping(
		name="SeverityPercentMapping",
	    classes={
	        @ConstructorResult(
	        		targetClass=SeverityPercent.class,
	            columns={
	                @ColumnResult(name="severity", type = String.class),
	                @ColumnResult(name="defnum", type = BigInteger.class),
	                @ColumnResult(name="percentage", type = String.class)
	            }
	        )
	    }
	)





@SqlResultSetMapping(
		name="SeverityPercentAppMapping",
	    classes={
	        @ConstructorResult(
	        		targetClass=SeverityPercentApp.class,
	            columns={
	                @ColumnResult(name="severity", type = String.class),
	                @ColumnResult(name="defnum", type = BigInteger.class),
	                @ColumnResult(name="percentage", type = String.class)
	            }
	        )
	    }
	)

@SqlResultSetMapping(
		name="SeverityPercentSeverityMapping",
	    classes={
	        @ConstructorResult(
	        		targetClass=SeverityPercentSeverity.class,
	            columns={
	                @ColumnResult(name="severity", type = String.class),
	                @ColumnResult(name="defnum", type = BigInteger.class),
	                @ColumnResult(name="percentage", type = String.class)
	            }
	        )
	    }
	)
//------------------------------------------------------mapping for weekly------------------------------------------------------------

@SqlResultSetMapping(
	       name="WeeklyViewMapping",
	       classes={
	           @ConstructorResult(
	                   targetClass=WeeklyView.class,
	               columns={
	                   @ColumnResult(name="s_name", type = String.class),
	                   @ColumnResult(name="total_weekly", type = int.class)
	               }
	           )
	       }
	   )
//------------------------------------------------------sql query---------------------------------------------------------------------
//------------------------------------------------------queres for viewdefects/app/severity-------------------------------------------
@NamedNativeQuery(name = "DefectInstance.getViewDefects", 
query = "select di.id, ap.name, ap.type, d.error_code, d.severity, s.sname, s.description "
		+"from app ap, defect d, defect_instance di, solution s, log_file l " 
		+"where ap.id=di.appid and d.id=di.defectid and s.id=d.idsolution and l.id=di.log_fileid and ((l.fdate)=:todayDate)"
		+"LIMIT (:limit) OFFSET (:offset)", resultSetMapping = "DefectViewMapping")

@NamedNativeQuery(name = "DefectInstance.getViewDefectsApp", 
query = "select di.id, ap.name, ap.type, d.error_code, d.severity, s.sname, s.description "
+ "from app ap, defect d, defect_instance di, solution s , log_file l"
+ " where ((ap.name)=:appName) and d.id=di.defectid and s.id=d.idsolution and l.id=di.log_fileid and  ((l.fdate)=:todayDate) "
+" LIMIT (:limit) OFFSET (:offset)", resultSetMapping = "DefectViewAppMapping")

@NamedNativeQuery(name = "DefectInstance.getViewDefectsSeverity", 
query = "select di.id, ap.name, ap.type, d.error_code, d.severity, s.sname, s.description "
+ "from app ap, defect d, defect_instance di, solution s , log_file l"
+ " where ((d.severity)=:severityName) and d.id=di.defectid and s.id=d.idsolution and l.id=di.log_fileid and  ((l.fdate)=:todayDate) "
+" LIMIT (:limit) OFFSET (:offset)", resultSetMapping = "DefectViewSeverityMapping")

//------------------------------------------------------queres for apppercent/app/severity(lefttable)-------------------------------------------

@NamedNativeQuery(name = "DefectInstance.getAppPercent",
query = "select ap.name, count(*) As defnum,"
+" concat(cast(cast( count(*) as float)/ cast((select count(*) from log_file l ,defect_instance di where l.id=di.log_fileid and  ((l.fdate)=:todayDate)) as float)*100 as decimal(7,2)),'%') AS percentage,"
+" SUM(CASE WHEN (d.id=di.defectid And d.severity = 'Critical' )  THEN 1 ELSE 0 END) AS critical,"
+" SUM(CASE WHEN (d.id=di.defectid And d.severity = 'Error' )THEN 1 ELSE 0 END) AS error,"
+" SUM(CASE WHEN (d.id=di.defectid And d.severity = 'Warning') THEN 1 ELSE 0 END) AS warning"
+" from app ap, defect_instance di, defect d, log_file l"
+" where ap.id=di.appid and d.id=di.defectid and l.id=di.log_fileid and  ((l.fdate)=:todayDate)"
+" group by ap.name",resultSetMapping = "AppPercentMapping")

@NamedNativeQuery(name = "DefectInstance.getAppPercentApp", 
query = "select d.error_code, count(*) As defnum,concat(cast(cast( count(*) as float)/ cast((select count(*) from app ap, defect_instance di, log_file l where ap.id=di.appid and ((ap.name)=:appName) and l.id=di.log_fileid and  ((l.fdate)=:todayDate)) as float)*100 as decimal(7,2)),'%') AS percentage"  
+" from app ap, defect_instance di, defect d, log_file l" 
+" where ap.id=di.appid and ((ap.name)=:appName) and d.id=di.defectid and l.id=di.log_fileid and ((l.fdate)=:todayDate)" 
+" group by error_code ", resultSetMapping = "AppPercentAppMapping")

@NamedNativeQuery(name = "DefectInstance.getAppPercentSeverity", 
query = "select ap.name, count(*) As defnum,concat(cast(cast( count(*) as float)/ cast((select count(*) from defect d, defect_instance di, log_file l where d.id=di.defectid and ((d.severity)=:severityName) and l.id=di.log_fileid and  ((l.fdate)=:todayDate)) as float)*100 as decimal(7,2)),'%') AS percentage"
+" from app ap, defect_instance di, defect d, log_file l" 
+" where ap.id=di.appid and ((d.severity)=:severityName) and d.id=di.defectid and l.id=di.log_fileid and  ((l.fdate)=:todayDate)" 
+" group by ap.name ", resultSetMapping = "AppPercentSeverityMapping")

//---------------------------------------------------------queres for severitypercent/app/severity---------------------------------------------------------------------------

@NamedNativeQuery(name = "DefectInstance.getSeverityPercent", 
query = "select d.severity, count(*) As defnum,concat(cast(cast( count(*) as float)/ cast((select count(*) from defect_instance di, defect d , log_file l where d.id=di.defectid and  l.id=di.log_fileid and  ((l.fdate)=:todayDate)) as float)*100 as decimal(7,2)),'%') AS percentage"
+ " from defect d, defect_instance di, log_file l"
+ " where d.id=di.defectid and l.id=di.log_fileid and  ((l.fdate)=:todayDate)"
+ " group by severity", resultSetMapping = "SeverityPercentMapping")


@NamedNativeQuery(name = "DefectInstance.getSeverityPercentApp",
query ="select d.severity, count(*) As defnum,concat(cast(cast( count(*) as float)/ cast((select count(*) from defect_instance di, log_file l, app ap where ap.id=di.appid and ((ap.name)=:appName) and l.id=di.log_fileid and  ((l.fdate)=:todayDate)) as float)*100 as decimal(7,2)),'%') AS percentage"
+" from defect_instance di, app ap, defect d, log_file l"
+" where d.id=di.defectid and ap.id=di.appid and ((ap.name)=:appName) and l.id=di.log_fileid and ((l.fdate)=:todayDate)"
+" group by severity", resultSetMapping = "SeverityPercentAppMapping")

@NamedNativeQuery(name = "DefectInstance.getSeverityPercentSeverity",
query ="select d.severity, count(*) As defnum,concat(cast(cast( count(*) as float)/ cast((select count(*) from defect_instance di, log_file l, defect d where d.id=di.defectid and ((d.severity)=:severityName) and l.id=di.log_fileid and  ((l.fdate)=:todayDate)) as float)*100 as decimal(7,2)),'%') AS percentage"
+" from defect d, defect_instance di, log_file l"
+" where d.id=di.defectid and ((d.severity)=:severityName) and l.id=di.log_fileid and ((l.fdate)=:todayDate)"
+" group by severity", resultSetMapping = "SeverityPercentSeverityMapping")

//----------------------------------------------------------queryes for weekly---------------------------------------------------------

@NamedNativeQuery(name = "DefectInstance.getWeeklyView",
query = "select d.severity as s_name,  count(*) As total_weekly"
+ " from defect_instance di, defect d, log_file f"
+ " where di.log_fileid=f.id and d.id=di.defectid and f.fdate BETWEEN :weekbefore AND :currdate"
+" group by d.severity" ,resultSetMapping = "WeeklyViewMapping")

//--------------------------------------------------------class------------------------------------------------------------------------

public class DefectInstance  {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
    @JoinColumn(name = "Appid")
    private App app;
	
	@ManyToOne
    @JoinColumn(name = "Defectid")
    private Defect defect;
	
	@ManyToOne
    @JoinColumn(name = "LogFileid")
    private LogFile logfile;
	
//-------------------------------------------------constructors-----------------------------------------------------------------
	
	public DefectInstance() {}
	
	public DefectInstance(long id, App app, Defect defect, LogFile logfile) {
		super();
		this.app = app;
		this.defect = defect;
		this.logfile = logfile;
	}


	
//-------------------------------------------------getters and setters-----------------------------------------------------------
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public Defect getDefect() {
		return defect;
	}

	public void setDefect(Defect defect) {
		this.defect = defect;
	}

	public LogFile getLogfile() {
		return logfile;
	}

	public void setLogfile(LogFile logfile) {
		this.logfile = logfile;
	}
	
}
