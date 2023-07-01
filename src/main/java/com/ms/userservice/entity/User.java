package com.ms.userservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;

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

    @Column(name = "CREATEDDATE")
    @CreationTimestamp
    private LocalDate createData;

    @Column(name = "UPDATEDDATE")
    @UpdateTimestamp
    private LocalDate updateDate;

    @Transient
    private List<Rating> rating;

}
