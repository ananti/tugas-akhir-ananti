package com.app.model;

public class Category {

	public String id;
    public String name;

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(String newId) {
        this.id = newId;
    }

    public void setName(String newName) {
        this.name = newName;
    }
    
    public Category categoryParser(String input) {
    	Category cat = new Category();
    	
    	String [] tempsplit = input.split(";");
		for (String s : tempsplit) {
			if (s.contains("id")) {
				String [] tempS = s.split("=");
				for (String ss : tempS){
					if (ss!="id") {
						this.id = ss;
					}
				}
			}
			if (s.contains("name")) {
				String [] tempS = s.split("=");
				for (String ss : tempS){
					if (ss!="name") {
						this.name = ss;
					}
				}
			}
		}
    	
    	return cat;
    }
}
