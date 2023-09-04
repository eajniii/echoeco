package com.project.echoeco.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.echoeco.domain.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
