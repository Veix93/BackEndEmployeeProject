package com.employee.backend.SpringEmployee.Service;

import com.employee.backend.SpringEmployee.Exceptions.UserNotFoundException;
import com.employee.backend.SpringEmployee.Model.Employee;
import com.employee.backend.SpringEmployee.Repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


//Middleman between Resources and Database
@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){ //We will create it whenever we create service
        this.employeeRepository = employeeRepository;
    }
    //Adding new Employee to Database
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString()); // Generate random ID -> convert to String
        return employeeRepository.save(employee); //save method from -> JPArepository (saving Employee in DB)
    }
    //Finding all Employees
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }
    //Update Employee
    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    //Find Employee
    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + "was not found!"));
    }
    //Delete Employee
    public void deleteEmployee(Long id){
        employeeRepository.deleteEmployeeById(id);
    }
}
