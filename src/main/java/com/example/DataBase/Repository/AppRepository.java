package com.example.DataBase.Repository;



import java.util.List;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.example.DataBase.domain.App;


public interface AppRepository extends CrudRepository<App, Long>  {
	
	


	@Query(nativeQuery= true, value = "select * from app ap where ap.name= ?1 AND ap.type= ?2  ")
	List<App> checkAppexist(String name, String type);

	
	


}
