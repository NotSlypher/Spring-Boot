package com.example.demo.services;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(int id);
    public Employee save(Employee employee);
    public void deleteById(int id);
}
