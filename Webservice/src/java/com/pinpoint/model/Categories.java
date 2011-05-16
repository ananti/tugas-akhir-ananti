/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pinpoint.model;

import com.pinpoint.util.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ananti
 */
public class Categories {

    private int id;
    private String name;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public List<Categories> getCategories() {
        List<Categories> listCat = new ArrayList<Categories>();

        Database db = new Database();
        try {
            db.open();
            String query = "SELECT * FROM category";
            PreparedStatement ps = db.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               Categories cat = new Categories();
               cat.setId(rs.getInt("id_category"));
               cat.setName(rs.getString("name"));
               listCat.add(cat);
            }
        } catch (Exception ex) {

        }
        return listCat;
    }
    
}
