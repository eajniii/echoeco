package com.project.echoeco.board;

import javax.validation.constraints.NotNull;

import com.project.echoeco.common.BaseMember;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponse{

	private String title;	

	private String content;
		

}
