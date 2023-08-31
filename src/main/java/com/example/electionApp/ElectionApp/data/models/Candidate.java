package com.example.electionApp.ElectionApp.data.models;

import com.example.electionApp.ElectionApp.exception.PartyException;
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
public class Candidate {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private AppUser appUser;
    @OneToOne
    private Party party;

    private String firstName;

    private String lastName;

    private String position;

}
