package com.revature.repositories;

import java.util.List;

import com.revature.models.Reimbursement;

public interface IReimbursementDAO {
    public List<Reimbursement> findAll(); //these will be filtered in the javascript
    public List<Reimbursement> findAllByEID(int id);
    public Reimbursement insert(Reimbursement reimbursement);
    public Reimbursement findById(int id);
    public Reimbursement delete(int id);
    public Reimbursement update(Reimbursement reimbursement);
}
