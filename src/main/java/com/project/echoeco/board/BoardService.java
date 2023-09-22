package com.project.echoeco.board;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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

	public void modifyBoard(Integer BoardIdx, BoardCreateRequest boardDTO) {
		Optional<Board> board = this.boardRepository.findById(BoardIdx);
		if(board.isEmpty()) {
			throw new NullPointerException();
		}else {
			Board modifyBoard = board.get().toBuilder()
					.modifiedAt(LocalDateTime.now())
					.modifiedBy(null)
					.contents(boardDTO.getContents())
					.title(boardDTO.getTitle()).build();
			this.boardRepository.save(modifyBoard);
		}
		
	}

}
