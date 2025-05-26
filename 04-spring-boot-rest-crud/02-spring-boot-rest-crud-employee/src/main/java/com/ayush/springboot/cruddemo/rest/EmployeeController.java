package com.ayush.springboot.cruddemo.rest;

import com.ayush.springboot.cruddemo.entity.Employee;
import com.ayush.springboot.cruddemo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;
    private ObjectMapper objectMapper;

    @Autowired
    public EmployeeController(ObjectMapper objectMapper, EmployeeService employeeService) {
        this.objectMapper = objectMapper;
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> employees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee employeeById(@PathVariable int id){
        Employee employee = employeeService.findById(id);

        if(employee == null)
            throw new RuntimeException("Employee id not found - " + id);

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

        if(tempEmployee == null){
            throw new RuntimeException("no employee id found " + id);
        }

        if(patchPayload.containsKey("id")){
            throw new RuntimeException("id not allowed in patch payload");
        }

        Employee mappedEmployee = apply(tempEmployee, patchPayload);

        Employee dbEmployee = employeeService.save(mappedEmployee);

        return mappedEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);
        if(tempEmployee == null){
            throw new RuntimeException("employeeid not found " + employeeId);
        }

        employeeService.deleteById(employeeId);
        return "Deleted employee with id " + employeeId;
    }

    private Employee apply(Employee tempEmployee, Map<String, Object> patchPayload) {

        ObjectNode employeeNode = objectMapper.convertValue(tempEmployee, ObjectNode.class);
        ObjectNode payloadNode = objectMapper.convertValue(patchPayload, ObjectNode.class);
        employeeNode.setAll(payloadNode);
        return objectMapper.convertValue(employeeNode, Employee.class);
    }
}
