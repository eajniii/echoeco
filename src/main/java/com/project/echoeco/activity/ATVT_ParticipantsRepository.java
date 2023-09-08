package com.project.echoeco.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ATVT_ParticipantsRepository extends JpaRepository<Activity_Member,Integer> {

}
