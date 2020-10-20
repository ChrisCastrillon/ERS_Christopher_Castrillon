package com.revature.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.util.ConnectionUtil;

public class EmployeeDAO implements IEmployeeDAO {

    @Override
    public List<Employee> findAll() {
        List<Employee> allEmployees = new ArrayList<>();
        
        try (Connection connection = ConnectionUtil.getConnection()){
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM project1.ers_users";
            ResultSet resultSet = statement.executeQuery(sql);
            
            while(resultSet.next()) {
                int id = resultSet.getInt("ers_user_id");
                String username = resultSet.getString("ers_username");
                String password = resultSet.getString("ers_password");
                String firstName = resultSet.getString("user_first_name");
                String lastName = resultSet.getString("user_last_name");
                String email = resultSet.getString("user_email");
                int roleId = resultSet.getInt("user_role_id");
                Role role = new Role(roleId);
                
                Employee e = new Employee(id, username, password, firstName, lastName, role, email);
                allEmployees.add(e);
            }    
        }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
            return allEmployees;
    }

    @Override
    public Employee findByUsername(String username) { 
        System.out.println("find by username called");
        Employee e = new Employee();
        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM project1.ers_users WHERE ers_username = " + "\'"+username+"\'";
            ResultSet resultSet = statement.executeQuery(sql);
            
            while(resultSet.next()) {
                int id = resultSet.getInt("ers_user_id");
                String password = resultSet.getString("ers_password");
                String firstName = resultSet.getString("user_first_name");
                String lastName = resultSet.getString("user_last_name");
                String email = resultSet.getString("user_email");
                int roleId = resultSet.getInt("user_role_id");
                Role role = new Role(roleId);
                e = new Employee(id, username, password, firstName, lastName, role, email);
            }
        }catch(SQLException error) {
            error.printStackTrace();
            System.out.println("cannot find user");
            return null;
        }
        if(e.getId() == 0) {
            System.out.println("the user does not exist, returning null");
            return null;
        }
        System.out.println("returing the employee");
        return e;
    }

    @Override
    public Employee findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Employee findOneEmployeeByUsername(String username) {
        // TODO Auto-generated method stub
        return null;
    }

}
