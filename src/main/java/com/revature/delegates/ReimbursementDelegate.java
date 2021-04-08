package com.revature.delegates;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;
import com.revature.templates.ReimbursementTemplate;
import com.revature.templates.ReimbursementUpdateTemplate;
import com.revature.util.RequestUtil;
import com.revature.util.ResponseUtil;

public class ReimbursementDelegate implements Delegate {
    private ObjectMapper om;
    private ReimbursementService reimbursementService;
    
    
    public ReimbursementDelegate() {
        super();
        om = new ObjectMapper();
        reimbursementService = new ReimbursementService();
    }
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // TODO Auto-generated method stub
//        HttpSession session = request.getSession(false);
//        Employee currentUser = (Employee) session.getAttribute("currentUser");
//        BufferedReader reader = request.getReader();
//        String body = reader.lines().collect(Collectors.joining(System.lineSeparator()));
//        ReimbursementTemplate rt = om.readValue(body, ReimbursementTemplate.class);
//        Reimbursement r = reimbursementService.submitReimbursement(rt);
//        List<Reimbursement> reimbursements = reimbursementService.getAllReimbursements(currentUser.getId());
//        ResponseUtil.writeJSON(response, reimbursements);
//    
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
    private void handleSingle(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException{
        
        switch(request.getMethod()) {
        case "GET": {
            List<Reimbursement> reimbursements = reimbursementService.getAllReimbursements(id);
            ResponseUtil.writeJSON(response, reimbursements);
            break;
        }
        default:
            response.sendError(401);
            break;
        }
    }
    private void handleGroup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch(request.getMethod()) {
        case "GET":
            List<Reimbursement> allReimbursements = reimbursementService.getAllReimbursements();
            ResponseUtil.writeJSON(response, allReimbursements);
        case "POST": 
            String newReimbursement = RequestUtil.readBody(request);
            ReimbursementTemplate rt = om.readValue(newReimbursement, ReimbursementTemplate.class);
            System.out.println(rt.toString());
            Reimbursement r = reimbursementService.submitReimbursement(rt);
            ResponseUtil.writeJSON(response, r);
            break;
        case "PUT":
            System.out.println("put is called");
            String updateForm = RequestUtil.readBody(request);
            ReimbursementUpdateTemplate rut = om.readValue(updateForm, ReimbursementUpdateTemplate.class);
            System.out.println("the reimbursement update template " + rut.toString());
            Reimbursement reimb = reimbursementService.reimbursementUpdateFormToReimbursement(rut);
            System.out.println("the reimbursement is" + reimb.toString());
            ResponseUtil.writeJSON(response, reimb);
            break;
            
        default:
            response.sendError(401);
            break;
        }
    }

}
