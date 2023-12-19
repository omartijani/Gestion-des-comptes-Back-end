package com.lydec.gestioncomptes.model;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Utilisateurs {
    @Id
    @Column(name ="login")
    private String login;
    @Column(name ="matr")
    private int matr;
    @Column(name ="passwd_webs")
    private String passwdWebs;
    @Column(name ="matwebs_pass_cler")
    private String websPassCle;
    @Column(name ="agc_code")
    private int agcCode;
    @Column(name ="site_approv")
    private int siteApprov;
    @Column(name ="user_fix")
    private String userFix;
    @Column(name ="passwd_fix")
    private String passwdFix;
    @Column(name ="ifx_pass_cle")
    private String ifxPassCle;
    @Column(name ="cltsa_valide")
    private String cltsaValide;
    @Column(name ="user_ad")
    private String userAd;
    @Column(name ="passwd_ad")
    private String passwdAd;


    @ManyToMany
    @JoinTable(
    name = "t_profil_utilisateur",
    joinColumns = @JoinColumn(name = "login"),
    inverseJoinColumns = @JoinColumn(name = "prof_num"))
    Set<Prfl> profiles;




    public Utilisateurs() {
        super();
    }

    public String getLogin() {
        return login;
    }

    public int getMatr() {
        return matr;
    }

    public void setMatr(int matr) {
        this.matr = matr;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswdWebs() {
        return passwdWebs;
    }

    public void setPasswdWebs(String passwdWebs) {
        this.passwdWebs = passwdWebs;
    }

    public String getWebsPassCle() {
        return websPassCle;
    }

    public void setWebsPassCle(String websPassCle) {
        this.websPassCle = websPassCle;
    }

    public int getAgcCode() {
        return agcCode;
    }

    public void setAgcCode(int agcCode) {
        this.agcCode = agcCode;
    }

    public int getSiteApprov() {
        return siteApprov;
    }

    public void setSiteApprov(int siteApprov) {
        this.siteApprov = siteApprov;
    }

    public String getUserFix() {
        return userFix;
    }

    public void setUserFix(String userFix) {
        this.userFix = userFix;
    }

    public String getPasswdFix() {
        return passwdFix;
    }

    public void setPasswdFix(String passwdFix) {
        this.passwdFix = passwdFix;
    }

    public String getIfxPassCle() {
        return ifxPassCle;
    }

    public void setIfxPassCle(String ifxPassCle) {
        this.ifxPassCle = ifxPassCle;
    }

    public String getCltsaValide() {
        return cltsaValide;
    }

    public void setCltsaValide(String cltsaValide) {
        this.cltsaValide = cltsaValide;
    }

    public String getUserAd() {
        return userAd;
    }

    public void setUserAd(String userAd) {
        this.userAd = userAd;
    }

    public String getPasswdAd() {
        return passwdAd;
    }

    public void setPasswdAd(String passwdAd) {
        this.passwdAd = passwdAd;
    }

    public Set<Prfl> getProfiles() {
        return profiles;
    }

    public void setProfiles(Set<Prfl> profiles) {
        this.profiles = profiles;
    }

    public Utilisateurs(String login, int matr, String passwdWebs, String websPassCle, int agcCode,
                        int siteApprov, String userFix, String passwdFix, String ifxPassCle,
                        String cltsaValide, String userAd, String passwdAd, Set<Prfl> profiles) {
        this.login = login;
        this.matr = matr;
        this.passwdWebs = passwdWebs;
        this.websPassCle = websPassCle;
        this.agcCode = agcCode;
        this.siteApprov = siteApprov;
        this.userFix = userFix;
        this.passwdFix = passwdFix;
        this.ifxPassCle = ifxPassCle;
        this.cltsaValide = cltsaValide;
        this.userAd = userAd;
        this.passwdAd = passwdAd;
        this.profiles = profiles;
    }
}
