package com.app.webservice;

import java.util.ArrayList;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;

import com.app.model.Category;
import com.app.model.Place;

public class Webservice {
	private String SOAP_ACTION;
	private String METHOD_NAME;
	private String NAMESPACE;
	private String URL;
	public int count;
	
	public Webservice(String Method){
		SOAP_ACTION = "http://webservice.pinpoint.com/"+Method;
		METHOD_NAME = Method;
	    NAMESPACE =  "http://webservice.pinpoint.com/";
	    URL = "http://192.168.88.22:8080/Webservice/WebserviceService?WSDL";
	    count = 0;
	}
	
    public void setSoapAction(String newAct) {
    	this.SOAP_ACTION = newAct;
    }
    
    public void setMethodName(String newMethod) {
    	this.METHOD_NAME = newMethod;
    }
    
    public void setNamespace(String newNamespace) {
    	this.NAMESPACE = newNamespace;
    }
    
    public void setUrl(String newUrl) {
    	this.URL = newUrl;
    }
    
    public List<Place> searchPlace(int id, String latitude, String longitude) {
    	//double lat = Double.parseDouble(latitude);
    	//double longi = Double.parseDouble(longitude);
    	List<Place> resultPlace = new ArrayList<Place>();
    	String output = "";
    	try {
    		    		
    		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
       	 	//Add the input required by web service
            request.addProperty("idCategory", id);
            request.addProperty("latitude", latitude);
            request.addProperty("longitude", longitude);
            
    		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.setOutputSoapObject(request);
            
            AndroidHttpTransport androidHttpTransport = new AndroidHttpTransport(URL);
       	
         // Make the soap call.
            androidHttpTransport.call(SOAP_ACTION, envelope);             
            SoapObject obj = (SoapObject) envelope.getResponse();
            
            this.count = obj.getPropertyCount();
            for (int i = 0; i < count; i++) {
	            output = obj.getProperty(i).toString();
	            Place place = new Place();
	            String input = output;
	            String [] tempsplit = input.replace(" ", "").split(";");
	    		for (String s : tempsplit) {
	    			if (s.contains("name")) {
	    				String [] tempS = s.split("=");
	    				for (String ss : tempS){
	    					if (ss!="name") {
	    						place.name = ss;
	    					}
	    				}
	    			}
	    			
	    			if (s.contains("latitude")) {
	    				String [] tempS = s.split("=");
	    				for (String ss : tempS){
	    					if (ss!="latitude") {
	    						place.latitude = ss;
	    					}
	    				}
	    			}
	    			
	    			if (s.contains("longitude")) {
	    				String [] tempS = s.split("=");
	    				for (String ss : tempS){
	    					if (ss!="longitude") {
	    						place.longitude = ss;
	    					}
	    				}
	    			}
	    		}
	    		resultPlace.add(place);
            }
           /* place.name = output;*/
            
            /*String temp = "";
            for (int i = 0; i < count; i++) {
           	 Place p = new Place();
           	 p.placeParser(obj.getProperty(i).toString());           	 	 
           	 resultPlace.add(p);
            }*/
            
            //c.name = temp;
            
    	} catch (Exception e) {
			// TODO: handle exception
    		Place p = new Place();
    		p.name = ""+e.getMessage();
    		resultPlace.add(p);
		}
    	
    	return resultPlace;
    }
    
    public ArrayList<Category> getCategory() {
    	ArrayList<Category> resultCat = new ArrayList<Category>();
    	String output = "";
    	try {
    		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
    		
    		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.setOutputSoapObject(request);
            
            AndroidHttpTransport androidHttpTransport = new AndroidHttpTransport(URL);
       	
         // Make the soap call.
            androidHttpTransport.call(SOAP_ACTION, envelope);             
            SoapObject obj = (SoapObject) envelope.getResponse();
            
            this.count = obj.getPropertyCount();
            
            //output = obj.getProperty(index).toString();
            for (int i = 0; i < count; i++) {
           	 Category c = new Category();
           	 c.categoryParser(obj.getProperty(i).toString());
           	 resultCat.add(c);
            }
    	} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	return resultCat;
    }
    
    public String sendLogin(String username, String password) {
    	String output = "";
    	try {
    		 SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        	 //Add the input required by web service
             request.addProperty("username", username);
             request.addProperty("password", password);  
        	                        
             SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
             envelope.setOutputSoapObject(request);
             
             AndroidHttpTransport androidHttpTransport = new AndroidHttpTransport(URL);
        	
             //Make the soap call            
             androidHttpTransport.call(SOAP_ACTION, envelope); 
             
             output = envelope.getResponse().toString();
    	} catch(Exception e) {
    		System.out.println(e.toString());
            e.printStackTrace();
            output = ""+e.getMessage()+" : "+e.getCause();
    	}
    	
    	return output;
    }
    
    public String sendRegister(String username, String password, String email) {
    	String output = "";
    	try {
    		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
       	 	//Add the input required by web service
            request.addProperty("username", username);
            request.addProperty("password", password);
            request.addProperty("email", email);
       	                        
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.setOutputSoapObject(request);
            
            AndroidHttpTransport androidHttpTransport = new AndroidHttpTransport(URL);
       	
            //Make the soap call            
            androidHttpTransport.call(SOAP_ACTION, envelope); 
            
            output = envelope.getResponse().toString();
    	} catch(Exception e) {
    		System.out.println(e.toString());
            e.printStackTrace();
            output = ""+e.getMessage()+" : "+e.getCause();
    	}
    	
    	return output;
    }
}
