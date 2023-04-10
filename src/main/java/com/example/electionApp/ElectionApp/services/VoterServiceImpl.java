package com.example.electionApp.ElectionApp.services;

import com.example.electionApp.ElectionApp.data.dto.request.VoteRequest;
import com.example.electionApp.ElectionApp.data.dto.request.VotersRegisterRequest;
import com.example.electionApp.ElectionApp.data.dto.response.VoteResponse;
import com.example.electionApp.ElectionApp.data.dto.response.VoterRegisterResponse;
import com.example.electionApp.ElectionApp.data.models.Vote;
import com.example.electionApp.ElectionApp.data.models.Voter;
import com.example.electionApp.ElectionApp.data.repositories.VoteRepository;
import com.example.electionApp.ElectionApp.data.repositories.VotersRepository;
import com.example.electionApp.ElectionApp.exception.VoterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class VoterServiceImpl implements VoterService{
    @Autowired
    private  VotersRepository votersRepository;
    @Autowired
    private VoteRepository  voteRepository;

    @Override
    public VoterRegisterResponse register(VotersRegisterRequest registerRequest) {
        Voter voter = new Voter();

        voter.setName(registerRequest.getName());
        voter.setEmail(registerRequest.getEmail());
        voter.setPhoneNumber(registerRequest.getPhoneNumber());
        Voter newVoter = votersRepository.save(voter);
        VoterRegisterResponse response = getRegisterResponse(newVoter);
        return response;
    }

    @Override
    public Voter getVoter(Long id) {
//        return null;
       return votersRepository.findById(id).orElseThrow(()->new VoterException("Voter with id " + id + " not found"));
    }

    @Override
    public void deleteVoterAccount(Long id) {
        Voter foundVoter = votersRepository.findById(id).orElseThrow(()->new VoterException("Voter with id " + id + " not found"));
        votersRepository.delete(foundVoter);

    }

    @Override
    public Voter updateVoter(Long id, Voter voter) {
        Voter foundVoter = votersRepository.findById(id).orElseThrow(()-> new VoterException("Voter with id " + id + " not found"));
//        checkVoter(voter,id);
        if(foundVoter.equals(voter))throw new VoterException("Duplicate Voter");

        foundVoter.setName(voter.getName());
        foundVoter.setEmail(voter.getEmail());
        return votersRepository.save(foundVoter);
    }

    @Override
    public VoteResponse votePolled(VoteRequest vote, Long id) {
        votersRepository.findById(id).orElseThrow(()->new VoterException("Voter with id " + id + " not found"));
        checkVote(id);
        Vote newVote =new Vote();
        newVote.setId(vote.getId());
        newVote.setParty(vote.getParty());
        newVote.setIsValid(true);
        voteRepository.save(newVote);
        VoteResponse response = new VoteResponse();
        response.setId(newVote.getId());
        response.setMessage("Vote Successfully Added");
        response.setSuccess(true);
        return response;
    }

    @Override
    public List<Voter> getAllVoters() {
        return votersRepository.findAll();
    }

    private static VoterRegisterResponse getRegisterResponse(Voter savedVoter) {
        VoterRegisterResponse registerResponse = new VoterRegisterResponse();
        registerResponse.setId(savedVoter.getId());
        registerResponse.setSuccess(true);
        registerResponse.setMessage("User Registration Successful");
        return registerResponse;
    }
//    private void  checkVoter(Voter newVoter,Long id) {
//        Voter voter = votersRepository.findById(id).orElseThrow(()->new VoterException("Voter with id " + id + " not found"));
//        if (voter== newVoter) throw new VoterException("Duplicate Voter");
//
//    }
    private  void checkVote(Long id) {
        Optional<Vote> vote = voteRepository.findById(id).stream().findFirst();
        if (vote.isPresent()) throw new VoterException("Duplicate Vote");
   }


}
