package com.project.echoeco.activity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.echoeco.common.BaseProject;
import com.project.echoeco.member.Member;
import com.project.echoeco.projectImg.ProjectImg;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "ATVT_PARTICIPANTS")
@SuperBuilder
@Getter
public class Activity_Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ATVT_MEMBER_ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "ACTIVITY_ID")
    private Activity activity;
}
