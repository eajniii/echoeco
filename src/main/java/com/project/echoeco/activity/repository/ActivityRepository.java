package com.project.echoeco.activity.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.echoeco.activity.entity.Activity;
import com.project.echoeco.activity.entity.State;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
	 @Query("select distinct a from Activity a " +
			 "left outer join a.address addr " +
			 "where (a.title like %:kw% " +
			 "or a.contents like %:kw%) " +
			 "and addr.state = :state order by createdAt desc")
	    List<Activity> findAllActivitiesWithKeywordAndState(
	        @Param("kw") String keyWord, 
	        @Param("state") State state);
		@Query("select distinct a from Activity a " +
				"where (a.title like %:kw% " +
				"or a.contents like %:kw%) order by createdAt desc")
		List<Activity> findAllActivityWithKeyWord(
		    @Param("kw") String keyWord);
}
