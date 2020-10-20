package com.revature.delegates;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import com.revature.services.ReimbursementService;
import com.revature.templates.LoginTemplate;
import com.revature.util.ResponseUtil;

public class LoginDelegate implements Delegate {
    private ObjectMapper om;
    private EmployeeService employeeService;
    private LoginTemplate loginTemplate;
    
    public LoginDelegate() {
        super();
        om = new ObjectMapper();
        employeeService = new EmployeeService();
    }
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        System.out.println("Does this run?");
        BufferedReader reader = request.getReader();
        System.out.println("after buffered reader");
        String body = reader.lines().collect(Collectors.joining(System.lineSeparator()));
        System.out.println(body.toString());
        System.out.println("after reading teh body:");
        loginTemplate =  om.readValue(body, LoginTemplate.class);
        System.out.println("The login template is: " + loginTemplate.toString());
        
        Employee e = employeeService.login(loginTemplate);
        
        if(e == null) {
            response.setStatus(400);
        } 
        else {
            HttpSession session = request.getSession(); 
            session.setAttribute("currentUser", e);
            ResponseUtil.writeJSON(response, e);
        }
        
    }

}
