package com.ms.userservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user-master")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long userId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ABOUT")
    private String about;




}
