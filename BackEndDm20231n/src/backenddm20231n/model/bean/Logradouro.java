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
public class Logradouro {
    
    private int id;
    private String cep;
    private String numero;
    private String compl;

    public Logradouro(int id) {
        this.id = id;
    }

    public Logradouro(String cep) {
        this.cep = cep;
    }

    public Logradouro(String cep, String numero, String compl) {
        this.cep = cep;
        this.numero = numero;
        this.compl = compl;
    }

    public Logradouro(int id, String cep, String numero, String compl) {
        this.id = id;
        this.cep = cep;
        this.numero = numero;
        this.compl = compl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCompl() {
        return compl;
    }

    public void setCompl(String compl) {
        this.compl = compl;
    }

    @Override
    public String toString() {
        return "Logradouro{" + "id=" + id + ", cep=" + cep + ", numero=" + numero + ", compl=" + compl + '}';
    }
    
    
}
