package com.project.echoeco.activity.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.echoeco.activity.entity.Activity;
import com.project.echoeco.activity.entity.State;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
	@Query("SELECT DISTINCT a FROM Activity a "  +
		       "WHERE (a.title LIKE CONCAT('%', :kw, '%') " +
		       "OR a.contents LIKE CONCAT('%', :kw, '%')) " +
		       "AND a.state = :state ")
	    List<Activity> findAllActivitiesWithKeywordAndState(
	        @Param("kw") String keyWord, 
	        @Param("state") State state);
		@Query("select distinct a from Activity a " +
				"where (a.title  LIKE CONCAT('%', :kw, '%') "+ 
				"OR a.contents LIKE CONCAT('%', :kw, '%')) ")
		List<Activity> findAllActivityWithKeyWord(
		    @Param("kw") String keyWord);
		
		List<Activity> findByState(State state);
}
