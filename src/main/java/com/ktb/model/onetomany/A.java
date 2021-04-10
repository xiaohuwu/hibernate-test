package com.ktb.model.onetomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class A {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="a_id")
    public Set<B> bs = new HashSet<B>(0);
}
