package com.example.demo.Repository;

import com.example.demo.Entity.LoginEntity;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<LoginEntity, Long> {
}
