package com.example.Employee_Management_System.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Arrays;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.Employee_Management_System.Model.Employee;
import com.example.Employee_Management_System.Repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class EmployeeControllerIntegrationTest{

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Test
    public void testGetAllEmployees() throws Exception {
        // Preparing data
        Employee employee1 = new Employee();
        employee1.setName("Prathmesh Garud");
        employee1.setEmail("prathmeshgarud55@gmail.com");
        employee1.setDepartment("IT");
        employee1.setSalary(50000.0);
        employee1.setJoiningDate(LocalDate.now());

        Employee employee2 = new Employee();
        employee2.setName("Anavi Kale");
        employee2.setEmail("anvi.kale@gmail.com");
        employee2.setDepartment("Tester");
        employee2.setSalary(40000.0);
        employee2.setJoiningDate(LocalDate.now());

        employeeRepository.saveAll(Arrays.asList(employee1, employee2));

        mockMvc.perform(get("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[1].name").value("Prathmesh Garud"));
    }
}