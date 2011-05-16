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
public class Comment {

    private int id_comment;
    private int id_category;
    private String namePlace;
    private int rating;
    private String content;
    private String date;

    public int getIdComment() {
        return this.id_comment;
    }

    public int getIdCategory() {
        return this.id_category;
    }

    public String getNamePlace() {
        return this.namePlace;
    }

    public int getRating() {
        return this.rating;
    }

    public String getContent() {
        return this.content;
    }

    public String getDate() {
        return this.date;
    }

    public void setIdComment(int newComment) {
        this.id_comment = newComment;
    }

    public void setIdCategory(int newCategory) {
        this.id_category = newCategory;
    }

    public void setNamePlace(String newNamePlace) {
        this.namePlace = newNamePlace;
    }

    public void setRating(int newRating) {
        this.rating = newRating;
    }

    public void setContent(String newContent) {
        this.content = newContent;
    }

    public void setDate(String newDate) {
        this.date = newDate;
    }

    public List<Comment> getComment(int id_cat, String namePlaces) {
        List<Comment> lc = new ArrayList<Comment>();
        Database db = new Database();
        try {
            db.open();
            String query = "SELECT * FROM comment WHERE id_category = ? AND nameplace = ? ORDER BY date DESC LIMIT 3";
            PreparedStatement ps = db.getConnection().prepareStatement(query);
            ps.setInt(1, id_cat);
            ps.setString(2, namePlaces);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Comment c = new Comment();
                c.setIdCategory(id_cat);
                c.setNamePlace(namePlaces);
                c.setIdComment(rs.getInt("id_comment"));
                c.setRating(rs.getInt("rating"));
                c.setContent(rs.getString("content"));
                c.setDate(rs.getString("date"));
                lc.add(c);
            }
        } catch (Exception e) {

        }
        return lc;
    }

    public List<Comment> getAllComment(int id_cat, String namePlaces) {
        List<Comment> lc = new ArrayList<Comment>();
        Database db = new Database();
        try {
            db.open();
            String query = "SELECT * FROM comment WHERE id_category = ? AND nameplace = ?";
            PreparedStatement ps = db.getConnection().prepareStatement(query);
            ps.setInt(1, id_cat);
            ps.setString(2, namePlaces);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Comment c = new Comment();
                c.setIdCategory(id_cat);
                c.setNamePlace(namePlaces);
                c.setContent(rs.getString("content"));
                c.setDate(rs.getString("date"));
                c.setIdComment(rs.getInt("id_comment"));
                c.setRating(rs.getInt("rating"));
                lc.add(c);
            }
        } catch(Exception e) {

        }

        return lc;
    }

    public int sendComment(Comment com) {
        int result = 0;
        Database db = new Database();
        try {
            db.open();
            String query = "INSERT INTO comment(id_category,nameplace,rating,content,date) VALUES (?,?,?,?,NOW())";
            PreparedStatement ps = db.getConnection().prepareStatement(query);
            ps.setInt(1, com.getIdCategory());
            ps.setString(2, com.getNamePlace());
            ps.setInt(3, com.getRating());
            ps.setString(4, com.getContent());
            ps.executeUpdate();

            result = 1;
        } catch(Exception e) {
            result = 0;
        }
        return result;
    }
}
