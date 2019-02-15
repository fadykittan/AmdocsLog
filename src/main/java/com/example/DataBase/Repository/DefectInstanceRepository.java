package com.example.DataBase.Repository;

import java.util.ArrayList;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.DataBase.domain.AppPercent;
import com.example.DataBase.domain.AppPercentApp;
import com.example.DataBase.domain.AppPercentSeverity;
import com.example.DataBase.domain.DefectInstance;
import com.example.DataBase.domain.SeverityPercent;
import com.example.DataBase.domain.SeverityPercentApp;
import com.example.DataBase.domain.SeverityPercentSeverity;
import com.example.DataBase.domain.ViewDefects;
import com.example.DataBase.domain.ViewDefectsApp;
import com.example.DataBase.domain.WeeklyView;


public interface DefectInstanceRepository extends CrudRepository<DefectInstance, Long>{

//----------------------------------------------------viewdefects/app/severity----------------------------------------------------------
	@Query(nativeQuery = true)
	ArrayList<ViewDefects> getViewDefects(@Param("todayDate") String todayDate,@Param("limit") int limit,@Param("offset") int offset);
	
	@Query(nativeQuery = true)
	ArrayList<ViewDefectsApp> getViewDefectsApp(@Param("appName") String appName,@Param("todayDate") String todayDate,@Param("limit") int limit,@Param("offset") int offset);
	
	@Query(nativeQuery = true)
	ArrayList<ViewDefectsApp> getViewDefectsSeverity(@Param("severityName") String appName,@Param("todayDate") String todayDate,@Param("limit") int limit,@Param("offset") int offset);
	
//----------------------------------------------------apppercent/app/severity----------------------------------------------------------	
	
	@Query(nativeQuery = true)
	ArrayList<AppPercent> getAppPercent(@Param("todayDate") String todayDate);
	
	@Query(nativeQuery = true)
	ArrayList<AppPercentApp> getAppPercentApp(@Param("appName") String appName, @Param("todayDate") String todayDate);
	
	@Query(nativeQuery = true)
	ArrayList<AppPercentSeverity> getAppPercentSeverity(@Param("severityName") String severityName, @Param("todayDate") String todayDate);
	
//----------------------------------------------------severitypercent/app/severity----------------------------------------------------------	
	
	@Query(nativeQuery = true)
	ArrayList<SeverityPercent> getSeverityPercent(@Param("todayDate") String todayDate);
	
	@Query(nativeQuery = true)
	ArrayList<SeverityPercentApp> getSeverityPercentApp(@Param("appName") String severityName, @Param("todayDate") String todayDate);

	@Query(nativeQuery = true)
	ArrayList<SeverityPercentSeverity> getSeverityPercentSeverity(@Param("severityName") String severityName, @Param("todayDate") String todayDate);
	
	@Query(nativeQuery = true)
    ArrayList<WeeklyView> getWeeklyView(@Param("currdate") String currdate, @Param("weekbefore") String weekbefore);
	

	
}
