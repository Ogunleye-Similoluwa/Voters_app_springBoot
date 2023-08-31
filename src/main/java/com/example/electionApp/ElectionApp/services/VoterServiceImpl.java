package com.example.electionApp.ElectionApp.services;


import com.example.electionApp.ElectionApp.data.dto.request.AuthenticationRequest;
import com.example.electionApp.ElectionApp.data.dto.request.RegisterRequest;
import com.example.electionApp.ElectionApp.data.dto.response.AuthenticationResponse;
import com.example.electionApp.ElectionApp.data.dto.response.RegisterResponse;
import com.example.electionApp.ElectionApp.data.models.AppUser;
import com.example.electionApp.ElectionApp.data.models.Voter;
import com.example.electionApp.ElectionApp.data.repositories.AppUserRepository;
import com.example.electionApp.ElectionApp.data.repositories.VotersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoterServiceImpl implements VoterService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private VotersRepository votersRepository;


    public RegisterResponse register(RegisterRequest voterRequest) {
        Voter voter = new Voter(voterRequest);
        votersRepository.save(voter);
        AppUser user = new AppUser(voter);
        appUserRepository.save(user);

        RegisterResponse response = new RegisterResponse();
        response.setSuccess(true);
        response.setMessage("Voters registered successfully "+ voter.getName());
        response.setId(voter.getId());
        return response;

    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        return null;
    }

    @Override
    public Voter updateProfile(Voter updateRequest) {
        return null;
    }
}
