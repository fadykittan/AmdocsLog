package com.example.DataBase.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DataBase.Mapping.WeeklyView;
import com.example.DataBase.Repository.DefectInstanceRepository;

@RestController
public class WeeklyViewController {

	@Autowired
	private DefectInstanceRepository repository;

	@RequestMapping("/WeeklyView")
	public ArrayList<WeeklyView> getWeeklyView1() {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(Calendar.getInstance().getTime());
		calendar.add(Calendar.DATE, -7);
		return repository.getWeeklyView(dateformat.format(Calendar.getInstance().getTime()),
				dateformat.format(calendar.getTime()));

	}
}