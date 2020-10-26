package com.revature.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.Delegate;
import com.revature.delegates.EmployeeDelegate;
import com.revature.delegates.LoginDelegate;
import com.revature.delegates.LogoutDelegate;
import com.revature.delegates.ReimbursementDelegate;

public class RequestDispatcher {
    private Map<String, Delegate> delegateMap;
    
    public RequestDispatcher() {
        super();
        delegateMap = new HashMap<>();
        
        delegateMap.put("login", new LoginDelegate());
        delegateMap.put("logout", new LogoutDelegate());
        delegateMap.put("employees", new EmployeeDelegate());
        delegateMap.put("reimbursements", new ReimbursementDelegate());
        
        delegateMap.put("index", (req, resp) -> {
            req.getRequestDispatcher("/static/index.html").forward(req, resp);
            System.out.println("index has been retrieved");
        });
        delegateMap.put("", (req, resp) -> {
            req.getRequestDispatcher("/static/index.html").forward(req, resp);
        });
        delegateMap.put("submissions", (req, resp) -> {
            req.getRequestDispatcher("/static/submissions.html").forward(req, resp);
            System.out.println("submissions has been retrieved");
        });
        delegateMap.put("administrator-portal", (req, resp) -> {
            req.getRequestDispatcher("/static/administrator-portal.html").forward(req, resp);
        });
        delegateMap.put("manage-accounts", (req, resp) -> {
            req.getRequestDispatcher("/static/manage-accounts.html").forward(req, resp);
        });
    }
    public Delegate dispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String URI = request.getRequestURI().replace("/ERS_Christopher_Castrillon", "");
        //the uri patters will then be able to match the keys in in the hashmap
        
        String remainder = URI;
        System.out.println("The URI IS: " + remainder);
        
        if(remainder.charAt(0) =='/') {
            remainder = URI.substring(1);
        }
        request.setAttribute("path", remainder);
        
        String resource = remainder.split("/")[0];
        System.out.println("The resource in question is: " + resource);  
        return delegateMap.get(resource);
    }
    
}
