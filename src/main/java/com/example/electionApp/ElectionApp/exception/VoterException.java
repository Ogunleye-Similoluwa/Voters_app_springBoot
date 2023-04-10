package com.example.electionApp.ElectionApp.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class VoterException extends RuntimeException{

    public VoterException(String message){
        super(message);
    }
}
