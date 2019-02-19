package com.example.DataBase.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.DataBase.Repository.DefectInstanceRepository;
import com.example.DataBase.domain.AppPercent;
import com.example.DataBase.domain.AppPercentApp;
import com.example.DataBase.domain.AppPercentSeverity;

@RestController
public class AppPercentController {
	@Autowired
	private DefectInstanceRepository repository;
	


	@RequestMapping("/AppPercent")
	public ArrayList<AppPercent> getAppPercent() {
		//SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		return repository.getAppPercent(/*dateformat.format(Calendar.getInstance().getTime())*/"2019-02-11");
	}
	
	@RequestMapping("/AppPercentApp/{appName}")
	public ArrayList<AppPercent> getAppPercentApp(@PathVariable String appName) {
		//SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		return repository.getAppPercentApp(appName, /*dateformat.format(Calendar.getInstance().getTime())*/"2019-02-11");
	}
	
	@RequestMapping("/AppPercentSeverity/{severityName}")
	public ArrayList<AppPercent> getAppPercentSeverity(@PathVariable String severityName) {
		//SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		return repository.getAppPercentSeverity(severityName, /*dateformat.format(Calendar.getInstance().getTime())*/"2019-02-11");
	}

}


