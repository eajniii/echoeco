package com.project.echoeco.board;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.project.echoeco.comment.Comment;
import com.project.echoeco.common.BaseMember;
import com.project.echoeco.member.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "board")
public class Board extends BaseMember{

	@Id
	@Column(name = "boardId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 500)
	private String title;
		
	@Lob
	@Column(columnDefinition = "text")
	private String contents;
	
//  basemember - createdby //작성자
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memberId")
	private Member member ;
	
	@Column(columnDefinition = "integer default 0")
	private Integer views;
	
	@OneToMany(mappedBy = "board",cascade = CascadeType.REMOVE)
	private List<Comment> comments = new ArrayList<>(); 
	
    public BoardEdit.BoardEditBuilder toEditor() {
        return BoardEdit.builder()
                .contents(contents);
    }
    
    public void edit(BoardEdit boardEdit) {
    	contents = boardEdit.getContents();
    }
    
}
