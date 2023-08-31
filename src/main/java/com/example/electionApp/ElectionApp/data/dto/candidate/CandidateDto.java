package com.example.electionApp.ElectionApp.data.dto.candidate;

import com.example.electionApp.ElectionApp.data.models.Party;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CandidateDto {


    private String partyName;

    private String firstName;

    private String lastName;

    private String position;
}
