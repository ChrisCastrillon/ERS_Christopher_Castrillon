package com.revature.services;

import java.sql.Timestamp;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.repositories.IEmployeeDAO;
import com.revature.repositories.IReimbursementDAO;
import com.revature.repositories.ReimbursementDAO;
import com.revature.templates.ReimbursementTemplate;
import com.revature.templates.ReimbursementUpdateTemplate;

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
    public  Reimbursement reimbursementUpdateFormToReimbursement(ReimbursementUpdateTemplate rut) {
        int reimbId = Integer.valueOf(rut.getReimbId());
        int resolver = Integer.valueOf(rut.getResolver());
        int statusId = Integer.valueOf(rut.getStatusId());
        Reimbursement r = reimbursementDAO.findById(reimbId);
        r = new Reimbursement(reimbId, r.getReimbAmount(), r.getSubmitTimeStamp(), new Timestamp(System.currentTimeMillis()), r.getDescription(), r.getReceipt(),r.getAuthor(),resolver, statusId, r.getType()); //make a new reimbursement object and update it in the database
        
        return updateReimbursement(r);
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
    public Reimbursement updateReimbursement(Reimbursement r) {
        Reimbursement reimb = reimbursementDAO.update(r);
        return reimb;
    }
}
