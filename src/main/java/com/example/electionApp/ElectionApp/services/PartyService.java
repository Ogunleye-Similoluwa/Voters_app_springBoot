package com.example.electionApp.ElectionApp.services;

import com.example.electionApp.ElectionApp.data.dto.candidate.CandidateDto;
import com.example.electionApp.ElectionApp.data.models.Party;

import java.util.List;
import java.util.Map;

public interface PartyService {




    CandidateDto viewCandidateInfoInAParty(Long candidateId);

    List<CandidateDto> getCandidatesInAPartyByPartyId(Long partyId);



}
