package com.example.electionApp.ElectionApp.services;

import com.example.electionApp.ElectionApp.data.dto.request.VoteRequest;
import com.example.electionApp.ElectionApp.data.dto.request.VotersRegisterRequest;
import com.example.electionApp.ElectionApp.data.dto.response.VoterRegisterResponse;
import com.example.electionApp.ElectionApp.data.dto.response.VoteResponse;
import com.example.electionApp.ElectionApp.data.models.Vote;
import com.example.electionApp.ElectionApp.data.models.Voter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VoterService {
    VoterRegisterResponse register(VotersRegisterRequest registerRequest);

    List<Voter> getAllVoters();

    Voter getVoter(Long id);

    void deleteVoterAccount(Long id);

    Voter updateVoter(Long id, Voter voter);

    VoteResponse votePolled(VoteRequest vote, Long id);


}
