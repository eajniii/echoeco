package com.project.echoeco.comment;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.echoeco.board.Board;
import com.project.echoeco.board.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

  private final BoardRepository boardRepository;
  private final CommentRepository commentRepository;

  public CommentCreateResponse createComment(CommentCreateRequest dto) {
    Optional<Board> _board = boardRepository.findById(dto.getBoardId());

    Comment comment = Comment.builder()
        .contents(dto.getContents()) // 코멘트 내용
        .board(_board.get()) // 해당 게시글
        .createdBy(_board.get().getCreatedBy()) // 코멘트 작성자
        .createdAt(LocalDateTime.now()) // 코멘트 작성시간
        .build();

    commentRepository.save(comment);
    return new CommentCreateResponse();

  }

}
