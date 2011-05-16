/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pinpoint.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ananti
 */
public class PlacesWrapper {

    private List<Place> listPlace = new ArrayList<Place>();

    public List<Place> getWrapper() {
        return this.listPlace;
    }

    public void setWrapper (List<Place> lp) {
        for (Place p : lp) {
            listPlace.add(p);
        }
    }
}
