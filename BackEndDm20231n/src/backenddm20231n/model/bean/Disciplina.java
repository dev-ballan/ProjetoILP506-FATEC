/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.model.bean;

/**
 *
 * @author lab04aluno
 */
public class Disciplina {
    
    private int id;
    private String cod;
    private String obs;

    public Disciplina(int id) {
        this.id = id;
    }

    public Disciplina(String cod) {
        this.cod = cod;
    }

    public Disciplina(String cod, String obs) {
        this.cod = cod;
        this.obs = obs;
    }

    public Disciplina(int id, String cod, String obs) {
        this.id = id;
        this.cod = cod;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "id=" + id + ", cod=" + cod + ", obs=" + obs + '}';
    }
    
    
    
}
