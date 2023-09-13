package com.project.echoeco.board;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
	
	Optional<Board> findById(Long id);

	List<Board> findByTitle(String title);
	
	List<Board> findByTitleAndContents(String title,String contents);
}