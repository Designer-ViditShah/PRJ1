package com.example.demo.Repository;

import com.example.demo.Entity.DesignationMaster;
import com.example.demo.Entity.EmployeeMaster;
import org.springframework.data.repository.CrudRepository;

public interface DesignationMasterRepository extends CrudRepository<DesignationMaster, Integer> {
}
