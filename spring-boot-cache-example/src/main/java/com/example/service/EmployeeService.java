package com.example.service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        System.out.println("Save the record");
        return employeeRepository.save(employee);
    }

    @Cacheable(value = "employee", key = "#id")
    public Employee getEmployeeById(int id){
        System.out.println("Get the record with id : " + id);
        return employeeRepository.findById(id).orElse(null);
    }

    @CachePut(value = "employee", key = "#employee.id")
    public Employee updateEmployee(Employee employee) {
        System.out.println("Update the record with id : " + employee.getId());
        return employeeRepository.save(employee);
    }

    @CacheEvict(value = "employee", key = "#id")
    public void deleteEmployee(int id) {
        System.out.println("Delete the record with id : " + id);
        employeeRepository.deleteById(id);
    }
}