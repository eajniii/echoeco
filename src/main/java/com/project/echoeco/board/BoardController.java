package com.project.echoeco.board;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.echoeco.comment.CommentCreateRequest;
import com.project.echoeco.comment.CommentCreateResponse;
import com.project.echoeco.comment.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {
  private final BoardService boardService;
  private final CommentService commentService;

  @PostMapping("/create")
  public ResponseEntity<BoardCreateResponse> newArticle(Authentication authentication,
      @RequestBody BoardCreateRequest dto) {
    return ResponseEntity.ok().body(boardService.create(dto));
  }

  // 댓글 생성
  @PostMapping("/{id}/comment")
  public ResponseEntity<CommentCreateResponse> add(@RequestBody CommentCreateRequest commentCreateRequest) {
    return ResponseEntity.ok().body(commentService.createComment(commentCreateRequest));
  }
}
