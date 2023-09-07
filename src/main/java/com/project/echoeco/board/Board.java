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

import com.project.echoeco.common.BaseMember;
import com.project.echoeco.member.Member;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@Table(name = "board")
public class Board extends BaseMember{

	@Id
	@Column(name = "board_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
		
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_name")
	private Member member;	//작성자
	
	@Column(columnDefinition = "integer default 0")
	private Integer views;
	

//	public Board(String title, String content, Integer views) {
//		Board board = Board.builder()
//				.title(boardDTO.getTitle())
//				.content(boardDTO.getContent())
//				.views(boardDTO.getViews()+1)
//				.build();
//		return board;
//	}
}
