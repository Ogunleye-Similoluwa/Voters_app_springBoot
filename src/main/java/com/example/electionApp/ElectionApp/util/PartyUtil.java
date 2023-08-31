package com.example.electionApp.ElectionApp.util;

import com.example.electionApp.ElectionApp.data.models.Party;
import com.example.electionApp.ElectionApp.data.repositories.PartyRepository;
import com.example.electionApp.ElectionApp.exception.PartyException;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@NoArgsConstructor
@Slf4j
public class PartyUtil {

    private PartyException partyException;

    @Autowired
    PartyRepository partyRepository;

    public void checkIfPartyExistsById(Long id){
        Optional<Party> party = partyRepository.findById(id);
        if (party.isEmpty()){
            throw partyException.partyNotFoundException("The party " + id + " does not exist");
        }
    }

    public Party getPartyById(Long id){
        checkIfPartyExistsById(id);
        return partyRepository.getPartyById(id);
    }
}
