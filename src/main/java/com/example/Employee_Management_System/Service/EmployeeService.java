package com.example.Employee_Management_System.Service;

import com.example.Employee_Management_System.Exception.EmployeeNotFoundException;
import com.example.Employee_Management_System.Model.Employee;
import com.example.Employee_Management_System.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
      // checking unique emails
        employeeRepository.findByEmail(employee.getEmail())
                .ifPresent(e -> {throw new RuntimeException("Email already exists");});
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmplopees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeByID(Integer id) {
        return employeeRepository.findById(id)
             .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }


    public Employee updateEmployee(Integer id, Employee employee) {
        Employee update= getEmployeeByID(id);
        update.setName(employee.getName());
        update.setEmail(employee.getEmail());
        update.setDepartment(employee.getDepartment());
        update.setSalary(employee.getSalary());
        update.setJoiningDate(employee.getJoiningDate());
        return employeeRepository.save(update);
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
