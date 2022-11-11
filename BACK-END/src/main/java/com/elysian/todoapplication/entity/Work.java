package com.elysian.todoapplication.entity;

//import require classes

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//Annotation
@Entity
@Table(name = "work")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "workdate", nullable = false)
    private String workdate;

    @Column(name = "worktime", nullable = false)
    private String worktime;

    @Column(name = "worknote", nullable = false)
    private String worknote;

    @Column(name = "worktype", nullable = false)
    private String worktype;

    @Column(name = "createdate")
    private String createDate;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    @ManyToMany
    @JoinTable(name = "assign",joinColumns = {@JoinColumn(name = "workid")},inverseJoinColumns = {@JoinColumn(name = "userid")})
    private Set<User> assignedUsers = new HashSet<>();
}
