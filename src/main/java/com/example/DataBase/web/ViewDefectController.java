package com.example.DataBase.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.DataBase.Repository.DefectInstanceRepository;
import com.example.DataBase.domain.ViewDefects;
import com.example.DataBase.domain.ViewDefectsApp;

@RestController
public class ViewDefectController {
	@Autowired
	private DefectInstanceRepository repository;

	@Autowired
	private DefectInstanceRepository repositoryApp;

	@Autowired
	private DefectInstanceRepository repositorySeverity;
	
	@RequestMapping("/ViewDefects/{pageSize}/{PageNumber}")

	@ResponseBody
	public ArrayList<ViewDefects> getViewDefects(@PathVariable("pageSize") int pageSize,
			@PathVariable("PageNumber") int pageNumber) throws ServletException {

		//SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		int limit = pageSize;
		int offset = pageNumber - 1;
		offset = offset * limit;
		return repository.getViewDefects(/* dateformat.format(Calendar.getInstance().getTime()) */"2019-02-11", limit,
				offset);
	}

	

	@RequestMapping("/ViewDefectsApp/{appName}/{pageSize}/{PageNumber}")
	public ArrayList<ViewDefectsApp> getViewDefectsApp(@PathVariable String appName, @PathVariable("pageSize") int pageSize,
			@PathVariable("PageNumber") int pageNumber) throws ServletException{
		
		//SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		int limit = pageSize;
		int offset = pageNumber - 1;
		offset = offset * limit;
		return repositoryApp.getViewDefectsApp(appName,/*dateformat.format(Calendar.getInstance().getTime())*/"2019-02-11", limit, offset);

	}

	
	@RequestMapping("/ViewDefectsSeverity/{severityName}/{pageSize}/{PageNumber}")
	public ArrayList<ViewDefectsApp> getViewDefectsSeverity(@PathVariable String severityName, @PathVariable("pageSize") int pageSize,
			@PathVariable("PageNumber") int pageNumber) throws ServletException{
		
		//SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		int limit = pageSize;
		int offset = pageNumber - 1;
		offset = offset * limit;
		return repositorySeverity.getViewDefectsSeverity(severityName,/*dateformat.format(Calendar.getInstance().getTime())*/"2019-02-11", limit, offset);

	}
}
