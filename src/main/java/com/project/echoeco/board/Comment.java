package com.project.echoeco.board;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@Column(name = "content_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//name -> extends basemember
	
	private String content;
	
	//create_date -> extends basetime 
	
	@ManyToOne
	private Board board; //댓글은 하나의 게시글에 여러개 달 수 있기 때문에 댓글(many) 게시글(one)
	
	@Builder
	public Comment(String content) {
		this.content = content;
	}
	
}
