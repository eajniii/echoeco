package com.project.echoeco.board;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
	
	@Query("select distinct b from Board b "+
			"where (b.contents like %:kw% "+
			"or b.title like %:kw%)")
	List<Board> findAllBoardByKeyWord(
			@Param("kw")String keyWord
			);

}
