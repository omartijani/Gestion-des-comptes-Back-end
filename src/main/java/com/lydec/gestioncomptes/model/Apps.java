package com.lydec.gestioncomptes.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Apps {
    @Id
    @Column(name = "app_id")
    private String appId;
    @Column(name = "app_domaine")
    private String appDomaine;
    @Column(name = "app_version")
    private String appVersion;
    @Column(name = "app_help")
    private String appHelp;
    @Column(name = "app_auteur")
    private String appAuteur;
    @Column(name = "app_creation")
    private Date  appCreation;
    @Column(name = "app_modifcation")
    private Date appModifcation;
    @Column(name = "app_ouverte")
    private String appOuverte;
    @Column(name = "app_dat_fermeture")
    private Date appDatFermeture;
    @Column(name = "app_typ_msg")
    private String appTypMsg;
    @Column(name = "app_lib_msg")
    private String appLibMsg;
    @Column(name = "app_lb")
    private String appLb;

    public Apps() {
        super();
    }


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppDomaine() {
        return appDomaine;
    }

    public void setAppDomaine(String appDomaine) {
        this.appDomaine = appDomaine;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getAppHelp() {
        return appHelp;
    }

    public void setAppHelp(String appHelp) {
        this.appHelp = appHelp;
    }

    public String getAppAuteur() {
        return appAuteur;
    }


    public void setAppAuteur(String appAuteur) {
        this.appAuteur = appAuteur;
    }

    public Date getAppCreation() {
        return appCreation;
    }

    public void setAppCreation(Date appCreation) {
        this.appCreation = appCreation;
    }

    public Date getAppModifcation() {
        return appModifcation;
    }

    public void setAppModifcation(Date appModifcation) {
        this.appModifcation = appModifcation;
    }

    public String getAppOuverte() {
        return appOuverte;
    }

    public void setAppOuverte(String appOuverte) {
        this.appOuverte = appOuverte;
    }

    public Date getAppDatFermeture() {
        return appDatFermeture;
    }

    public void setAppDatFermeture(Date appDatFermeture) {
        this.appDatFermeture = appDatFermeture;
    }

    public String getAppTypMsg() {
        return appTypMsg;
    }

    public void setAppTypMsg(String appTypMsg) {
        this.appTypMsg = appTypMsg;
    }

    public String getAppLibMsg() {
        return appLibMsg;
    }

    public void setAppLibMsg(String appLibMsg) {
        this.appLibMsg = appLibMsg;
    }

    public String getAppLb() {
        return appLb;
    }

    public void setAppLb(String appLb) {
        this.appLb = appLb;
    }

    public Apps(String appId, String appDomaine, String appVersion, String appHelp,
                String appAuteur, Date appCreation, Date appModifcation, String appOuverte,
                Date appDatFermeture, String appTypMsg, String appLibMsg, String appLb) {
        this.appId = appId;
        this.appDomaine = appDomaine;
        this.appVersion = appVersion;
        this.appHelp = appHelp;
        this.appAuteur = appAuteur;
        this.appCreation = appCreation;
        this.appModifcation = appModifcation;
        this.appOuverte = appOuverte;
        this.appDatFermeture = appDatFermeture;
        this.appTypMsg = appTypMsg;
        this.appLibMsg = appLibMsg;
        this.appLb = appLb;

    }
}
