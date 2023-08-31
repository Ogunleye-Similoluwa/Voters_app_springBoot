package com.example.electionApp.ElectionApp.util;


import com.example.electionApp.ElectionApp.data.models.Candidate;
import com.example.electionApp.ElectionApp.data.models.Party;
import com.example.electionApp.ElectionApp.data.repositories.CandidateRepository;
import com.example.electionApp.ElectionApp.data.repositories.PartyRepository;
import com.example.electionApp.ElectionApp.exception.CandidateException;
import com.example.electionApp.ElectionApp.exception.PartyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidateUtil {

    private CandidateException candidateException;

    @Autowired
    CandidateRepository candidateRepository;

    public void checkIfCandidateExistsById(Long id){
        Optional<Candidate> candidate = candidateRepository.findById(id);
        if (candidate.isEmpty()){
            throw candidateException.candidateNotFoundException("The candidate " + id + " does not exist");
        }
    }

    public Candidate getCandidateById(Long id){
        checkIfCandidateExistsById(id);
        return candidateRepository.getCandidateById(id);
    }
}
