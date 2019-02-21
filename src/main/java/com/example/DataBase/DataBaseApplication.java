package com.example.DataBase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.files.ListFolderContinueErrorException;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.example.DataBase.Repository.AppRepository;
import com.example.DataBase.Repository.DefectInstanceRepository;
import com.example.DataBase.Repository.DefectRepository;
//import com.example.DataBase.Repository.DidoItRepository;
import com.example.DataBase.Repository.LogFileRepository;
import com.example.DataBase.Repository.SolutionRepository;
import com.example.DataBase.Routing.LogFileRouting;

import dropBox.DBClientService;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;


@SpringBootApplication
public class DataBaseApplication {

private static final String ACCESS_TOKEN = "pg0aUInzQ7AAAAAAAAAAvbQZX4_ZpEHduyd6ZXzkoz9wSUFhlshXQtYRjOWyYNyo";

	@Autowired 
  private AppRepository appRepository;

  @Autowired 
  private DefectRepository defectRepository;
  
  @Autowired 
  private LogFileRepository logFileRepository;
  
  @Autowired 
  private DefectInstanceRepository defectInstanceRepository;
	
  @Autowired 
  private SolutionRepository solutionRepository;
  
//  @Autowired 
//  private DidoItRepository didoItRepository;
	
  DBClientService dbClient;
  
	public static void main(String[] args) {
		SpringApplication.run(DataBaseApplication.class, args);
	}
	@Bean
	CommandLineRunner runner() {
		return args -> {
			dbClient = new DBClientService();
			listFilesForFolder(dbClient.result);

		};
	}

	private static String read(InputStream in) throws IOException {
		StringBuilder builder = new StringBuilder();

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		String line = null;
		while ((line = reader.readLine()) != null)
			builder.append(line);

		return builder.toString();
	}

	public void listFilesForFolder(final ListFolderResult result1) {

		System.out.println("listFilesForFolder");
		Calendar cal = null;
		while (true) {
			cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			dbClient = new DBClientService();
			ListFolderResult result=dbClient.result;
			// for (final File fileEntry : result.listFiles()) { //loop on all files

			for(int i=0;i<result.getEntries().size();i++) {
				System.out.println("for (Metadata metadata : result.getEntries())");
				System.out.println( result.getEntries().get(i).getName() );

				doWork(result.getEntries().get(i));
			}
		/*	for (Metadata metadata : result.getEntries()) {
				System.out.println("for (Metadata metadata : result.getEntries())");
				if(result.getEntries().size()>0);
				doWork(metadata);

			}*/
			

			try {
				dbClient.result = dbClient.client.files().listFolderContinue(result.getCursor());
			} catch (ListFolderContinueErrorException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (DbxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// if finish files in directory take break for 10 minuts
			System.out.println("MINUTE " + cal.get(Calendar.MINUTE) + "     Hour" + cal.get(Calendar.HOUR));

			fadyRequest();

			try {

				TimeUnit.MINUTES.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// }

	}

	private void fadyRequest() {
		String fadyUrl = "https://loggitor-be-test.herokuapp.com/runActionSys";

		URL url = null;
		try {
			url = new URL(fadyUrl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpsURLConnection con = null;
		try {
			con = (HttpsURLConnection) url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		InputStream in = null;
		try {
			in = con.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String json = null;
		try {
			json = read(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void doWork(Metadata metadata) {
		// TODO Auto-generated method stub

		try {

			String searchStr = "Caused by";

			LogFileRouting routingtotables = new LogFileRouting();
			System.out.println("almfrod yozbo6!!!    " + metadata.getName());
			// if(FILENAME.getFileName()!=null)
			routingtotables.SearchDefects(metadata, searchStr, appRepository, defectRepository, logFileRepository,
					defectInstanceRepository, solutionRepository);

			System.out.println("Hello Sprint Boot");
		} catch (Exception e) {
			System.out.println("Error!!!");
			e.printStackTrace();
		}
	}

}


