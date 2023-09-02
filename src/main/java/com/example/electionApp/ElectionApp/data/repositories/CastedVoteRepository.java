package com.example.electionApp.ElectionApp.data.repositories;

import com.example.electionApp.ElectionApp.data.models.CastedVote;
import com.example.electionApp.ElectionApp.data.models.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CastedVoteRepository extends JpaRepository<CastedVote, Long> {

    CastedVote getCastedVoteById(Long id);
    CastedVote getCastedVoteByPartyName(String partyName);
    CastedVote getCastedVoteByUserId (Long userId);
    List<CastedVote> getAllByPartyName(String partyName);

    List<CastedVote> getAll();
    List<CastedVote> getAllByPartyId(Long partyId);
}
