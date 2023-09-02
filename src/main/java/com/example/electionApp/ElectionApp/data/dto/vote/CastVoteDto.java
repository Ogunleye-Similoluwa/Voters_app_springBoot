package com.example.electionApp.ElectionApp.data.dto.vote;

import com.example.electionApp.ElectionApp.data.models.CastedVote;
import com.example.electionApp.ElectionApp.data.models.Vote;
import jakarta.persistence.OneToOne;
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
public class CastVoteDto {
    private  Long id;
    private String partyName;
    @UpdateTimestamp
    private LocalDateTime timeCast;
    private String votingDistrict;
    private String verificationCode;

        public CastVoteDto(CastedVote castVote) {
            partyName = castVote.getPartyName();
            timeCast = castVote.getTimeCast();
            votingDistrict = castVote.getVotingDistrict();
            verificationCode = castVote.getVerificationCode();
        }
    }
