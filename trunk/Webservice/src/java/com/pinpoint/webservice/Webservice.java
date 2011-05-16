/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pinpoint.webservice;

import com.pinpoint.model.Account;
import com.pinpoint.model.Categories;
import com.pinpoint.model.CategoriesWrapper;
import com.pinpoint.model.Comment;
import com.pinpoint.model.CommentWrapper;
import com.pinpoint.model.Place;
import com.pinpoint.model.PlacesWrapper;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Ananti
 */
@WebService()
public class Webservice {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Login")
    public int Login(@WebParam(name = "username")
    String username, @WebParam(name = "password")
    String password) {            
        Account account = new Account();
        return account.Login(username, password);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Register")
    public int Register(@WebParam(name = "username")
    String username, @WebParam(name = "password")
    String password, @WebParam(name = "email")
    String email) {
        Account acc = new Account();
        acc.setUsername(username);
        acc.setPassword(password);
        acc.setEmail(email);

        return acc.Register(acc);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Contribute")
    public int Contribute(@WebParam(name = "id_category")
    int id_category, @WebParam(name = "id_account")
    int id_account, @WebParam(name = "name")
    String name, @WebParam(name = "latitude")
    double latitude, @WebParam(name = "longitude")
    double longitude, @WebParam(name = "url_wsdl")
    String url_wsdl, @WebParam(name = "method")
    String method, @WebParam(name = "namespace")
    String namespace, @WebParam(name = "output1")
    String output1, @WebParam(name = "output2")
    String output2, @WebParam(name = "output3")
    String output3) {
        Place place = new Place();
        place.setIdCategory(id_category);
        place.setIdAccount(id_account);
        place.setName(name);
        place.setLatitude(latitude);
        place.setLongitude(longitude);
        place.setUrlWsdl(url_wsdl);
        place.setMethod(method);
        place.setNamespace(namespace);
        place.setOutput1(output1);
        place.setOutput2(output2);
        place.setOutput3(output3);

        return place.contributePlace(place);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCategories")
    public CategoriesWrapper getCategories() {
        CategoriesWrapper cw = new CategoriesWrapper();
        Categories cat = new Categories();
        cw.setWrapper(cat.getCategories());
        return cw;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getWebservicePlace")
    public Place getWebservicePlace(@WebParam(name = "namePlace")
    String namePlace) {
        Place p = new Place();
        return p.getWebServicePlace(namePlace);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "sendComment")
    public int sendComment(@WebParam(name = "idCategory")
    int idCategory, @WebParam(name = "namePlace")
    String namePlace, @WebParam(name = "rating")
    int rating, @WebParam(name = "content")
    String content) {
        Comment c = new Comment();
        c.setIdCategory(idCategory);
        c.setContent(content);
        c.setNamePlace(namePlace);
        c.setRating(rating);
        return c.sendComment(c);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllComment")
    public CommentWrapper getAllComment(@WebParam(name = "idCategory")
    int idCategory, @WebParam(name = "namePlace")
    String namePlace) {
        CommentWrapper cw = new CommentWrapper();
        Comment c = new Comment();
        cw.setWrapper(c.getAllComment(idCategory, namePlace));
        return cw;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getComment")
    public CommentWrapper getComment(@WebParam(name = "idCategory")
    int idCategory, @WebParam(name = "namePlace")
    String namePlace) {
        CommentWrapper cw = new CommentWrapper();
        Comment c = new Comment();
        cw.setWrapper(c.getComment(idCategory, namePlace));
        return cw;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchPlace")
    public PlacesWrapper searchPlace(@WebParam(name = "idCategory")
    int idCategory, @WebParam(name = "latitude")
    String latitude, @WebParam(name = "longitude")
    String longitude) {
        double lat = Double.parseDouble(latitude);
        double longi = Double.parseDouble(longitude);
        PlacesWrapper pw = new PlacesWrapper();
        Place p = new Place();
        pw.setWrapper(p.searchPlace(idCategory, lat, longi));
//        List<Place> pw = new ArrayList<Place>();
//        Place p = new Place();
//        pw = p.searchPlace(idCategory, latitude, longitude);
        return pw;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchOnePlace")
    public String searchOnePlace(@WebParam(name = "idCategory")
    int idCategory, @WebParam(name = "latitude")
    double latitude, @WebParam(name = "longitude")
    double longitude) {
        Place p = new Place();
        return p.searchOnePlace(idCategory, latitude, longitude);
    }

    


}
