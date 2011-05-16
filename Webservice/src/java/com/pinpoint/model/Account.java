/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pinpoint.model;

import com.mysql.jdbc.PreparedStatement;
import com.pinpoint.util.Database;
import java.sql.ResultSet;

/**
 *
 * @author Ananti
 */
public class Account {

    private String username;
    private String password;
    private String email;

    public Account () {
        username = "";
        password = "";
        email = "";
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    //Cek Login from DB
    public int Login(String username, String password) {
        int id_account = 0;       
       
        Database db = new Database();
        try {
          db.open();
          String query = "SELECT * FROM account WHERE username = ? AND password = MD5(?)";
          PreparedStatement ps = (PreparedStatement) db.getConnection().prepareStatement(query);
          ps.setString(1, username);
          ps.setString(2, password);
          ResultSet rs = ps.executeQuery();

          while (rs.next()) {
              id_account = rs.getInt("id_account");
          }

        } catch (Exception ex) {
            id_account = 0;           
        }
        
        return id_account;        
    }

    //Add user account(Registration)
    public int Register(Account account) {
        int result = 0;

        Database db = new Database();
        try {
            db.open();
            String query = "INSERT INTO account (username,password,email) VALUES (?,MD5(?),?)";
            PreparedStatement ps = (PreparedStatement) db.getConnection().prepareStatement(query);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getEmail());
            ps.executeUpdate();

            result = 1;
        } catch (Exception ex) {
            result = 0;
        }

        return result;
    }
}
