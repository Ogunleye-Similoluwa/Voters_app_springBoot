package com.example.electionApp.ElectionApp.data.repositories;

import com.example.electionApp.ElectionApp.data.models.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {

    Party getPartyById(Long id);
}
