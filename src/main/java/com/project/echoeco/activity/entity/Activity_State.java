package com.project.echoeco.activity.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "Address")
@SuperBuilder
@Getter
public class Activity_State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "STATE_ID")
    private State state;

    @OneToOne
    private Activity activity;

}
