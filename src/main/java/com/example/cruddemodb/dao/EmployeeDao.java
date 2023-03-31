package com.example.cruddemodb.dao;

import com.example.cruddemodb.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee e);

    void deleteById(int id);

}
