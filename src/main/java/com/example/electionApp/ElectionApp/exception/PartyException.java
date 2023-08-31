package com.example.electionApp.ElectionApp.exception;

public class PartyException extends RuntimeException{

    public PartyException(String message) {
        super(message);
    }

    public PartyException partyNotFoundException(String message){
        return new PartyException(message);
    }
}
