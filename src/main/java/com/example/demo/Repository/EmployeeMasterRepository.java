package com.example.demo.Repository;

import com.example.demo.Entity.EmployeeMaster;
import com.example.demo.Entity.LoginEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeMasterRepository extends CrudRepository<EmployeeMaster, Integer> {
}
