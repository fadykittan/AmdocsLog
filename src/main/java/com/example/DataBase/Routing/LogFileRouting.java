package com.example.DataBase.Routing;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.files.Metadata;
import com.example.DataBase.Repository.AppRepository;
import com.example.DataBase.Repository.DefectInstanceRepository;
import com.example.DataBase.Repository.DefectRepository;
//import com.example.DataBase.Repository.DidoItRepository;
import com.example.DataBase.Repository.LogFileRepository;
import com.example.DataBase.Repository.SolutionRepository;
import com.example.DataBase.domain.App;
import com.example.DataBase.domain.Defect;
import com.example.DataBase.domain.DefectInstance;
//import com.example.DataBase.domain.DidoIt;
import com.example.DataBase.domain.LogFile;
import com.example.DataBase.domain.Solution;

import dropBox.DBClientService;

public class LogFileRouting {

	public static final int ErrorPosition = 3;
	public static final int SeverityPosition = 4;
	public static final int typePosition = 5;

	public List<Defect> defList = new ArrayList<Defect>();
	public List<App> appList = new ArrayList<App>();
	public List<DefectInstance> defInsList = new ArrayList<DefectInstance>();
	public List<LogFile> logFList = new ArrayList<LogFile>();
	public List<Solution> solList = new ArrayList<Solution>();
	DBClientService dbClient=new DBClientService();

//----------------------------------------------------------controller methods-----------------------------------------------------------

	public void SearchDefects(Metadata metadata, String searchStr, AppRepository appRepo, DefectRepository defRepo,
			LogFileRepository logRepo, DefectInstanceRepository definsRepo, SolutionRepository solRepo/*, DidoItRepository didRepo*/) throws Exception

	{

		 String my_link = null;
         URL my_url = null;
         URLConnection conn = null;
         BufferedReader reader = null;
         try {
         	String line="";
             my_link = dbClient.client.files().getTemporaryLink(metadata.getPathLower()).getLink();//.files().getTemporaryLink(metadata.getPathLower()).getLink();
             my_url = new URL (my_link);
             conn = my_url.openConnection();
             reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            /* while( (line = reader.readLine()) != null ) {
             	System.out.println("read!!    "+line);
             }*/
         } catch (DbxException e) {
             e.printStackTrace();
         } catch (MalformedURLException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
		
		int Counter = 0;
		//Scanner scanFile = new Scanner(metadata);
		String line = reader.readLine().toString();

		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm:ss");

		LogFile templogfile = new LogFile(metadata.getName(), dateformat.format(Calendar.getInstance().getTime()),
				timeformat.format(Calendar.getInstance().getTime()));

		Solution tempsol = new Solution();
		tempsol = solRepo.findById((long) 3116).orElse(null);

		//DidoIt didoit = new DidoIt("empty","empty");
		//didRepo.save(didoit);
		while ((line = reader.readLine()) != null) {

			Defect tempDefect = new Defect();
			App tempApp = new App();
			DefectInstance tempDefectInstance = new DefectInstance();

			//line = scanFile.nextLine().toString();
			String arr[] = line.split(" ");

			if (arr.length > ErrorPosition && line.contains(searchStr)) {
				if (arr[ErrorPosition].startsWith("(") && arr[ErrorPosition].endsWith(")")) {
					Counter++;
					int pos = arr[ErrorPosition].indexOf("-");
					String ProgramName = arr[ErrorPosition].substring(1, pos - 1);
					String defCode = arr[ErrorPosition].substring(pos + 1, arr[ErrorPosition].length() - 1);

					tempDefect.setErrorCode(defCode);
					tempApp.setName(ProgramName);

					int redDig = Character.getNumericValue(tempDefect.getErrorCode().charAt(typePosition));
					// level of defect (1-3) critical, (4-6) error, more than 6 warning
					if (0 <= redDig && redDig <= 3) {
						tempDefect.setSeverity("Critical");

					}
					if (4 <= redDig && redDig <= 6) {
						tempDefect.setSeverity("Error");
					}
					if (redDig > 6) {
						tempDefect.setSeverity("Warning");
					}
					if (arr[ErrorPosition].charAt(4) == '1')
						tempApp.setType("Core");
					else
						tempApp.setType("Custom");

					tempDefectInstance.setLogfile(templogfile);

					//tempDefectInstance.setDidoit(didoit);
					// check if app exist in database
					appList = appRepo.checkAppexist(tempApp.getName(), tempApp.getType());
					if (appList.isEmpty()) {
						appRepo.save(tempApp);
						tempDefectInstance.setApp(tempApp);
						tempDefect.setApp(tempApp);
					} else {
						tempDefectInstance.setApp(appList.get(0));
						tempDefect.setApp(appList.get(0));
					}

					tempDefect.setSolution(tempsol);

					// check if defect exist in database
					defList = defRepo.checkDefectexist(tempDefect.getErrorCode(), tempDefect.getApp().getId());
					if (defList.isEmpty()) {
						defRepo.save(tempDefect);
						tempDefectInstance.setDefect(tempDefect);
					} else {
						tempDefectInstance.setDefect(defList.get(0));
					}

					defInsList.add(tempDefectInstance);
				}
			}

		}
		logFList.add(templogfile);
		System.out.println(Counter + " '" + searchStr + "' founded in log file ");
		//scanFile.close();

		logRepo.saveAll(logFList);
		definsRepo.saveAll(defInsList);

		dbClient.client.files().delete(metadata.getPathLower());
	}

}
