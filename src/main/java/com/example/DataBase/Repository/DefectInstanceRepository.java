package com.example.DataBase.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.DataBase.Mapping.AppPercent;
import com.example.DataBase.Mapping.AppPercentApp;
import com.example.DataBase.Mapping.SeverityAppPercent;
import com.example.DataBase.Mapping.SeverityPercent;
import com.example.DataBase.Mapping.SeverityPercentApp;
import com.example.DataBase.Mapping.SeverityPercentSeverity;
import com.example.DataBase.Mapping.ViewDefects;
import com.example.DataBase.Mapping.ViewDefectsApp;
import com.example.DataBase.Mapping.WeeklyView;
import com.example.DataBase.domain.DefectInstance;

public interface DefectInstanceRepository extends CrudRepository<DefectInstance, Long> {

	@Query(nativeQuery = true, value = "UPDATE defect_instance " + "SET dido_itid = ?1 "
			+ "from defect_instance di, log_file l "
			+ "WHERE di.log_fileid = l.id and di.appid= ?2 and di.defectid= ?3 and l.fdate=?4")
	void UpdateDefectInstance(Long didoit, Long app, Long defect, String todaydate);

//----------------------------------------------------viewdefects/app/severity----------------------------------------------------------
	@Query(nativeQuery = true)
	ArrayList<ViewDefects> getViewDefects(
			/* @Param("sortedBy") String sortedBy, */ @Param("todayDate") String todayDate, @Param("limit") int limit,
			@Param("offset") int offset);

	@Query(nativeQuery = true)
	ArrayList<ViewDefectsApp> getViewDefectsApp(
			/* @Param("sortedBy") String sortedBy, */ @Param("appName") String appName,
			@Param("todayDate") String todayDate, @Param("limit") int limit, @Param("offset") int offset);

	@Query(nativeQuery = true)
	ArrayList<ViewDefectsApp> getViewDefectsSeverity(
			/* @Param("sortedBy") String sortedBy, */ @Param("severityName") String appName,
			@Param("todayDate") String todayDate, @Param("limit") int limit, @Param("offset") int offset);

//----------------------------------------------------apppercent/app/severity----------------------------------------------------------	

	@Query(nativeQuery = true)
	ArrayList<AppPercent> getAppPercent(@Param("todayDate") String todayDate);

	@Query(nativeQuery = true)
	ArrayList<AppPercentApp> getAppPercentApp(@Param("appName") String appName, @Param("todayDate") String todayDate);

	@Query(nativeQuery = true)
	ArrayList<AppPercent> getAppPercentSeverity(@Param("severityName") String severityName,
			@Param("todayDate") String todayDate);

//----------------------------------------------------severitypercent/app/severity----------------------------------------------------------	

	@Query(nativeQuery = true)
	ArrayList<SeverityPercent> getSeverityPercent(@Param("todayDate") String todayDate);

	@Query(nativeQuery = true)
	ArrayList<SeverityPercentApp> getSeverityPercentApp(@Param("appName") String severityName,
			@Param("todayDate") String todayDate);

	@Query(nativeQuery = true)
	ArrayList<SeverityPercentSeverity> getSeverityPercentSeverity(@Param("severityName") String severityName,
			@Param("todayDate") String todayDate);

//----------------------------------------------------weekly view----------------------------------------------------------	

	@Query(nativeQuery = true)
	ArrayList<WeeklyView> getWeeklyView(@Param("currdate") String currdate, @Param("weekbefore") String weekbefore);

	
	
	
//--------------------------------------------------API for Action----------------------------
	
	
	@Query(nativeQuery = true)
	ArrayList<SeverityAppPercent> getSeverityAppPercentDate(@Param("appName") String appName ,@Param("severity") String severity,@Param("fdate") String fdate);

//	@Query(nativeQuery = true)
//	ArrayList<SeverityAppPercent> getSeverityAppPercent(@Param("appName") String appName ,@Param("severity") String severity);
//
//
//	@Query(nativeQuery = true)
//	ArrayList<SeverityAppPercent> getSeveritiesAppPercent(@Param("appName") String appName);
	
	
	
	
}
