package com.revature.services;

import java.util.List;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.IEmployeeDAO;
import com.revature.templates.LoginTemplate;

public class EmployeeService {
    IEmployeeDAO employeeDAO;
    
    public EmployeeService() {
        this.employeeDAO = new EmployeeDAO();
    }
    public EmployeeService(IEmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    public List<Employee> findAllEmployees() {
        return employeeDAO.findAll();
    }
    public Employee login(LoginTemplate loginTemplate) {
        String username = loginTemplate.getUsername();
        String password = loginTemplate.getPassword();
        System.out.println("the username is: " + username);
        Employee e = employeeDAO.findByUsername(username);
        System.out.println("find by username called in employee service");
        if(!(e==null)) {
            if(e.getPassword().equals(password)){
            return e;
            }
            else {
                System.out.println("cannot log in");
                return null;
            }
        }
        return null;
    }

}
   
