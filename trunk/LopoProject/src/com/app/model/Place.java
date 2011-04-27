package com.app.model;

public class Place {

	public String id_place;
	public String id_account;
	public String id_category;
	public String name;
	public String latitude;
	public String longitude;
	public String distance;
	public String address;
	public String phoneNumber;
	public String description;
	public String urlWsdl;
	public String method;
	public String namespace;
	public String output1;
	public String output2;
	public String output3;
	
	/*public Place() {
		this.id_account = "";
		this.id_account = "";
		this.id_category = "";
		this.name = "";
		this.latitude = "";
		this.longitude = "";
		this.urlWsdl = "";
		this.method = "";
		this.namespace = "";
		this.output1 = "";
		this.output2 = "";
		this.output3 = "";
	}
	public Place(String namePlace, String lat, String longi) {
		this.name = namePlace;
		this.latitude = lat;
		this.longitude = longi;
	}*/
	
	/*public int getIdPlace() {
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
    } */   
    
    public Place placeParser(String input) {
    	Place p = new Place();
    
    	String [] tempsplit = input.replace(" ", "").split(";");
		for (String s : tempsplit) {
			if (s.contains("idCategory")) {
				String [] tempS = s.split("=");
				for (String ss : tempS){
					if (ss!="idCategory") {
						//int temp = Integer.parseInt(ss);
						p.id_category = ss;
					}
				}
			}
			if (s.contains("name")) {
				String [] tempS = s.split("=");
				for (String ss : tempS){
					if (ss!="name") {
						p.name = ss;
					}
				}
			}
			if (s.contains("latitude")) {
				String [] tempS = s.split("=");
				for (String ss : tempS){
					if (ss!="latitude") {
						double temp = Double.parseDouble(ss);
						p.latitude = ss;
					}
				}
			}
			if (s.contains("longitude")) {
				String [] tempS = s.split("=");
				for (String ss : tempS){
					if (ss!="longitude") {
						double temp = Double.parseDouble(ss);
						p.longitude = ss;
					}
				}
			}
		}
    	
    	return p;
    }
}
