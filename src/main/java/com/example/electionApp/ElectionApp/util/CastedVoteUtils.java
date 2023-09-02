package com.example.electionApp.ElectionApp.util;


import com.example.electionApp.ElectionApp.data.models.Candidate;
import com.example.electionApp.ElectionApp.data.models.CastedVote;
import com.example.electionApp.ElectionApp.data.repositories.CastedVoteRepository;
import com.example.electionApp.ElectionApp.exception.CastedVoteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CastedVoteUtils {
    @Autowired
    CastedVoteRepository repository;

    public List<CastedVote> getAllCasted() {
        return repository.findAll();
    }

    public void checkIfCastedVoteExistsById(Long id){
        Optional<CastedVote> vote = repository.findById(id);
        if (vote.isEmpty()){
            throw new CastedVoteException("The Vite" + id + " does not exist");
        }
    }

    public CastedVote getCastedVoteById(Long id){
        checkIfCastedVoteExistsById(id);
        return repository.getCastedVoteById(id);
    }
}