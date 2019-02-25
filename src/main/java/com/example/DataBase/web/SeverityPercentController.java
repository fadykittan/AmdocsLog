package com.example.DataBase.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DataBase.Mapping.SeverityPercent;
import com.example.DataBase.Mapping.SeverityPercentApp;
import com.example.DataBase.Mapping.SeverityPercentSeverity;
import com.example.DataBase.Repository.DefectInstanceRepository;

@RestController
public class SeverityPercentController {
	@Autowired
	private DefectInstanceRepository repository;
	

	@RequestMapping("/SeverityPercent")
	public ArrayList<SeverityPercent> getSeverityPercent() {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		return repository.getSeverityPercent(dateformat.format(Calendar.getInstance().getTime()));
	}
	
	@RequestMapping("/SeverityPercentApp/{appName}")
	public ArrayList<SeverityPercentApp> getSeverityPercentApp(@PathVariable String appName) {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		return repository.getSeverityPercentApp(appName,dateformat.format(Calendar.getInstance().getTime()));
	}
	
	@RequestMapping("/SeverityPercentSeverity/{severityName}")
	public ArrayList<SeverityPercentSeverity> getSeverityPercentSeverity(@PathVariable String severityName) {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		return repository.getSeverityPercentSeverity(severityName, dateformat.format(Calendar.getInstance().getTime()));
	}
}
