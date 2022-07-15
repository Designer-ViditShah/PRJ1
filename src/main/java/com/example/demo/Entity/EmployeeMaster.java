package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employeeId", nullable = false)
    private Integer employeeId;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "designationMasterId", nullable = false)
    private Integer designationMasterId;

    @Column(name = "dateOfJoining", nullable = false)
    private Date dateOfJoining;

    @Column(name = "salary", nullable = false)
    private Long salary;

}
