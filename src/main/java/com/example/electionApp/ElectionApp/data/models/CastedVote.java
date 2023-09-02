package com.example.electionApp.ElectionApp.data.models;

import com.example.electionApp.ElectionApp.data.dto.vote.CastVoteDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class CastedVote {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id;


    private String partyName;
    @OneToOne
    private Vote vote;

    @UpdateTimestamp
    private LocalDateTime timeCast;

    private String votingDistrict;

    private String verificationCode;

    public CastedVote(CastVoteDto castVoteDto){
        partyName = castVoteDto.getPartyName();
        vote = castVoteDto.getVote();
        timeCast = castVoteDto.getTimeCast();
        votingDistrict = castVoteDto.getVotingDistrict();
        verificationCode = castVoteDto.getVerificationCode();


    }



}
