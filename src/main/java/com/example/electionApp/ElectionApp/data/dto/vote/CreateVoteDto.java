package com.example.electionApp.ElectionApp.data.dto.vote;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreateVoteDto {

    private  Long id;
    private Date voteStart;
    private Date voteEnd;
    private String verificationCode;
}
