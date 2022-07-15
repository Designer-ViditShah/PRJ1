package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesignationMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "designationId", nullable = false)
    private Long designationId;

    @Column(name = "designation", nullable = false)
    private String designation;
}
