package com.project.echoeco.activity;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.echoeco.common.constant.ProjectStatus;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}
