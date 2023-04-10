package com.example.electionApp.ElectionApp.data.repositories;

import com.example.electionApp.ElectionApp.data.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote,Long> {
}
