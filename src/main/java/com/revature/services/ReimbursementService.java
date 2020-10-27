package com.revature.services;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.repositories.IReimbursementDAO;
import com.revature.repositories.ReimbursementDAO;
import com.revature.templates.ReimbursementTemplate;

public class ReimbursementService {
    private IReimbursementDAO reimbursementDAO;
    
    
    public ReimbursementService() {
        super();
        this.reimbursementDAO = new ReimbursementDAO();
       
        
    }
    //for mocking
    public ReimbursementService(IReimbursementDAO reimbursementDAO) {
        this.reimbursementDAO = reimbursementDAO;
    }
    public Reimbursement reimbursementFormToReimbursement(ReimbursementTemplate rt) {
        int subType = Integer.valueOf(rt.getSubType());
        int eid = Integer.valueOf(rt.getEid());
        double amount = Double.valueOf(rt.getAmount());
        String description = rt.getDescription();
        byte[] receipt = rt.getReceipt();
        Reimbursement r = new Reimbursement(0, amount, new Timestamp(System.currentTimeMillis()), null, description, receipt, eid, 0,1,subType);
        return r;
    }
    public List<Reimbursement> getAllReimbursements(int id) {
        
        List<Reimbursement> allReimbursements = reimbursementDAO.findAllByEID(id);
        System.out.println("all of the reimbursements" + allReimbursements);
        return allReimbursements;
    }
    public List<Reimbursement> getAllReimbursements() {
        List<Reimbursement> allReimbursementsForAllEmployees = reimbursementDAO.findAll();
        return allReimbursementsForAllEmployees;
    }
    public Reimbursement submitReimbursement(ReimbursementTemplate rt) {
        Reimbursement r = reimbursementFormToReimbursement(rt);
        r = reimbursementDAO.insert(r);
        if (r == null) {
            return null;
        }
        return r;
    }
}
