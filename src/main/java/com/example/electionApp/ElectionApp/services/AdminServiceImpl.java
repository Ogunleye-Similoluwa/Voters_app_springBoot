package com.example.electionApp.ElectionApp.services;

import com.example.electionApp.ElectionApp.data.dto.candidate.CandidateDto;
import com.example.electionApp.ElectionApp.data.dto.party.PartyDto;
import com.example.electionApp.ElectionApp.data.dto.vote.CastVoteDto;
import com.example.electionApp.ElectionApp.data.dto.vote.CreateVoteDto;
import com.example.electionApp.ElectionApp.data.models.*;
import com.example.electionApp.ElectionApp.data.repositories.CastedVoteRepository;
import com.example.electionApp.ElectionApp.data.repositories.PartyRepository;
import com.example.electionApp.ElectionApp.exception.PartyException;
import com.example.electionApp.ElectionApp.exception.VoterException;
import com.example.electionApp.ElectionApp.util.CandidateUtil;
import com.example.electionApp.ElectionApp.util.CastedVoteUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    PartyRepository partyRepository;

    @Autowired
    CastedVoteRepository castedVoteRepository;

    @Autowired
    CastedVoteUtils castedVoteUtils;

    @Autowired
    CandidateUtil candidateUtil;
    @Override
    public void createParty(PartyDto partyDto) {
        Party party = new Party();
        party.setName(partyDto.getName());
        party.setMotto(partyDto.getMotto());
        party.setFoundingDate(LocalDate.now());
        partyRepository.save(party);
    }

    @Override
    public Map<String, String> createVote(CreateVoteDto createVote) {
        Vote vote  = new Vote();
        vote.setVoteStart(createVote.getVoteStart());
        vote.setVoteEnd(createVote.getVoteEnd());
        if(!Objects.equals(vote.getVoteStart(), LocalDateTime.now())){
            vote.setStatus(VoteStatus.NOT_STARTED);
        }
        else if(Objects.equals(vote.getVoteStart(), LocalDateTime.now())){
            throw new VoterException("You can't create a vote that starts now");
        }
        String verificationCode = RandomStringUtils.random(8,true,true);
        vote.setVerificationCode(verificationCode);
        Map<String,String> response = new HashMap<>();
        response.put("Details:","Successfully created a vote");
        return response;
    }

    @Override
    public Map<String, String> updateParty(Party party) {
       Party party1 = partyRepository.getPartyById(party.getId());
       party1.setName(party.getName());
       party1.setMotto(party.getMotto());
        partyRepository.save(party1);
        Map<String,String> response = new HashMap<>();
        response.put("Details:","Successfully updated party");
        return response;
    }

    @Override
    public PartyDto getPartyByPartyId(Long partyId) {
        Party party1 = partyRepository.getPartyById(partyId);
        if (party1 != null) {
            PartyDto partyDto = new PartyDto(party1);
            return partyDto;
        }
        else {
           throw new PartyException("Could not find party with id : " + partyId) ;
        }
    }

    @Override
    public Map<String, String> deleteParty(Party party) {
        Party party1 = partyRepository.getPartyById(party.getId());
       partyRepository.deleteById(party1.getId());

        Map<String,String> response = new HashMap<>();
        response.put("Details:","Successfully removed party");
        return response;
    }

    @Override
    public List<PartyDto> viewAllParties() {
        List<Party> parties = partyRepository.findAll();
        List<PartyDto> partyDtos = parties.stream()
                .map(PartyDto::new)
                .toList();

        return partyDtos;
    }

    @Override
    public List<CastVoteDto> getAllVotes() {
        List<CastedVote> castedVotes = castedVoteRepository.getAll();
        List<CastVoteDto> castVoteDtos = castedVotes.stream()
                .map(CastVoteDto::new)
                .toList();
        return castVoteDtos;
    }

    @Override
    public List<CastVoteDto> getCastedVotesByPartyId(Party party) {
        List<CastedVote> castedVotes = castedVoteRepository.getAllByPartyId(party.getId());
        List<CastVoteDto> castVoteDtos = castedVotes.stream()
                .map(CastVoteDto::new)
                .toList();
        return castVoteDtos;
    }
    @Override
    public List<CastVoteDto> getCastedVotesByPartyName(Party party) {
        List<CastedVote> castedVotes = castedVoteRepository.getAllByPartyName(party.getName());
        List<CastVoteDto> castVoteDtos = castedVotes.stream()
                .map(CastVoteDto::new)
                .toList();
        return castVoteDtos;
    }

    @Override
    public Map<String, String> removeCandidateFromAParty(Long candidateId,Long partyId) {
        Party party1 = partyRepository.getPartyById(partyId);
        Candidate  candidate = candidateUtil.getCandidateById(candidateId);
        party1.getCandidates().removeIf(candidate1 -> Objects.equals(candidate1.getId(), candidate.getId()));
        Map<String,String> response = new HashMap<>();
        response.put("Details:","Successfully removed candidate from : " + party1.getName());
        return response;

    }
    @Override
    public Map<String, String> addCandidateToAParty(Long candidateId,Long partyId) {
        Party party1 = partyRepository.getPartyById(partyId);
        Candidate candidate = candidateUtil.getCandidateById(candidateId);
        party1.getCandidates().add(candidate);
        Map<String,String> response = new HashMap<>();
        response.put("Details:","Successfully Added candidate to : " + party1.getName());
        return response;

    }


}
