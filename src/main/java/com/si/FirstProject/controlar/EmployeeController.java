package com.si.FirstProject.controlar;

import com.si.FirstProject.entity.Employee;
import com.si.FirstProject.repository.EmployeeRepo;
import com.si.FirstProject.service.EmployeeService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@Slf4j
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepo employeeRepo;

    @PostMapping(value = "/emp_create")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping(value="/get_id/{id}")
    public Employee getById(@PathVariable(value = "id") Long id){
        return employeeService.getById(id);
    }
    @DeleteMapping(value = "/delete_id/{id}")
    public void deleteById(@PathVariable (value = "id")Long id){
        employeeService.deletById(id);

    }
    @PutMapping(value = "/show_emp/{id}")
    public ResponseEntity<Employee> updateEmpById(@PathVariable Long id,@RequestBody Employee employee){
        Employee getEmp = employeeRepo.findById(id).get();
        getEmp.setName(employee.getName());
       getEmp.setAddress(employee.getAddress());
        Employee upDate=employeeRepo.save(getEmp);
    log.info("");
        return  ResponseEntity.ok().body(getEmp);

    }
   /* private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @PutMapping(value = "/show_emp/{id}")
    public ResponseEntity<Employee> updateEmpById(@PathVariable Long id, @RequestBody Employee employee) {
        logger.info("Request to update employee with ID: {}", id);

        try {
            Optional<Employee> optionalEmployee = employeeRepo.findById(id);
            if (!optionalEmployee.isPresent()) {
                logger.error("Employee with ID: {} not found", id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            Employee getEmp = optionalEmployee.get();
            getEmp.setName(employee.getName());
            getEmp.setAddress(employee.getAddress());
            Employee updatedEmployee = employeeRepo.save(getEmp);

            logger.info("Successfully updated employee with ID: {}", updatedEmployee.getId());
            return ResponseEntity.ok(updatedEmployee);

        } catch (Exception e) {
            logger.error("Error updating employee with ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.MULTI_STATUS).build();
        }
    }
*/

    }