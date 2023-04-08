package com.example.electionApp.ElectionApp.data.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VoterRegisterResponse {
    private Long id;
    private String message;
    private boolean isSuccess;
}

