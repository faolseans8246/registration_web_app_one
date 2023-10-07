package com.example.repeatprojectsecond.tables;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "userTable")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private long id;

    @Column(unique = false, length = 255)
    private String firstname;

    @Column(unique = false, length = 255)
    private String lastname;

    @Column(unique = false, length = 255)
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
