package com.example.demo.rest;

import com.example.demo.Exception.StudentNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final ObjectMapper objectMapper;

    @Autowired
    public EmployeeController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if(employee == null){
            throw new StudentNotFoundException("no exception found with id: " + id);
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PatchMapping("/employees/{id}")
    public Employee patchEmployee(@PathVariable int id, @RequestBody Map<String, Object> patchPayload){
        Employee tempEmployee = employeeService.findById(id);

        if(tempEmployee == null)
            throw new StudentNotFoundException("no employee found with id: " + id);

        if(patchPayload.containsKey("id"))
            throw new RuntimeException("id not allowed in patch endpoint");

        Employee employee = apply(tempEmployee, patchPayload);

        return employee;
    }

    private Employee apply(Employee tempEmployee, Map<String, Object> patchPayload) {
        ObjectNode employeeNode = objectMapper.convertValue(tempEmployee, ObjectNode.class);
        ObjectNode payloadNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        employeeNode.setAll(payloadNode);
        return objectMapper.convertValue(employeeNode, Employee.class);
    }


}
