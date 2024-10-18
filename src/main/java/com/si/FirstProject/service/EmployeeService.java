package com.si.FirstProject.service;


import com.si.FirstProject.entity.Employee;
import com.si.FirstProject.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

@Autowired
    EmployeeRepo employeeRepo;
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }


    public Employee getById(Long id) {
        return employeeRepo.findById(id).get();
    }

    public void deletById(Long id) {
      employeeRepo.deleteById(id);
}
}
