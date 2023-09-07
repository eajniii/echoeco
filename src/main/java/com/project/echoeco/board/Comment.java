package com.project.echoeco.board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.echoeco.common.BaseTime;
import com.project.echoeco.member.Member;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@Entity
@SuperBuilder
@Table(name = "comment")
public class Comment extends BaseTime{
	

	@Id
	@Column(name = "content_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//작성자(one) 댓글(many)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_name")
	private Member member;
	
	private String content;
	
	//create_date -> extends basetime 
	
	//@JoinColumn 에 해당하는 컬럼은 FK 가 있는 컬럼
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "board_id")
	private Board board_id; //댓글은 하나의 게시글에 여러 개 달 수 있기 때문에 댓글(many) 게시글(one)
	
	
}
