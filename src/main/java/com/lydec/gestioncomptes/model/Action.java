package com.lydec.gestioncomptes.model;

import javax.persistence.*;

import java.util.Set;


@Entity
public class Action {
    @Id
    @Column(name = "act_id")
    private String actId;

    @Column(name = "act_bsecurise")
    private String actBsecurise;
    @Column(name = "act_lib")
    private String actLib;
    @Column(name = "act_lb")
    private String actLb;


    @ManyToOne
    @JoinColumn(name="app_id",nullable = false)
    private  Apps apps;



    public Action() {
        super();
    }


    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public String getActBsecurise() {
        return actBsecurise;
    }

    public void setActBsecurise(String actBsecurise) {
        this.actBsecurise = actBsecurise;
    }

    public String getActLib() {
        return actLib;
    }

    public void setActLib(String actLib) {
        this.actLib = actLib;
    }

    public String getActLb() {
        return actLb;
    }

    public void setActLb(String actLb) {
        this.actLb = actLb;
    }


    public Apps getApps() {
        return apps;
    }

    public void setApps(Apps apps) {
        this.apps = apps;
    }

    public Action(String actId, String actBsecurise, String actLib, String actLb,  Apps apps) {
        this.actId = actId;
        this.actBsecurise = actBsecurise;
        this.actLib = actLib;
        this.actLb = actLb;

        this.apps = apps;
    }
}
