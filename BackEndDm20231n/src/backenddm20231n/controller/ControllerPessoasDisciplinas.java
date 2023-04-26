/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.controller;

import backenddm20231n.model.bean.Disciplina;
import backenddm20231n.model.bean.Pessoa;
import backenddm20231n.model.bean.PessoasDisciplinas;
import backenddm20231n.model.dao.DaoPessoasDisciplinas;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class ControllerPessoasDisciplinas {
    
    DaoPessoasDisciplinas daoPesDis;
    ControllerPessoa contP;
    ControllerDisciplina contD;

    
    public PessoasDisciplinas inserir(PessoasDisciplinas pesdisEnt) throws SQLException, ClassNotFoundException {
        daoPesDis = new DaoPessoasDisciplinas();
        return daoPesDis.inserir(pesdisEnt);
    }

    public PessoasDisciplinas alterar(PessoasDisciplinas pesdisEnt) throws SQLException, ClassNotFoundException {
        daoPesDis = new DaoPessoasDisciplinas();
        return daoPesDis.alterar(pesdisEnt);
    }

    public PessoasDisciplinas buscar(PessoasDisciplinas pesdisEnt) throws SQLException, ClassNotFoundException {
        daoPesDis = new DaoPessoasDisciplinas();
        PessoasDisciplinas pd = daoPesDis.buscar(pesdisEnt);
        Pessoa p = new Pessoa(pd.getIdP());
        Disciplina d = new Disciplina(pd.getIdD());
        contP = new ControllerPessoa();
        contD = new ControllerDisciplina();
        pd.setPessoa(contP.buscar(p));
        pd.setDisciplina(contD.buscar(d));
        return pd;
    }

    public PessoasDisciplinas excluir(PessoasDisciplinas pesdisEnt) throws SQLException, ClassNotFoundException {
        daoPesDis = new DaoPessoasDisciplinas();
        return daoPesDis.excluir(pesdisEnt);
    }

     public List<PessoasDisciplinas> listar(PessoasDisciplinas pesfatEnt) throws SQLException, ClassNotFoundException {
        daoPesDis = new DaoPessoasDisciplinas();
        List<PessoasDisciplinas> listapesdis = daoPesDis.listar(pesfatEnt);
        List<PessoasDisciplinas> listapesdisAux = new ArrayList<>();

        for (PessoasDisciplinas pdSaida : listapesdis) {
            listapesdisAux.add(buscar(pdSaida));
        }

        return listapesdisAux;
     }
   
}
