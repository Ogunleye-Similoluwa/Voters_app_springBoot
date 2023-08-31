package com.example.electionApp.ElectionApp.services;

import com.example.electionApp.ElectionApp.data.dto.party.PartyDto;
import com.example.electionApp.ElectionApp.data.dto.vote.CreateVoteDto;
import com.example.electionApp.ElectionApp.data.dto.vote.VoteDto;
import com.example.electionApp.ElectionApp.data.models.Party;
import com.example.electionApp.ElectionApp.data.models.Vote;

import java.util.List;


public interface AdminService {

   void createParty(PartyDto party);

   VoteDto createVote(CreateVoteDto vote);

   PartyDto updateParty(Party party);

   void deleteParty(Party party);

   List<PartyDto> viewAllParties();

   List<Vote> getAllVotes();
   List<Vote> getVoteByPartyId(Party party);

}
