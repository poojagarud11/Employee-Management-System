package com.example.Employee_Management_System.Controller;

import com.example.Employee_Management_System.Model.Employee;
import com.example.Employee_Management_System.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("api")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;


    //POST /api/employees - Add a new employee
    @PostMapping("/employees")
    public Employee addEmployee( @Valid @RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    //GET /api/employees - Fetch all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmplopees(){
        return employeeService.getAllEmplopees();
    }

    //GET /api/employees/{id} - Fetch an employee by ID
    @GetMapping("/employees/{id}")
    public Employee getEmployeeByID(@PathVariable Integer id){
        return employeeService.getEmployeeByID(id);
    }

    //PUT /api/employees/{id} - Update an employee's details
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @Valid @RequestBody Employee employee){
        return  employeeService.updateEmployee(id,employee);
    }

    //DELETE /api/employees/{id} - Delete an employee
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully";

    }

}
