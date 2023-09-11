package com.project.echoeco.board;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.project.echoeco.comment.Comment;
import com.project.echoeco.common.BaseMember;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
public class Board extends BaseMember {

  @Id
  @Column(name = "boardId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String title;

  @Lob
  private String contents;

  @OneToMany
  private List<Comment> comment;

}
