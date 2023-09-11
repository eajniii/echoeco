package com.project.echoeco.board;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
  private final BoardRepository boardRepository;

  public BoardCreateResponse create(BoardCreateRequest dto) {
    Board board = Board.builder()
        .title(dto.getTitle())
        .contents(dto.getContents())
        .createdAt(LocalDateTime.now())
        .build();

    Board savedArticle = boardRepository.save(board);
    return new BoardCreateResponse();
  }

}