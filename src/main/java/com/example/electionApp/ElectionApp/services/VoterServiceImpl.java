package com.example.electionApp.ElectionApp.services;


import com.example.electionApp.ElectionApp.Security.TokenProvider;
import com.example.electionApp.ElectionApp.data.dto.request.AuthenticationRequest;
import com.example.electionApp.ElectionApp.data.dto.request.RegisterRequest;
import com.example.electionApp.ElectionApp.data.dto.response.RegisterResponse;
import com.example.electionApp.ElectionApp.data.models.AppUser;
import com.example.electionApp.ElectionApp.data.models.Voter;
import com.example.electionApp.ElectionApp.data.repositories.AppUserRepository;
import com.example.electionApp.ElectionApp.data.repositories.VotersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoterServiceImpl implements VoterService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private VotersRepository votersRepository;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    private final TokenProvider jwtService;

    public RegisterResponse register(RegisterRequest voterRequest) {

        AppUser user = new AppUser();
        user.setEmail(voterRequest.getEmail());
        user.setPassword(passwordEncoder.encode(voterRequest.getPassword()));
        appUserRepository.save(user);

        RegisterResponse response = new RegisterResponse();
        response.setSuccess(true);
        response.setMessage("User registered successfully ");
        response.setId(user.getId());
        return response;

    }

    @Override
    public ResponseEntity<String> login(AuthenticationRequest request) {
        Optional<AppUser> user = appUserRepository.findByEmail(request.getEmail());

        if (user.isPresent() && passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {

            final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            var jwtToken = jwtService.generateToken(user.get());

            return ResponseEntity.ok().body(jwtToken);

        }
        return ResponseEntity.status(403).body("error");
    }

    @Override
    public Map<String, String> updateProfile(Voter voterRequest) {
        Optional<AppUser> appUser = appUserRepository.findByEmail(voterRequest.getEmail());
        if(appUser.isEmpty()){
            throw  new UsernameNotFoundException("User not found with this email address");
        }
        else {
            Voter voter = new Voter();
            voter.setAddress(voter.getAddress());
            voter.setAge(voter.getAge());
            voter.setUser(appUser.get());
            voter.setName(voterRequest.getName());
            voter.setOccupation(voterRequest.getOccupation());
            voter.setPhoneNumber(voterRequest.getPhoneNumber());
            voter.setParty(voterRequest.getParty());
            votersRepository.save(voter);
            Map<String,String> response = new HashMap<>();
            response.put("Details:","Successfully updated your info");
            return response;

        }

    }
}
