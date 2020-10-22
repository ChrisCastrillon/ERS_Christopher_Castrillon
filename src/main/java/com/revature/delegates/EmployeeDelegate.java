package com.revature.delegates;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import com.revature.util.ResponseUtil;

public class EmployeeDelegate implements Delegate {
    private ObjectMapper om;
    private EmployeeService employeeService;
   
    public EmployeeDelegate() {
        super();
        om = new ObjectMapper();
        employeeService = new EmployeeService();
    }
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String path = (String) request.getAttribute("path");
        System.out.println(path);
        String[] portions = path.split("/");
        System.out.println(portions.length);
        switch(portions.length) {
        case 1:
            handleGroup(request, response);
            break;
        case 2:
            try {
                handleSingle(request, response, Integer.parseInt(portions[1]));
            }catch(NumberFormatException e) {
                response.sendError(401);
            }
            break;
        default:
            response.sendError(401);
            break;
        }
    }
    private void handleSingle(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
        switch(request.getMethod()) {
        case "GET": {
//            Employee employee = employeeService.findById(id);
            break;
        }
        }
    }
    private void handleGroup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch(request.getMethod()) {
        case "GET":
            List<Employee> allEmployees = employeeService.findAllEmployees();
            ResponseUtil.writeJSON(response, allEmployees);
        }
    }

}
