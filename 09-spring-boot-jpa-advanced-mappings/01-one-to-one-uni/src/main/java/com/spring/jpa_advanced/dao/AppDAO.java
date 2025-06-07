package com.spring.jpa_advanced.dao;

import com.spring.jpa_advanced.entity.Instructor;

public interface AppDAO {
    public void save(Instructor instructor);
    public Instructor findById(int id);
    public void deleteById(int id);
}
