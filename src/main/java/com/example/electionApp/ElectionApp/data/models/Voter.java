package com.example.electionApp.ElectionApp.data.models;

import com.example.electionApp.ElectionApp.data.dto.request.RegisterRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Voter {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private AppUser user;

    private String name;

    private int age;

    private String address;

    private String occupation;

    private String phoneNumber;

    private String email;

    @OneToOne
    private Party party;



    }
