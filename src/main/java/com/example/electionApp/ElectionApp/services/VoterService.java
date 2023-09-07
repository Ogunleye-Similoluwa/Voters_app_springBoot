package com.example.electionApp.ElectionApp.services;

import com.example.electionApp.ElectionApp.data.dto.request.AuthenticationRequest;
import com.example.electionApp.ElectionApp.data.dto.request.RegisterRequest;
import com.example.electionApp.ElectionApp.data.dto.response.RegisterResponse;
import com.example.electionApp.ElectionApp.data.models.Voter;
import org.springframework.http.ResponseEntity;

import java.util.Map;


public interface VoterService {

    RegisterResponse register(RegisterRequest voterRequest);

    ResponseEntity<String> login (AuthenticationRequest authenticationRequest);

    Map<String, String> updateProfile(Voter  updateRequest);
}
