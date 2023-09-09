package com.project.echoeco.board;



import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class CommentDTO {

	@NotNull(message = "내용을 입력해주세요.")
	private String content;
	
	public void Comment(CommentDTO commentDTO) {
		this.content = commentDTO.getContent();
		
	}
}
