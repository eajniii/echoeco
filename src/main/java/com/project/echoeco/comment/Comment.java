package com.project.echoeco.comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.project.echoeco.board.Board;
import com.project.echoeco.common.BaseMember;

import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
public class Comment extends BaseMember {

  @Id
  @Column(name = "commentId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column
  private String contents;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "boardId")
  private Board board;
}
