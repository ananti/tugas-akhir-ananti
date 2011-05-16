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
public class CommentWrapper {

    private List<Comment> listComment = new ArrayList<Comment>();

    public List<Comment> getWrapper() {
        return this.listComment;
    }

    public void setWrapper(List<Comment> lc) {
        for (Comment c : lc) {
            listComment.add(c);
        }
    }
}
