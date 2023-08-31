package com.example.electionApp.ElectionApp.data.repositories;

import com.example.electionApp.ElectionApp.data.models.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VotersRepository extends JpaRepository<Voter,Long> {

//    @Override
//    Optional<Voter> findById(Long aLong);

    Optional<Voter> findByEmail(String email);
}
