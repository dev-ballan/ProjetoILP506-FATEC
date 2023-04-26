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
public class PessoasDisciplinas {
    
    private int id;
    private int idP;
    private int idD;
    private String obs;
    private Pessoa pessoa;
    private Disciplina disciplina;

    public PessoasDisciplinas(int id) {
        this.id = id;
    }

    public PessoasDisciplinas(String obs) {
        this.obs = obs;
    }

    public PessoasDisciplinas(int idP, int idD, String obs) {
        this.idP = idP;
        this.idD = idD;
        this.obs = obs;
    }

    public PessoasDisciplinas(int id, int idP, int idD, String obs) {
        this.id = id;
        this.idP = idP;
        this.idD = idD;
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

    public int getIdD() {
        return idD;
    }

    public void setIdD(int idD) {
        this.idD = idD;
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

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return "PessoasDisciplinas{" + "id=" + id + ", idP=" + idP + ", idD=" + idD + ", obs=" + obs + '}';
    }
   
    
}
