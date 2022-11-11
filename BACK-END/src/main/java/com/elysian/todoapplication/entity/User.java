package com.elysian.todoapplication.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "contactno", nullable = false)
    private String contactno;

    @Column(name = "type", nullable = false)
    @Value("${user.type}")
    private String type;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password" , nullable = false)
    private String password;

    public User(int userid) {
        this.userid = userid;
    }

    @ManyToMany
    private Set<Work> assignedWorks = new HashSet<>();

    @OneToMany
    private Set<Work> createdWorks = new HashSet<>();
}
