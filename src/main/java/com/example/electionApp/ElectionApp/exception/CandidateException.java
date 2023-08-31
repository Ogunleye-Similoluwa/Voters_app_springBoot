package com.example.electionApp.ElectionApp.exception;


import org.springframework.stereotype.Service;

public class CandidateException extends RuntimeException {
    public CandidateException( String message) {
        super(message);
    }

    public CandidateException candidateNotFoundException(String message){
        return new CandidateException(message);
    }
}
