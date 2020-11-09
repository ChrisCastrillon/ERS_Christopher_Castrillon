package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.Delegate;

@WebServlet(urlPatterns= {"/"})
public class FrontController extends HttpServlet{
    private static final long serialVersionUID = -4301754431060741163L;
    private RequestDispatcher requestDispatcher;
    
    public FrontController() {
        super();
        //this will contain a map of all relevant controllers
        requestDispatcher = new RequestDispatcher();
    }
    //this constructor will be used for mocking
    public FrontController(RequestDispatcher requestDispatcher) {
        super();
        this.requestDispatcher = requestDispatcher;
    }
    
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Delegate delegate = requestDispatcher.dispatch(request, response);
        
       
        if(delegate == null) {
            response.sendError(404);
            return;
        }
        try {
            delegate.process(request, response);
        }catch(Exception e) {
            response.setStatus(401);
        }
    }
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CORS Filter leveraged");
        //http://localhost:8080/
        resp.setHeader("Access-Control-Allow-Origin", "http://ec2-18-212-188-152.compute-1.amazonaws.com:8085/"); // Allow only same origin
        
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        // Allow specific HTTP Verbs
        
        resp.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type,"
                + "Access-Control-Request-Method, Access-Control-Request-Headers");
        // Allow specific HTTP Headers (there's a fair few)
        
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        // Credentials are allowed
        
        resp.addHeader("Produces", "application/json");
        // Send back application/json unless forwarded to a static resource
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Is do get called?");
        process(req,resp);
    }
    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        process(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("was dopost called??");
        process(req, resp);
    }
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        process(req, resp);
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        process(req, resp);
    }
    
    
}
