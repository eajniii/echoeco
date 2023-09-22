package com.project.echoeco.activity.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.echoeco.activity.entity.Activity;
import com.project.echoeco.activity.entity.State;
import com.project.echoeco.common.constant.ProjectStatus;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
	@Query("SELECT DISTINCT a FROM Activity a "  +
		       "WHERE (a.title LIKE %:kw% " +
		       "OR a.contents LIKE %:kw%) " +
		       "AND a.state = :state ")
	    Page<Activity> findAllActivitiesWithKeywordAndState(
	        @Param("kw") String keyWord, 
	        @Param("state") State state,
	        Pageable pageable);
		@Query("select distinct a from Activity a " +
				"where a.title  LIKE %:kw% "+ 
				"OR a.contents LIKE %:kw%")
		Page<Activity> findAllActivityWithKeyWord(
		    @Param("kw") String keyWord,
	        Pageable pageable);
		
		List<Activity> findByProjectStatus(ProjectStatus status);
}
