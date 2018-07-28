/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsa.entities;

import java.io.Serializable;

/**
 *
 * @author Manish Rmc
 */
public class Country implements Serializable {
    private int cid, temperature;
    private String cname,region;

    public Country() {
    }

    public Country(int temperature, String cname, String region) {
        this.temperature = temperature;
        this.cname = cname;
        this.region = region;
    }

    public Country(int cid, int temperature, String cname, String region) {
        this.cid = cid;
        this.temperature = temperature;
        this.cname = cname;
        this.region = region;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
}
