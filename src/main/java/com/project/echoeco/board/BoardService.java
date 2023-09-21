package com.project.echoeco.board;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.echoeco.common.exception.AppException;
import com.project.echoeco.common.exception.ErrorCode;

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

		boardRepository.save(board);
		return new BoardCreateResponse();
	}

	public Board FindByIdBoard(Integer idx) throws Exception {
		Optional<Board> _board = this.boardRepository.findById(idx);
		if (_board.isEmpty()) {
			throw new NullPointerException();
		} else {
			return _board.get();
		}
	}

	public List<Board> FindAllBoard(String kw) {
		List<Board> board = this.boardRepository.findAllBoardByKeyWord(kw);
		Collections.sort(board, Comparator.comparing(Board::getCreatedAt));
		return board;
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

	// public void modified(String email, Integer BoardIdx, BoardCreateRequest dto)
	// {
	// Optional<Board> _board = this.boardRepository.findById(BoardIdx);
	// if (_board.isEmpty()) {
	// throw new NullPointerException("삭제된 게시물입니다.");
	// } else {
	// Board board = _board.get();
	// if (board.getCreatedBy().equals(email)) {
	// board.builder().title(dto.getTitle())
	// .contents(dto.getContents())
	// .modifiedAt(LocalDateTime.now())
	// .modifiedBy(email)
	// .build();
	// this.boardRepository.save(board);
	// } else {
	// throw new AccessDeniedException("권한이 없는 계정입니다.");
	// }
	// }
	// }
}
