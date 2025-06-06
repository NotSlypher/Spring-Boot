package com.example.demo.dao;

import com.example.demo.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        Employee employeeFromDb = entityManager.merge(employee);
        return employeeFromDb;
    }

    @Override
    public void deleteById(int id) {
        Employee employeeFromDb = entityManager.find(Employee.class, id);
        entityManager.remove(employeeFromDb);
    }
}
