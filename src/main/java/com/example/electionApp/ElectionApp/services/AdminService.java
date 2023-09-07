package com.example.electionApp.ElectionApp.services;

import com.example.electionApp.ElectionApp.data.dto.candidate.CandidateDto;
import com.example.electionApp.ElectionApp.data.dto.party.PartyDto;
import com.example.electionApp.ElectionApp.data.dto.vote.CastVoteDto;
import com.example.electionApp.ElectionApp.data.dto.vote.CreateVoteDto;
import com.example.electionApp.ElectionApp.data.models.Party;

import java.util.List;
import java.util.Map;


public interface AdminService {

   void createParty(PartyDto party);

   Map<String, String> createVote(CreateVoteDto vote);

   Map<String, String> updateParty(Party party);

   Map<String, String> deleteParty(Party party);
   PartyDto getPartyByPartyId(Long partyId);

   List<PartyDto> viewAllParties();

   List<CastVoteDto> getAllVotes();

   List<CastVoteDto> getCastedVotesByPartyId(Party party);

   List<CastVoteDto> getCastedVotesByPartyName(Party party);

   Map<String, String> removeCandidateFromAParty(Long candidateId,Long partyId);

   Map<String, String> addCandidateToAParty(Long candidateId,Long partyId);

}
