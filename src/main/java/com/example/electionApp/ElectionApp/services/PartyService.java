package com.example.electionApp.ElectionApp.services;

import com.example.electionApp.ElectionApp.data.dto.candidate.CandidateDto;
import com.example.electionApp.ElectionApp.data.models.Party;

import java.util.List;

public interface PartyService {

    Party updateParty(Party party);

    CandidateDto removeCandidate(CandidateDto candidate);

    List<Party> viewAllParties();

    CandidateDto viewCandidateInfo(CandidateDto candidate);

    List<CandidateDto> getCandidatesInAPartyByPartyId(Long partyId);

    void addCandidate(CandidateDto candidate);

}
