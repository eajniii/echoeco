package com.project.echoeco.comment;

import lombok.Getter;

@Getter
public class CommentCreateRequest {
  private Integer boardId;
  private String contents;

}
