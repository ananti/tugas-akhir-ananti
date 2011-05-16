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
public class CategoriesWrapper {
    private List<Categories> listCat = new ArrayList<Categories>();

    public List<Categories> getWrapper() {
        return this.listCat;
    }

    public void setWrapper (List<Categories> lc) {
        for (Categories c : lc) {
            listCat.add(c);
        }
    }
}
