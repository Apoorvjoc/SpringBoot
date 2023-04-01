//package com.example.cruddemodb.service;
//
//import com.example.cruddemodb.dao.EmployeeRepository;
//import com.example.cruddemodb.entity.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class EmployeeServiceImpl implements EmployeeService{
//
//    private EmployeeRepository employeeRepository;
//
//    @Autowired
//    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }
//
//    @Override
//    public List<Employee> findAll() {
//        return employeeRepository.findAll();
//    }
//
//    @Override
//    public Employee findById(int id) {
//        Optional<Employee> result = employeeRepository.findById(id);
//        Employee employee = null;
//
//        if(result.isPresent()){
//            employee = result.get();
//        }else{
//            throw new RuntimeException("EMployee with id - "+id+ " not found..");
//        }
//
//        return employee;
//    }
//
//    @Override
//    public Employee save(Employee e) {
//        return employeeRepository.save(e);
//    }
//
//    @Override
//    public void deleteById(int id) {
//        employeeRepository.deleteById(id);
//    }
//}
