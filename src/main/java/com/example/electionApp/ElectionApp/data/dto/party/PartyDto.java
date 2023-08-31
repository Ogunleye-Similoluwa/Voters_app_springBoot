package com.example.electionApp.ElectionApp.data.dto.party;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartyDto {

    private Long id;
    private String name;
    private String motto;
    @CreationTimestamp
    private Date foundingDate;
}
