package com.example.cruddemodb.controller;

import com.example.cruddemodb.entity.Employee;
import com.example.cruddemodb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //quick and dirty : inject employeeDao
//    private EmployeeDao employeeDao;
//
//    @Autowired
//    public EmployeeRestController(EmployeeDao employeeDao) {
//        this.employeeDao = employeeDao;
//    }

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose /employee and return list
    @GetMapping("/employee")
    public List<Employee> findAllEmployee(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{theId}")
    public Employee findEmployee(@PathVariable int theId) {
        Employee e = employeeService.findById(theId);
        if (e == null){
            throw new RuntimeException("Employee not found - " + theId);
        }
        return e;
    }

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee e){
        e.setId(0);
        return employeeService.save(e);
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee e){

        Employee uemp = employeeService.save(e);

        return  uemp;
    }

    @DeleteMapping("employee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee e = employeeService.findById(employeeId);

        if(e == null){
            throw new RuntimeException("No Employee found with id : "+employeeId);
        }

        employeeService.deleteById(employeeId);

        return "employee deleted with id "+ employeeId;
    }
}
