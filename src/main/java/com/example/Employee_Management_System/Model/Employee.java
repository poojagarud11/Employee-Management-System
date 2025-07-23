package com.example.Employee_Management_System.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import jakarta.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "employee", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Department is mandatory")
    private String department;

    @Positive(message = "Salary must be positive")
    private Double salary;

    private LocalDate joiningDate;


    // public Integer getId() {
    //     return id;
    // }

    // public void setId(Integer id) {
    //     this.id = id;
    // }

    // public String getName() {
    //     return name;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public String getEmail() {
    //     return email;
    // }

    // public String getDepartment() {
    //     return department;
    // }

    // public LocalDate getJoiningDate() {
    //     return joiningDate;
    // }

    // public void setJoiningDate(LocalDate joiningDate) {
    //     this.joiningDate = joiningDate;
    // }

    // public Double getSalary() {
    //     return salary;
    // }

    // public void setSalary(Double salary) {
    //     this.salary = salary;
    // }

    // public void setDepartment(String department) {
    //     this.department = department;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }
}
