package com.example.electionApp.ElectionApp.data.dto.vote;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreateVoteDto {

    private  Long id;
    private LocalDateTime voteStart;
    private LocalDateTime voteEnd;
    private String verificationCode;
}
