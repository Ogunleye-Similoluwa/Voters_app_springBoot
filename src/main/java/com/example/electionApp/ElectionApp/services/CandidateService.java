package com.example.electionApp.ElectionApp.services;

import com.example.electionApp.ElectionApp.data.dto.candidate.CandidateDto;
import com.example.electionApp.ElectionApp.data.dto.vote.CastVoteDto;
import com.example.electionApp.ElectionApp.data.models.Candidate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public interface CandidateService {

    Map<String, String>joinAParty(Long partyId, Long candidateId);

    List<CastVoteDto> getCastedVotesByPartyName(String partyName);

    Map<String, String> getVotingResultByPartyName(String partyName);
    List<CastVoteDto> getAllVotes();
    List<CastVoteDto> getCastedVotesByPartyId(Long partyId);

    CastVoteDto getCastVoteByUserId(Long userId);

    List<CandidateDto> getAllCandidates();

    CandidateDto getACandidate (Long candidateId);


    Candidate updateCandidateInfo (Long candidateId);

    Map<String,String> castVote(CastVoteDto voteDto);


}
