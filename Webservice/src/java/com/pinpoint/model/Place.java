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
public class Place {

    private int id_place;
    private int id_account;
    private int id_category;
    private String name;
    private double latitude;
    private double longitude;
    private String address;
    private String phone;
    private String description;
    private String urlWsdl;
    private String method;
    private String namespace;
    private String output1;
    private String output2;
    private String output3;

    public int getIdPlace() {
        return this.id_place;
    }

    public int getIdAccount() {
        return this.id_account;
    }

    public int getIdCategory() {
        return this.id_category;
    }

    public String getName() {
        return this.name;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getDescription() {
        return this.description;
    }

    public String getUrlWsdl() {
        return this.urlWsdl;
    }

    public String getMethod() {
        return this.method;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public String getOutput1() {
        return this.output1;
    }

    public String getOutput2() {
        return this.output2;
    }

    public String getOutput3() {
        return this.output3;
    }

    public void setIdPlace(int newIdPlace) {
        this.id_place = newIdPlace;
    }

    public void setIdAccount(int newIdAccount) {
        this.id_account = newIdAccount;
    }

    public void setIdCategory(int newIdCategory) {
        this.id_category = newIdCategory;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setLatitude(double  newLat) {
        this.latitude = newLat;
    }

    public void setLongitude(double newLong) {
        this.longitude = newLong;
    }

    public void setAddress(String newAddrs) {
        this.address = newAddrs;
    }

    public void setPhone(String newPhone) {
        this.phone = newPhone;
    }

    public void setDescription(String newDesc) {
        this.description = newDesc;
    }

    public void setUrlWsdl(String newUrl) {
        this.urlWsdl = newUrl;
    }

    public void setMethod(String newMethod) {
        this.method = newMethod;
    }

    public void setNamespace(String newNamespace) {
        this.namespace = newNamespace;
    }

    public void setOutput1(String newOutput) {
        this.output1 = newOutput;
    }

    public void setOutput2(String newOutput) {
        this.output2 = newOutput;
    }

    public void setOutput3(String newOutput) {
        this.output3 = newOutput;
    }

    public int contributePlace(Place place) {
        int result = 0;

        Database db = new Database();
        try {
            db.open();
            String query = "INSERT INTO place(id_category, id_account,name, latitude, longitude, url_wsdl, method, namespace, output1, output2, output3) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = (PreparedStatement) db.getConnection().prepareStatement(query);
            ps.setInt(1, place.id_category);
            ps.setInt(2, place.id_account);
            ps.setString(3, place.name);
            ps.setDouble(4, place.latitude);
            ps.setDouble(5, place.longitude);
            ps.setString(6, place.urlWsdl);
            ps.setString(7, place.method);
            ps.setString(8, place.namespace);
            ps.setString(9, place.output1);
            ps.setString(10, place.output2);
            ps.setString(11, place.output3);
            ps.executeUpdate();

            result = 1;
        } catch(Exception e) {
            result = 0;
        }
        return result;
    }

    public Place getWebServicePlace(String namePlace) {
        Place p = new Place();
        Database db = new Database();
        try {
            db.open();
            String query = "SELECT name,url_wsdl,method,namespace,output1,output2,output3 FROM place WHERE name = ?";
            PreparedStatement ps = db.getConnection().prepareStatement(query);
            ps.setString(1, namePlace);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                p.setName(rs.getString("name"));
                p.setUrlWsdl(rs.getString("url_wsdl"));
                p.setMethod(rs.getString("method"));
                p.setNamespace(rs.getString("namespace"));
                p.setOutput1(rs.getString("output1"));
                p.setOutput2(rs.getString("output2"));
                p.setOutput3(rs.getString("output3"));
            }
            
        } catch(Exception e) {
            p.setName("wrong");
        }

        return p;
    }

    public List<Place> searchPlace(int id, double latitude, double longitude) {
        List<Place> listPlace = new ArrayList<Place>();
        Database db = new Database();
        double x1 = (double) (longitude - 0.02);
        double x2 = (double) (longitude + 0.02);
        double y1 = (double) (latitude + 0.02);
        double y2 = (double) (latitude - 0.02);
        //int idCat = Integer.parseInt(id);

        try {
           db.open();
            String query = "SELECT * FROM place WHERE id_category = ? AND (longitude BETWEEN ? AND ?) AND (latitude BETWEEN ? AND ?) ";
            PreparedStatement ps = db.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.setDouble(2, x1);
            ps.setDouble(3, x2);
            ps.setDouble(4, y2);
            ps.setDouble(5, y1);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Place p = new Place();
                p.setIdCategory(rs.getInt("id_category"));
                p.setIdPlace(rs.getInt("id_place"));
                p.setName(rs.getString("name"));
                p.setAddress(rs.getString("address"));
                p.setLatitude(rs.getDouble("latitude"));
                p.setLongitude(rs.getDouble("longitude"));
                listPlace.add(p);
            }
        } catch(Exception e) {
            Place p = new Place();
            p.setName("Error: "+e.getMessage());
            listPlace.add(p);
        }

        return listPlace;
    }

    public String searchOnePlace(int id, double latitude, double longitude) {
        //ArrayList<Place> listPlace = new ArrayList<Place>();
        String msg = "wew";
        Database db = new Database();
        double x1 = (double) (longitude - 0.02);
        double x2 = (double) (longitude + 0.02);
        double y1 = (double) (latitude + 0.02);
        double y2 = (double) (latitude - 0.02);
        //int idCat = Integer.parseInt(id);

        try {
           db.open();
            String query = "SELECT * FROM place WHERE id_category = ? AND (longitude BETWEEN ? AND ?) AND (latitude BETWEEN ? AND ?) ";
            PreparedStatement ps = db.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.setDouble(2, x1);
            ps.setDouble(3, x2);
            ps.setDouble(4, y2);
            ps.setDouble(5, y1);
            ResultSet rs = ps.executeQuery();

            msg = "SELECT * FROM place WHERE id_category = "+id+" AND (longitude BETWEEN "+x1+" AND "+x2+") AND (latitude BETWEEN "+y1+" AND "+y2+") ";

            while(rs.next()) {
                Place p = new Place();
                p.setIdCategory(rs.getInt("id_category"));
                p.setName(rs.getString("name"));
                p.setLatitude(rs.getDouble("latitude"));
                p.setLongitude(rs.getDouble("longitude"));
                msg = p.getName();
                //listPlace.add(p);
                msg = "bisa kok";
            }
            
        } catch(Exception e) {
            msg = "Error: "+e.getMessage();
        }
        
        return msg;
    }


}
