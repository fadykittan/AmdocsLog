package com.example.DataBase.web;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DataBase.Mapping.ViewDefects;
import com.example.DataBase.Mapping.ViewDefectsApp;
import com.example.DataBase.Repository.AppRepository;
import com.example.DataBase.Repository.DefectInstanceRepository;
import com.example.DataBase.Repository.DefectRepository;
//import com.example.DataBase.Repository.DidoItRepository;
import com.example.DataBase.Repository.SolutionRepository;
import com.example.DataBase.domain.App;
import com.example.DataBase.domain.Defect;
import com.example.DataBase.domain.DefectInstance;
//import com.example.DataBase.domain.DidoIt;
import com.example.DataBase.domain.Solution;

@RestController
public class ViewDefectController {
	@Autowired
	private DefectInstanceRepository repository;
	
	@Autowired
	private AppRepository Apprepository;
	
	@Autowired
	private DefectRepository Defectrepository;
	
//	@Autowired
//	private DidoItRepository DidoItrepository;


	@RequestMapping("/ViewDefects/{pageSize}/{PageNumber}")
	public ArrayList<ViewDefects> getViewDefects(/*@PathVariable("sortedBy") String sortedBy,*/ @PathVariable("pageSize") int pageSize,
			@PathVariable("PageNumber") int pageNumber) throws ServletException {

		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		int limit = pageSize;
		int offset = pageNumber - 1;
		offset = offset * limit;
		return repository.getViewDefects(/*sortedBy,*/  dateformat.format(Calendar.getInstance().getTime()) , limit,
				offset);
	}

	@RequestMapping("/ViewDefectsApp/{appName}/{pageSize}/{PageNumber}")
	public ArrayList<ViewDefectsApp> getViewDefectsApp(/*@PathVariable("sortedBy") String sortedBy,*/ @PathVariable String appName,
			@PathVariable("pageSize") int pageSize, @PathVariable("PageNumber") int pageNumber)
			throws ServletException {

		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		int limit = pageSize;
		int offset = pageNumber - 1;
		offset = offset * limit;
		return repository.getViewDefectsApp(/*sortedBy,*/ appName,
				 dateformat.format(Calendar.getInstance().getTime()) , limit, offset);

	}

	@RequestMapping("/ViewDefectsSeverity/{severityName}/{pageSize}/{PageNumber}")
	public ArrayList<ViewDefectsApp> getViewDefectsSeverity(/*@PathVariable("sortedBy") String sortedBy,*/ @PathVariable String severityName,
			@PathVariable("pageSize") int pageSize, @PathVariable("PageNumber") int pageNumber)
			throws ServletException {

		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		int limit = pageSize;
		int offset = pageNumber - 1;
		offset = offset * limit;
		return repository.getViewDefectsSeverity(/*sortedBy,*/ severityName,
				 dateformat.format(Calendar.getInstance().getTime()) , limit, offset);

	}
	
//	@RequestMapping(value = "/editDefect", method = RequestMethod.POST)
//    @ResponseBody
//    public boolean addEvent(@RequestBody ViewDefects defectUpdated) {
//        try {
//        
//            String appName = defectUpdated.getAppName();
//            String appType = defectUpdated.getAppType();
//            String defectCode = defectUpdated.getDefCode();
//            String severity = defectUpdated.getSeverity();
//           // String solName = defectUpdated.getSolname();
//            String Idid = defectUpdated.getIdid();
//            String Ido = defectUpdated.getIdo();
//          
//
//            DidoIt didoit = new DidoIt(Idid, Ido);
//            DidoItrepository.save(didoit);
//            
//            List<App> applist = Apprepository.checkAppexist(appName, appType);
//            List<Defect> deflist = Defectrepository.findByDefSeverity(defectCode,severity, applist.get(0).getId());
//            repository.UpdateDefectInstance(didoit.getId() , applist.get(0).getId(), deflist.get(0).getId(), "2019-02-11");
//
//            
//            return true;
//
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//            return false;
//        }
//    }
	
}
