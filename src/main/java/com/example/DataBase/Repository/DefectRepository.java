package com.example.DataBase.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.example.DataBase.domain.Defect;

public interface DefectRepository extends CrudRepository<Defect, Long>  {

	@Query(nativeQuery= true, value = "select * from defect d where d.error_code= ?1 and d.idapp= ?2")
	List<Defect> checkDefectexist(String errorCode, Long appid);

	@Query(nativeQuery= true, value = "select * from defect d where d.severity= ?1 and d.error_code= ?2 and d.appid= ?3 ")
	List<Defect> findByDefSeverity(String severity, String error, Long id);

	
}
