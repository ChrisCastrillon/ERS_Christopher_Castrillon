package com.revature.delegates;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;
import com.revature.templates.ReimbursementTemplate;
import com.revature.util.ResponseUtil;

public class ReimbursementDelegate implements Delegate {
    private ObjectMapper om;
    private ReimbursementService reimbursementService;
    private ReimbursementTemplate reimbursementTemplate;
    
    public ReimbursementDelegate() {
        super();
        om = new ObjectMapper();
        reimbursementService = new ReimbursementService();
    }
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession(false);
        Employee currentUser = (Employee) session.getAttribute("currentUser");
        System.out.println(currentUser.getId());
        System.out.println("This is the reimbursement delegate");
        BufferedReader reader = request.getReader();
        String body = reader.lines().collect(Collectors.joining(System.lineSeparator()));
        ReimbursementTemplate rt = om.readValue(body, ReimbursementTemplate.class);
        List<Reimbursement> reimbursements = reimbursementService.getAllReimbursements(currentUser.getId());
        ResponseUtil.writeJSON(response, reimbursements);
    }

}
