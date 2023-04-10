package com.example.electionApp.ElectionApp.controllers;

import com.example.electionApp.ElectionApp.data.dto.request.VoteRequest;
import com.example.electionApp.ElectionApp.data.dto.request.VotersRegisterRequest;
import com.example.electionApp.ElectionApp.data.dto.response.VoteResponse;
import com.example.electionApp.ElectionApp.data.dto.response.VoterRegisterResponse;
import com.example.electionApp.ElectionApp.data.models.Voter;
import com.example.electionApp.ElectionApp.services.VoterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/voter/")
public class VotersController {
    @Autowired
    private  VoterService voterService;

    @PostMapping("register")
    public ResponseEntity<?> registerVoter(@RequestBody VotersRegisterRequest voterRequest){
        VoterRegisterResponse registerResponse = voterService.register(voterRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerResponse);
    }
    @GetMapping("all")
    public ResponseEntity<?> getAllVoters(){
        List<Voter> voter =  voterService.getAllVoters();
        return ResponseEntity.ok(voter);
    }
    @GetMapping("all/{id}")
    public ResponseEntity<?> getVoter(@PathVariable Long id){
        Voter voter = voterService.getVoter(id);
        return ResponseEntity.ok(voter);
    }
    @DeleteMapping("all/{id}")
    public ResponseEntity<?> deleteVoterAccount(@PathVariable Long id){
        voterService.deleteVoterAccount(id);
        return ResponseEntity.ok("Voter with id " + id + " deleted successfully");
    }
    @PutMapping("all/{id}")
    public ResponseEntity<?>updateVoterAccount(@RequestBody Voter voter, @PathVariable Long id){
        voterService.updateVoter(id,voter);
        return ResponseEntity.ok("Voter updated successfully");
    }
    @PostMapping("vote/{id}")
    public ResponseEntity<?> vote(@RequestBody VoteRequest voterRequest, @PathVariable Long id){
        VoteResponse voteResponse = voterService.votePolled(voterRequest,id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(voteResponse);
    }



}
