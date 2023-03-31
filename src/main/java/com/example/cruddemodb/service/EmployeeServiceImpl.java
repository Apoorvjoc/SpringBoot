package com.example.cruddemodb.service;

import com.example.cruddemodb.dao.EmployeeDao;
import com.example.cruddemodb.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee e) {
        return employeeDao.save(e);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDao.deleteById(id);
    }
}
