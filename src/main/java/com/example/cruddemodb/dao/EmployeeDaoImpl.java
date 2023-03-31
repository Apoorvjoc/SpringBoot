package com.example.cruddemodb.dao;

import com.example.cruddemodb.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create-query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee" , Employee.class);

        //execute-query
        List<Employee> empLst = theQuery.getResultList();

        //return res
        return empLst;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class , id);
        return employee;
    }

    @Override
    public Employee save(Employee e) {
        Employee dbEmployee = entityManager.merge(e);
        return  dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee e = entityManager.find(Employee.class , id);
        entityManager.remove(e);
    }
}
