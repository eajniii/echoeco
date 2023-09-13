package com.project.echoeco.board;

import javax.persistence.Column;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardEdit {//수정할 필드만 선언하기 위해 도메인 작성

	@Column(columnDefinition = "text")
	private String contents;
	
	@Builder
	public BoardEdit(String contents) {
		this.contents = contents;
	}
}
