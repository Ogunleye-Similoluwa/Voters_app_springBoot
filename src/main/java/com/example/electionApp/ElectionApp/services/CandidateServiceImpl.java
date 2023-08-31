package com.example.electionApp.ElectionApp.services;

import com.example.electionApp.ElectionApp.data.dto.candidate.CandidateDto;
import com.example.electionApp.ElectionApp.data.dto.vote.VoteDto;
import com.example.electionApp.ElectionApp.data.models.Candidate;
import com.example.electionApp.ElectionApp.data.models.Party;
import com.example.electionApp.ElectionApp.data.repositories.CandidateRepository;
import com.example.electionApp.ElectionApp.data.repositories.PartyRepository;
import com.example.electionApp.ElectionApp.util.CandidateUtil;
import com.example.electionApp.ElectionApp.util.PartyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class CandidateServiceImpl implements CandidateService{
    @Autowired
    PartyUtil partyUtils;

    @Autowired
    CandidateUtil candidateUtil;

    @Autowired
    PartyRepository partyRepository;

    @Autowired
    CandidateRepository candidateRepository;

    @Override
    public Map<String,String> joinAParty(Long partyId, Long candidateId) {
        Party party =partyUtils.getPartyById(partyId);
        Candidate candidate =candidateUtil.getCandidateById(candidateId);
        party.getCandidates().add(candidate);
        log.info("Candidate joined party");
        Map<String,String> response= new HashMap<>();

        response.put("Success:","You have joined this party");
        return response;
    }

    @Override
    public VoteDto trackAPartyVote(Long partyId) {
        return null;
    }

    @Override
    public VoteDto trackAllPartyVote() {
        return null;
    }

    @Override
    public Long getVotingResult(Long voteId, Long partyId) {
        return null;
    }

    @Override
    public List<CandidateDto> getAllCandidates() {
        List<Candidate> candidates = candidateRepository.getAllCandidates();
        log.info("Gotten all candidates");
        List<CandidateDto> candidatesDto =  new ArrayList<>();

        for (Candidate candidate: candidates) {
            CandidateDto candidateDto = new CandidateDto();
            candidateDto.setFirstName(candidate.getFirstName());
            candidateDto.setLastName(candidate.getLastName());
            candidateDto.setPartyName(candidate.getParty().getName());
            candidateDto.setPosition(candidate.getPosition());
            candidatesDto.add(candidateDto);
        }
        return candidatesDto;
    }

    @Override
    public CandidateDto getOneCandidate(Long candidateId) {
       Candidate  candidate = candidateUtil.getCandidateById(candidateId);

        CandidateDto candidateDto = new CandidateDto();
        candidateDto.setFirstName(candidate.getFirstName());
        candidateDto.setLastName(candidate.getLastName());
        candidateDto.setPartyName(candidate.getParty().getName());
        candidateDto.setPosition(candidate.getPosition());

        return candidateDto;
    }

    @Override
    public Date getElectionDate() {
        return null;
    }

    @Override
    public Candidate updateCandidate(Long candidateId) {
        return null;
    }
}
