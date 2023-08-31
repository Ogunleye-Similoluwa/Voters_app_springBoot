package com.example.electionApp.ElectionApp.data.repositories;

import com.example.electionApp.ElectionApp.data.models.Candidate;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Candidate getCandidateById(Long candidateId);


    List<Candidate> getAllCandidates();
}
