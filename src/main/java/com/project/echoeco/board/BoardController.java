package com.project.echoeco.board;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @GetMapping
  public ResponseEntity<List<Board>> boardList(@RequestParam(value = "keyWord", defaultValue = "") String keyWord) {
    List<Board> board = this.boardService.FindAllBoard(keyWord);
    return ResponseEntity.ok().body(board);
  }
}
