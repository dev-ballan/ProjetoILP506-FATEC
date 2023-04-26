/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.controller;

import backenddm20231n.model.bean.Logradouro;
import backenddm20231n.model.bean.Pessoa;
import backenddm20231n.model.bean.PessoasLogradouros;
import backenddm20231n.model.dao.DaoPessoasLogradouros;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class ControllerPessoasLogradouros {
    
    DaoPessoasLogradouros daoPesLog;
    ControllerPessoa contP;
    ControllerLogradouro contL;

    
    public PessoasLogradouros inserir(PessoasLogradouros peslogEnt) throws SQLException, ClassNotFoundException {
        daoPesLog = new DaoPessoasLogradouros();
        return daoPesLog.inserir(peslogEnt);
    }

    public PessoasLogradouros alterar(PessoasLogradouros peslogEnt) throws SQLException, ClassNotFoundException {
        daoPesLog = new DaoPessoasLogradouros();
        return daoPesLog.alterar(peslogEnt);
    }

    public PessoasLogradouros buscar(PessoasLogradouros peslogEnt) throws SQLException, ClassNotFoundException {
        daoPesLog = new DaoPessoasLogradouros();
        PessoasLogradouros pl = daoPesLog.buscar(peslogEnt);
        Pessoa p = new Pessoa(pl.getIdP());
        Logradouro l = new Logradouro(pl.getIdL());
        contP = new ControllerPessoa();
        contL = new ControllerLogradouro();
        pl.setP(contP.buscar(p));
        pl.setL(contL.buscar(l));
        return pl;
    }

    public PessoasLogradouros excluir(PessoasLogradouros peslogEnt) throws SQLException, ClassNotFoundException {
        daoPesLog = new DaoPessoasLogradouros();
        return daoPesLog.excluir(peslogEnt);
    }

     public List<PessoasLogradouros> listar(PessoasLogradouros peslogEnt) throws SQLException, ClassNotFoundException {
        daoPesLog = new DaoPessoasLogradouros();
        List<PessoasLogradouros> listapeslog = daoPesLog.listar(peslogEnt);
        for (PessoasLogradouros plSaida : listapeslog) {
            Pessoa p = new Pessoa(plSaida.getIdP());
            contP = new ControllerPessoa();
            plSaida.setP(contP.buscar(p));
            Logradouro l = new Logradouro(plSaida.getIdL());
            contL = new ControllerLogradouro();
            plSaida.setL(contL.buscar(l));
        }


        return listapeslog;
     }
   
}
