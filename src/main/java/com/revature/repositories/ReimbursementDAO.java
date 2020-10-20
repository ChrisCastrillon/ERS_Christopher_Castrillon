package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAO implements IReimbursementDAO {

    @Override
    public List<Reimbursement> findAll() {
        List<Reimbursement> allReimbursements = new ArrayList<>();

        // get a connection to the database
        try (Connection conn = ConnectionUtil.getConnection()) {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM project1.ers_reimbursement";
            ResultSet rs = stmt.executeQuery(sql);
            // iterate through the set of users
            while (rs.next()) {
                int reimb_id = rs.getInt("reimb_id");
                double reimb_amount = rs.getDouble("reimb_amount");
                Timestamp time_submitted = rs.getTimestamp("reimb_submitted");
                Timestamp time_resolved = rs.getTimestamp("reimb_resolved");
                String reimb_description = rs.getString("reimb_description");
                byte[] reimb_receipt = rs.getBytes("reimb_receipt");
                int reimb_author = rs.getInt("reimb_author");
                int reimb_resolver = rs.getInt("reimb_resolver");
                int reimb_status = rs.getInt("reimb_status_id");
                int reimb_type = rs.getInt("reimb_type_id");
                Reimbursement r = new Reimbursement(reimb_id, reimb_amount, time_submitted, time_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status, reimb_type);
                // add the user to the list of users
                allReimbursements.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("WE FAILED TO RETRIEVE ALL REIMBURSEMENTS");
            // if it returns null then you should try again.
            return null;
        }
        return allReimbursements;
    }

    @Override
    public List<Reimbursement> findAllByEID(int id) {
        List<Reimbursement> allReimbursements = new ArrayList<>();

        // get a connection to the database
        try (Connection conn = ConnectionUtil.getConnection()) {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM project1.ers_reimbursement WHERE reimb_author = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            // iterate through the set of users
            while (rs.next()) {
                int reimb_id = rs.getInt("reimb_id");
                double reimb_amount = rs.getDouble("reimb_amount");
                Timestamp time_submitted = rs.getTimestamp("reimb_submitted");
                Timestamp time_resolved = rs.getTimestamp("reimb_resolved");
                String reimb_description = rs.getString("reimb_description");
                byte[] reimb_receipt = rs.getBytes("reimb_receipt");
                int reimb_author = rs.getInt("reimb_author");
                int reimb_resolver = rs.getInt("reimb_resolver");
                int reimb_status = rs.getInt("reimb_status_id");
                int reimb_type = rs.getInt("reimb_type_id");
                Reimbursement r = new Reimbursement(reimb_id, reimb_amount, time_submitted, time_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status, reimb_type);
                // add the user to the list of users
                allReimbursements.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("WE FAILED TO RETRIEVE ALL REIMBURSEMENTS");
            // if it returns null then you should try again.
            return null;
        }
        return allReimbursements;
    }

    @Override
    public Reimbursement insert(Reimbursement reimbursement) {
        //return a reimbursement object that you can use to populate the submission page
        int count = 0;
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO project1.ers_reimbursement (reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)" +
        " VALUES (DEFAULT,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setDouble(1, reimbursement.getReimbAmount());
            stmt.setTimestamp(2,reimbursement.getSubmitTimeStamp());
            stmt.setTimestamp(3, reimbursement.getResolveTimeStamp());
            stmt.setString(4, reimbursement.getDescription());
            stmt.setBytes(5, reimbursement.getReceipt());
            stmt.setInt(6, reimbursement.getAuthor());
            stmt.setInt(7, reimbursement.getResolver());
            stmt.setInt(8, reimbursement.getStatusId());
            stmt.setInt(9, reimbursement.getType());
            count = stmt.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
            System.out.println("FAILED TO INSERT THE REIMBURSEMENT");
            return null;
        }
        return reimbursement;
    }

    @Override
    public Reimbursement findById(int id) {
        Reimbursement r = new Reimbursement();
        try (Connection conn = ConnectionUtil.getConnection()) {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM project1.ers_reimbursement WHERE reimb_id = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            // iterate through the set of users
            while (rs.next()) {
                int reimb_id = rs.getInt("reimb_id");
                double reimb_amount = rs.getDouble("reimb_amount");
                Timestamp time_submitted = rs.getTimestamp("reimb_submitted");
                Timestamp time_resolved = rs.getTimestamp("reimb_resolved");
                String reimb_description = rs.getString("reimb_description");
                byte[] reimb_receipt = rs.getBytes("reimb_receipt");
                int reimb_author = rs.getInt("reimb_author");
                int reimb_resolver = rs.getInt("reimb_resolver");
                int reimb_status = rs.getInt("reimb_status_id");
                int reimb_type = rs.getInt("reimb_type_id");
                r = new Reimbursement(reimb_id, reimb_amount, time_submitted, time_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status, reimb_type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("WE FAILED TO RETRIEVE REIMBURSEMENT");
            // if it returns null then you should try again.
            return null;
        }
        return r;
    }
    @Override
    public Reimbursement delete(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Reimbursement update(Reimbursement reimbursement) {
        try (Connection conn = ConnectionUtil.getConnection()) {        
            String sql = "UPDATE project1.ers_reimbursement SET reimb_resolved = ?, reimb_resolver = ?, reimb_status_id = ? WHERE reimb_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);    
            stmt.setTimestamp(1, reimbursement.getResolveTimeStamp());
            stmt.setInt(2, reimbursement.getResolver());
            stmt.setInt(3, reimbursement.getStatusId());
            stmt.setInt(4, reimbursement.getReimbId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("WE FAILED TO UPDATE THE REIMBURSEMENT");
        }
        return reimbursement;
    }
    

}
