package com.example.electionApp.ElectionApp.data.dto.party;

import com.example.electionApp.ElectionApp.data.models.Party;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartyDto {

    private Long id;
    private String name;
    private String motto;
    private LocalDate foundingDate;

    public PartyDto(Party party){
        id = party.getId();
        name= party.getName();
        motto = party.getMotto();
        foundingDate= party.getFoundingDate();
    }
}
