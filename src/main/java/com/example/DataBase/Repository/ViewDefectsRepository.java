package com.example.DataBase.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.DataBase.domain.ViewDefects;

public interface ViewDefectsRepository extends PagingAndSortingRepository<ViewDefects, Long>{
	
	@Query(nativeQuery = true)
	ArrayList<ViewDefects> getViewDefects();
}
 


