package com.example.demo.Request;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateEmployeeMasterRequest {

    private String firstname;
    private String lastname;
    private Integer designationMasterId;
    private Date dateOfJoining;
    private Long salary;
}
