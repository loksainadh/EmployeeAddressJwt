package com.neo.employee.jwt.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EmployeeSignInRequest {


    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
