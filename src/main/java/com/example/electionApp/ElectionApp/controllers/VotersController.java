package com.example.electionApp.ElectionApp.controllers;

import com.example.electionApp.ElectionApp.data.dto.request.RegisterRequest;
import com.example.electionApp.ElectionApp.data.dto.response.RegisterResponse;
import com.example.electionApp.ElectionApp.data.models.AppUser;
import com.example.electionApp.ElectionApp.data.models.Voter;
import com.example.electionApp.ElectionApp.services.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/voter")
public class VotersController {
    @Autowired
    private VoterService voterService;

    @PostMapping("/register")
    public ResponseEntity<?> registerVoter(@RequestBody RegisterRequest voterRequest){
        RegisterResponse registerResponse = voterService.register(voterRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginVoter(@RequestBody AppUser appUser){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(appUser);
    }
    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> getAllVoters(){
//        List<Voter> voter =  voterService.getAllVoters();
        return ResponseEntity.ok("gotten all voter");
    }
    @GetMapping("/all/{ids}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<?> getVoter(@PathVariable Long ids){
//        Voter voter = voterService.getVoter(id);
        return ResponseEntity.ok("Voter");
    }
    @DeleteMapping("/all/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> deleteVoterAccount(@PathVariable Long id){
//        voterService.deleteVoterAccount(id);
        return ResponseEntity.ok("Voter with id " + id + " deleted successfully");
    }
    @PutMapping("/all/{id}")
    public ResponseEntity<?>updateVoterAccount(@RequestBody Voter voter, @PathVariable Long id){
//        voterService.updateVoter(id,voter);
        return ResponseEntity.ok("Voter updated successfully");
    }
//    @PostMapping("vote/{id}")
//    public ResponseEntity<?> vote(@RequestBody VoteRequest voterRequest, @PathVariable Long id){
//        VoteResponse voteResponse = voterService.votePolled(voterRequest,id);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(voteResponse);
//    }



}
