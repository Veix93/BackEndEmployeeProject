package com.employee.backend.SpringEmployee.Repository;

import com.employee.backend.SpringEmployee.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//JpaRepository<Employee, Long> Provide us with a lot of inbuilt methods
// Employee -> class that we use/  Long-> what datatype is our primary key

    public void deleteEmployeeById(Long id);
    public Optional<Employee> findEmployeeById(Long id);

}
