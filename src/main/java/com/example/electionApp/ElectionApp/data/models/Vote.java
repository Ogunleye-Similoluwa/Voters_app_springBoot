package com.example.electionApp.ElectionApp.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
