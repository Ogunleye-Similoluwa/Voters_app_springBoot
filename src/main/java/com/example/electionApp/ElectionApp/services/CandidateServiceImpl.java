package com.example.electionApp.ElectionApp.services;

import com.example.electionApp.ElectionApp.data.dto.candidate.CandidateDto;
import com.example.electionApp.ElectionApp.data.dto.vote.CastVoteDto;
import com.example.electionApp.ElectionApp.data.models.*;
import com.example.electionApp.ElectionApp.data.repositories.*;
import com.example.electionApp.ElectionApp.exception.CastedVoteException;
import com.example.electionApp.ElectionApp.exception.VoterException;
import com.example.electionApp.ElectionApp.util.CandidateUtil;
import com.example.electionApp.ElectionApp.util.PartyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Autowired
    CastedVoteRepository castedVoteRepository;

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    VotersRepository votersRepository;

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
    public Map<String,String> castVote(CastVoteDto voteDto){
        checkIfCastedVoteInitially(voteDto);
        CastedVote castedVote = new CastedVote(voteDto);
        Vote vote = voteRepository.getVoteByVerificationCode(castedVote.getVerificationCode());
        if(vote != null) {
            if (!Objects.equals(vote.getVoteStart(), LocalDateTime.now())) {
                vote.setStatus(VoteStatus.NOT_STARTED);
                throw new CastedVoteException("You cannot cast a vote yet.");
            } else if (LocalDateTime.now().isAfter(vote.getVoteEnd())) {
                vote.setStatus(VoteStatus.ENDED);
                voteRepository.deleteById(vote.getId());
                throw new CastedVoteException("You cannot cast a vote. Voting period ended");

            } else {
                vote.setStatus(VoteStatus.ONGOING);
                castedVote.setVote(vote);
                castedVoteRepository.save(castedVote);
                Map<String,String> response= new HashMap<>();
                response.put("Success:","You have casted your vote");
                return response;
            }
        }
        else {
            throw new CastedVoteException("Invalid Verification code");
        }
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
    public List<CastVoteDto> getCastedVotesByPartyId(Long partyId) {
        List<CastedVote> castedVotes = castedVoteRepository.getAllByPartyId(partyId);
        List<CastVoteDto> castVoteDtos = castedVotes.stream()
                .map(CastVoteDto::new)
                .toList();
        return castVoteDtos;
    }

    @Override
    public CastVoteDto getCastVoteByUserId(Long userId) {
        AppUser user =  appUserRepository.getAppUserById(userId);
        CastedVote vote = castedVoteRepository.getCastedVoteById(user.getId());
        if (vote != null ) {
            return new CastVoteDto(vote);
        }
        else {
            throw new VoterException("Could not find voter's  cast info");
        }

    }


    @Override
    public List<CastVoteDto> getCastedVotesByPartyName(String partyName) {
        List<CastedVote> castedVotes = castedVoteRepository.getAllByPartyName(partyName);
        List<CastVoteDto> castVoteDtos = castedVotes.stream()
                .map(CastVoteDto::new)
                .toList();
        return castVoteDtos;
    }

    @Override
    public Map<String, String> getVotingResultByPartyName(String partyName) {
        List<CastedVote> castedVotes = castedVoteRepository.getAllByPartyName(partyName);
        if (castedVotes != null) {
            Map<String,String> response= new HashMap<>();
            response.put(partyName,String.valueOf(castedVotes.size()));
            return response;
        }
        else {
            throw new CastedVoteException("Could not fnd party with name: " + partyName);
        }

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
    public CandidateDto getACandidate(Long candidateId) {
       Candidate  candidate = candidateUtil.getCandidateById(candidateId);

        CandidateDto candidateDto = new CandidateDto();
        candidateDto.setFirstName(candidate.getFirstName());
        candidateDto.setLastName(candidate.getLastName());
        candidateDto.setPartyName(candidate.getParty().getName());
        candidateDto.setPosition(candidate.getPosition());
        return candidateDto;
    }



    @Override
    public Candidate updateCandidateInfo(Long candidateId) {
        return null;
    }

    private void checkIfCastedVoteInitially(CastVoteDto castVoteDto){
       boolean exists = castedVoteRepository.existsById(castVoteDto.getId());
        if(exists){
            throw  new CastedVoteException("You can't cast vote twice");
        }
    }
}
