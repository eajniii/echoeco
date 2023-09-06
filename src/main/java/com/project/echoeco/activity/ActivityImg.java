package com.project.echoeco.activity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class ActivityImg {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	
	@ManyToOne
	@JoinColumn(name="activity_idx")
	private Activity activity;
	
	//대표이미지 설정
	private String YorN;
	
	private String img;
}
