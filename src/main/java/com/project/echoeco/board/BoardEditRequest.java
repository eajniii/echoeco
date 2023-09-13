package com.project.echoeco.board;

import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardEditRequest { //필요없는 코드가 추가되지 않도록 게시글 수정 request 분리하여 작업

	@NotBlank(message = "내용이 입력되지 않았습니다.")
	private String contents;
	
	@Builder
	public BoardEditRequest(String contents) {
		this.contents = contents;
	}
}
