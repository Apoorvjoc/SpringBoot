package com.example.cruddemodb.dao;

import com.example.cruddemodb.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee , Integer> {
    //thsts it for basic CRUD operation no need fof any code
}
