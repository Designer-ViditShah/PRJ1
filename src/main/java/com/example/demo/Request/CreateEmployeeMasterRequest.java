package com.example.demo.Request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class CreateEmployeeMasterRequest {

    private String firstname;
    private String lastname;
    private Integer designationMasterId;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private Date dateOfJoining;
    private Long salary;

}
