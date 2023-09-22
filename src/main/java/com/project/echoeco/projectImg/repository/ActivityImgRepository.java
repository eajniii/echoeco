package com.project.echoeco.projectImg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.echoeco.activity.entity.Activity;
import com.project.echoeco.projectImg.entity.ActivityImg;

@Repository
public interface ActivityImgRepository extends JpaRepository<ActivityImg, Integer> {

	Optional<ActivityImg> findByActivityAndYorn(Activity activity, String YorN);
}
