/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.model.bean;

/**
 *
 * @author User
 */
public class PessoasLogradouros {
    
    private int id;
    private int idP;
    private int idL;
    private String obs;
    private Pessoa p;
    private Logradouro l;

    public PessoasLogradouros(int id) {
        this.id = id;
    }

    public PessoasLogradouros(String obs) {
        this.obs = obs;
    }

    public PessoasLogradouros(int idP, int idL, String obs) {
        this.idP = idP;
        this.idL = idL;
        this.obs = obs;
    }

    public PessoasLogradouros(int id, int idP, int idL, String obs) {
        this.id = id;
        this.idP = idP;
        this.idL = idL;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public int getIdL() {
        return idL;
    }

    public void setIdL(int idL) {
        this.idL = idL;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Pessoa getP() {
        return p;
    }

    public void setP(Pessoa p) {
        this.p = p;
    }

    public Logradouro getL() {
        return l;
    }

    public void setL(Logradouro l) {
        this.l = l;
    }

    @Override
    public String toString() {
        return "PessoasLogradouros{" + "id=" + id + ", idP=" + idP + ", idL=" + idL + ", obs=" + obs + '}';
    }
    
    
    
    
    
    
    
}
