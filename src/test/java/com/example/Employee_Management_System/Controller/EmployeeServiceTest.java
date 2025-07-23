package com.example.Employee_Management_System.Controller;

import com.example.Employee_Management_System.Model.Employee;
import com.example.Employee_Management_System.Repository.EmployeeRepository;
import com.example.Employee_Management_System.Service.EmployeeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    public EmployeeServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEmployeeById() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Pooja Patil");
        employee.setEmail("pooja@gmail.com");
        employee.setDepartment("IT");
        employee.setSalary(50000.0);
        employee.setJoiningDate(LocalDate.now());

        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));

        Employee result = employeeService.getEmployeeByID(1);

        assertNotNull(result);
        assertEquals("Pooja Patil", result.getName());
    }

    @Test
    void testSaveEmployee() {
        Employee employee = new Employee();
        employee.setName("Kapil Gandhi");
        employee.setEmail("kapil@gmail.com");
        employee.setDepartment("HR");
        employee.setSalary(60000.0);
        employee.setJoiningDate(LocalDate.now());

        when(employeeRepository.save(employee)).thenReturn(employee);

        Employee savedEmployee = employeeService.addEmployee(employee);

        assertNotNull(savedEmployee);
        assertEquals("Kapil Gandhi", savedEmployee.getName());
        verify(employeeRepository, times(1)).save(employee);
    }
}