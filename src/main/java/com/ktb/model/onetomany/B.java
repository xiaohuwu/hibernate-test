package com.ktb.model.onetomany;

import javax.persistence.*;

@Entity
public class B {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    public A a;
}
