package com.example.electionApp.ElectionApp.data.dto.vote;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

public class CreateVoteDto {

    private  Long id;


    private String partyName;


    @CreationTimestamp
    private Date voteStart;

    @CreationTimestamp
    private Date voteEnd;

    @UpdateTimestamp
    private Date timeCast;

    private String votingDistrict;

    private String verificationCode;
}
