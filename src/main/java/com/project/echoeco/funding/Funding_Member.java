// package com.project.echoeco.funding;

// import java.util.List;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.Table;

// import com.project.echoeco.common.BaseMember;
// import com.project.echoeco.member.Member;

// import groovy.transform.ToString;
// import lombok.experimental.SuperBuilder;

// @Entity
// @SuperBuilder
// @ToString
// @Table(name = "FD_PARTICIPANTS")
// public class Funding_Member extends BaseMember {

// @Id
// @GeneratedValue(strategy = GenerationType.AUTO)
// @Column(name = "FD_MemberId")
// private Integer id;

// @ManyToOne
// @JoinColumn(name = "memberId")
// private List<Member> participants;

// @ManyToOne
// @JoinColumn(name = "fundingId")
// private Funding funding;

// }
