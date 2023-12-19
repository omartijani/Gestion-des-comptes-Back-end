package com.lydec.gestioncomptes.model;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Prfl {
    @Id
    @Column(name = "prof_num")
    private Integer profNum;
    @Column(name = "prof_nom")
    private String profNom;



    @ManyToMany
    @JoinTable(
            name = "t_action_profil",
            joinColumns = @JoinColumn(name = "prof_num"),
            inverseJoinColumns = @JoinColumn(name = "act_id"))
    Set<Action> actions;


    public Prfl() {

        super();
    }

    public Integer getProfNum() {
        return profNum;
    }

    public void setProfNum(Integer profNum) {
        this.profNum = profNum;
    }

    public String getProfNom() {
        return profNom;
    }

    public void setProfNom(String profNom) {
        this.profNom = profNom;
    }



    public Set<Action> getActions() {
        return actions;
    }

    public void setActions(Set<Action> actions) {
        this.actions = actions;
    }

    public Prfl(Integer profNum, String profNom,Set<Action> actions) {
        this.profNum = profNum;
        this.profNom = profNom;
        this.actions = actions;
    }
}