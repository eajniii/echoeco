package com.project.echoeco.board;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.echoeco.member.Member;
import com.project.echoeco.member.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	private final MemberRepository memberRepository;

	
	public String save(BoardDTO dto) {
	//	Optional<Member> member = memberRepository.findById(dto.getMemberId());
		
		Board board = Board.builder()
				.title(dto.getTitle())
				.content(dto.getContent())
//				.views(dto.getViews()+1)
//				.createdEmail(member.get().getName())
				.created_date(LocalDateTime.now())
				.build();
		
		boardRepository.save(board);
		return "Success";
	}
	

}
