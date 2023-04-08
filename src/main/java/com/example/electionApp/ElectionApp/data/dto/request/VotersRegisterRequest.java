package com.example.electionApp.ElectionApp.data.dto.request;

import lombok.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import static com.example.electionApp.ElectionApp.util.AppUtil.EMAIL_REGEX_STRING;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VotersRegisterRequest {
    @NotNull(message = "field name cannot be null")
    @NotEmpty(message = "field name cannot be empty")
    private String name;


    @Size(min = 11, max = 11)
    @NotNull(message = "field name cannot be null")
    @NotEmpty(message = "field name cannot be empty")
    private String phoneNumber;

    @NotNull(message = "field email cannot be null")
    @NotEmpty(message = "field email cannot be empty")
    @Email(message = "must be valid email address", regexp = EMAIL_REGEX_STRING)
    private String email;
}
