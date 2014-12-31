/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.dto;

import java.io.Serializable;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rupesht
 */
public abstract class AbstractDTO implements Serializable {

    private int _id = -9;
    private String _name = null;

    // ====================================
    // Constructor
    // ====================================
    public AbstractDTO() {
    }

    // ====================================
    // Public methods
    // ====================================
    public abstract String toString();

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public Date getDate(String format) {
        SimpleDateFormat sf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = sf.parse(format, new ParsePosition(0));
        return date;
    }

    public String formatDate(Date date) {
        SimpleDateFormat sf = new SimpleDateFormat("MM/dd/yyyy");
        String strdate = sf.format(date);
        return strdate;
    }
}
