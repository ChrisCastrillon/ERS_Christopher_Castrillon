package com.revature.repositories;

import java.util.List;

import com.revature.models.Employee;

public interface IEmployeeDAO {
    public List<Employee> findAll();
    public Employee findByUsername(String username);
    public Employee findById(int id);
    public Employee findOneEmployeeByUsername(String username);
}
