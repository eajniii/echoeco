package com.project.echoeco.activity.repository;


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
	           "left outer join addr.state state " +
	           "where (a.title like %:kw% " +
	           "or a.contents like %:kw%) " +
	           "and state = :state")
	    Page<Activity> findAllActivitiesWithKeywordAndState(
	        @Param("kw") String keyWord, 
	        @Param("state") State state, 
	        Pageable pageable);
	 
		@Query("select distinct a from Activity a " +
		       "where (a.title like %:kw% " +
		       "or a.contents like %:kw%)")
		Page<Activity> findAllActivityWithKeyWord(
		    @Param("kw") String keyWord,
		    Pageable pageable);
}
