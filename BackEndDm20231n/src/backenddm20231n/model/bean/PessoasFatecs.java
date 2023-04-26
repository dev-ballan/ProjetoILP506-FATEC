/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.model.bean;

/**
 *
 * @author SALA PROF 211
 */
public class PessoasFatecs {
    
    private int id;
    private int idP;
    private int idF;
    private String obs;
    private Pessoa pessoa;
    private Fatec fatec;

    public PessoasFatecs(int id) {
        this.id = id;
    }

    public PessoasFatecs(String obs) {
        this.obs = obs;
    }

    public PessoasFatecs(int idP, int idF, String obs) {
        this.idP = idP;
        this.idF = idF;
        this.obs = obs;
    }

    public PessoasFatecs(int id, int idP, int idF, String obs) {
        this.id = id;
        this.idP = idP;
        this.idF = idF;
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

    public int getIdF() {
        return idF;
    }

    public void setIdF(int idF) {
        this.idF = idF;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Fatec getFatec() {
        return fatec;
    }

    public void setFatec(Fatec fatec) {
        this.fatec = fatec;
    }

    @Override
    public String toString() {
        return "PessoasFatecs{" + "id=" + id + ", idP=" + idP + ", idF=" + idF + ", obs=" + obs + '}';
    }
    
}
