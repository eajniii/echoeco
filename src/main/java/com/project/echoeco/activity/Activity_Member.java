package com.project.echoeco.activity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.echoeco.member.Member;

@Entity
@Table(name="Participate")
public class Activity_Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idx;
	
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "ACTIVITY_ID")
    private Activity activity;
}
