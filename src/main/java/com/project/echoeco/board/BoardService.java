package com.project.echoeco.board;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.echoeco.common.exception.AppException;
import com.project.echoeco.common.exception.ErrorCode;
import com.project.echoeco.member.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
  private final BoardRepository boardRepository;
  private final MemberRepository memberRepository;

  public BoardCreateResponse create(BoardCreateRequest boardCreate) {
    Board board = Board.builder()
        .title(boardCreate.getTitle())
        .contents(boardCreate.getContents())
        .createdAt(LocalDateTime.now())
        .build();

    Board savedArticle = boardRepository.save(board);
    return new BoardCreateResponse();
  }
  
  //게시글 수정
  @Transactional	//service에 @transactional 이 붙으면 메서드가 시작될 때 save메서드가 함께 실행됨
  public void edit(Long id,BoardEdit boardEdit) {
	  Board board = boardRepository.findById(id)
			  .orElseThrow(()->new AppException(ErrorCode.ID_NOT_FOUND, "해당하는 id를 찾을 수 없습니다."));

	  BoardEdit.BoardEditBuilder boardEditBuilder =board.toEditor();
	  
	  BoardEdit boardEditor = boardEditBuilder
			  .contents(boardEdit.getContents())
			  .build();
			  
	  board.edit(boardEditor);
			  
  }
  
  
  //게시글 삭제
  public void delete(Board board) {
	  this.boardRepository.delete(board);
  }
  
  //게시글 한 개 조회
  public Board getBoard(Long id) {
	  Optional<Board> one = this.boardRepository.findById(id);
	  if(one.isPresent()) {
		  return one.get();
	  }else {
		  throw new AppException(ErrorCode.DATA_NOT_FOUND,"게시글을 찾을 수 없습니다.");
	  }
  }
  
  //내가 쓴 게시글 조회
//  public ResponseEntity<List<Board>> myboard(UserPrincipal userPrincipal){
//	  Member member = memberRepository.findByEmail(userPrincipal.getEmail())
//	  List<Board>
//  } userPrincipal.java 필요

}