package com.example.electionApp.ElectionApp.services;

import com.example.electionApp.ElectionApp.data.dto.party.PartyDto;
import com.example.electionApp.ElectionApp.data.dto.vote.CreateVoteDto;
import com.example.electionApp.ElectionApp.data.dto.vote.VoteDto;
import com.example.electionApp.ElectionApp.data.models.Party;
import com.example.electionApp.ElectionApp.data.models.Vote;
import com.example.electionApp.ElectionApp.data.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    PartyRepository partyRepository;
    @Override
    public void createParty(PartyDto partyDto) {
        Party party = new Party();
        party.setName(partyDto.getName());
        party.setMotto(partyDto.getMotto());
        party.setFoundingDate(LocalDate.now());
        partyRepository.save(party);
    }

    @Override
    public VoteDto createVote(CreateVoteDto vote) {
        return null;
    }

    @Override
    public void updateParty(Party party) {
    }

    @Override
    public void deleteParty(Party party) {

    }

    @Override
    public List<PartyDto> viewAllParties() {
        return null;
    }

    @Override
    public List<Vote> getAllVotes() {
        return null;
    }

    @Override
    public List<Vote> getVoteByPartyId(Party party) {
        return null;
    }
}
