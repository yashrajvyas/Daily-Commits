package com.springbootwebtutorial.mvcarchitecture.repositories;

import com.springbootwebtutorial.mvcarchitecture.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
