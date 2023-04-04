package com.example.practicetask1.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String address;

    private long productId;



}
