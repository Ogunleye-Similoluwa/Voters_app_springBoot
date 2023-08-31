package com.example.electionApp.ElectionApp.data.dto.request;

import com.example.electionApp.ElectionApp.data.models.Role;
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
public class RegisterRequest {
    @NotNull(message = "field name cannot be null")
    @NotEmpty(message = "field name cannot be empty")
    private String name;


    @Size(min = 11, max = 11)
    @NotNull(message = "field name cannot be null")
    @NotEmpty(message = "field name cannot be empty")
    private String phoneNumber;

    @Size(min = 6, max = 11)
    @NotNull(message = "field name cannot be null")
    @NotEmpty(message = "field name cannot be empty")
    private String password;



    @NotNull(message = "field name cannot be null")
    @NotEmpty(message = "field name cannot be empty")
    private Role role;

    @NotNull(message = "field email cannot be null")
    @NotEmpty(message = "field email cannot be empty")
    @Email(message = "must be valid email address", regexp = EMAIL_REGEX_STRING)
    private String email;
}
