package com.example.electionApp.ElectionApp.services;

import com.example.electionApp.ElectionApp.data.dto.candidate.CandidateDto;
import com.example.electionApp.ElectionApp.data.dto.vote.VoteDto;
import com.example.electionApp.ElectionApp.data.models.Candidate;
import com.example.electionApp.ElectionApp.data.models.Party;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public interface CandidateService {

    Map<String, String>joinAParty(Long partyId, Long candidateId);

    VoteDto trackAPartyVote(Long partyId);

    VoteDto trackAllPartyVote();

    Long getVotingResult(Long voteId, Long partyId);

    List<CandidateDto> getAllCandidates();

    CandidateDto getOneCandidate (Long candidateId);

    Date getElectionDate();

    Candidate updateCandidate (Long candidateId);


}
