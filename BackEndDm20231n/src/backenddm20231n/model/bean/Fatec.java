/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.model.bean;

/**
 *
 * @author SALA PROF 211
 */
public class Fatec {
    
    private int id;
    private String cod;
    private String obs;

    public Fatec(int id) {
        this.id = id;
    }

    public Fatec(String cod) {
        this.cod = cod;
    }

    public Fatec(String cod, String obs) {
        this.cod = cod;
        this.obs = obs;
    }

    public Fatec(int id, String cod, String obs) {
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
        return "Fatecs{" + "id=" + id + ", cod=" + cod + ", obs=" + obs + '}';
    }

    
    
    
    
}
