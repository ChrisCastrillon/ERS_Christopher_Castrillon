package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutDelegate implements Delegate {

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        // If there was no session, don't create one
        
        if(session != null) {
            session.invalidate();
        }
        
        response.sendRedirect("http://localhost:8080/ERS_Christopher_Castrillon");
    }

}
