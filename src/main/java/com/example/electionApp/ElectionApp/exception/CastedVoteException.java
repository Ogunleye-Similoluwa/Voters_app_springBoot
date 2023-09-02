package com.example.electionApp.ElectionApp.exception;

public class CastedVoteException extends RuntimeException{
    public CastedVoteException(String message){
        super(message);
    }

    public CastedVoteException  castedVoteNotFoundException(String message){
        return new  CastedVoteException(message);
    }
}
