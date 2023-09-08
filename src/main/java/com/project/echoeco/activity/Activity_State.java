package com.project.echoeco.activity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.echoeco.addrEntity.State;

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

    @ManyToOne
    @JoinColumn(name = "ACTIVITY_ID")
    private Activity activity;

}
