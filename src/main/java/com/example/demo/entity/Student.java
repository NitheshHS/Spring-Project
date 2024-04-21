package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="Last_NAME")
    private String lastName;
    @Column(name="EMAIL")
    private String email;
    @Column(name="AGE")
    private int age;
}
