package com.example.electionApp.ElectionApp.data.repositories;

import com.example.electionApp.ElectionApp.data.models.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotersRepository extends JpaRepository<Voter,Long> {
}
