package com.revature.driver;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.IEmployeeDAO;
import com.revature.templates.LoginTemplate;

public class Driver {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        IEmployeeDAO edao = new EmployeeDAO();
        LoginTemplate lt = new LoginTemplate("ccastrillon", "password");
       
        Employee e = edao.findByUsername(lt.getUsername());
       if(e == null ) {
           System.out.println("e i null");
       }
       else {
           System.out.println("e is not null");
           System.out.println(e.toString());
       }
    }

}
