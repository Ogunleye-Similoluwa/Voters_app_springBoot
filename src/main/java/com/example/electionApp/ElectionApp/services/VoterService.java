package com.example.electionApp.ElectionApp.services;

import com.example.electionApp.ElectionApp.data.dto.request.AuthenticationRequest;
import com.example.electionApp.ElectionApp.data.dto.request.RegisterRequest;
import com.example.electionApp.ElectionApp.data.dto.response.AuthenticationResponse;
import com.example.electionApp.ElectionApp.data.dto.response.RegisterResponse;
import com.example.electionApp.ElectionApp.data.models.Voter;


public interface VoterService {

    RegisterResponse register(RegisterRequest voterRequest);

    AuthenticationResponse login (AuthenticationRequest authenticationRequest);

    Voter updateProfile(Voter  updateRequest);
}
