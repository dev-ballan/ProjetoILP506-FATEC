/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.controller;

import backenddm20231n.model.bean.Fatec;
import backenddm20231n.model.bean.Pessoa;
import backenddm20231n.model.bean.PessoasFatecs;
import backenddm20231n.model.dao.DaoPessoasFatecs;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class ControllerPessoasFatecs {
    
    DaoPessoasFatecs daoPesFat;
    ControllerPessoa contP;
    ControllerFatec contF;

    
    public PessoasFatecs inserir(PessoasFatecs pesfatEnt) throws SQLException, ClassNotFoundException {
        daoPesFat = new DaoPessoasFatecs();
        return daoPesFat.inserir(pesfatEnt);
    }

    public PessoasFatecs alterar(PessoasFatecs pesfatEnt) throws SQLException, ClassNotFoundException {
        daoPesFat = new DaoPessoasFatecs();
        return daoPesFat.alterar(pesfatEnt);
    }

    public PessoasFatecs buscar(PessoasFatecs pesfatEnt) throws SQLException, ClassNotFoundException {
        daoPesFat = new DaoPessoasFatecs();
        PessoasFatecs pf = daoPesFat.buscar(pesfatEnt);
        Pessoa p = new Pessoa(pf.getIdP());
        Fatec f = new Fatec(pf.getIdF());
        contP = new ControllerPessoa();
        contF = new ControllerFatec();
        pf.setPessoa(contP.buscar(p));
        pf.setFatec(contF.buscar(f));
        return pf;
    }

    public PessoasFatecs excluir(PessoasFatecs pesfatEnt) throws SQLException, ClassNotFoundException {
        daoPesFat = new DaoPessoasFatecs();
        return daoPesFat.excluir(pesfatEnt);
    }

     public List<PessoasFatecs> listar(PessoasFatecs pesfatEnt) throws SQLException, ClassNotFoundException {
        daoPesFat = new DaoPessoasFatecs();
        List<PessoasFatecs> listapesfat = daoPesFat.listar(pesfatEnt);
        List<PessoasFatecs> listapesfatAux = new ArrayList<>();

        for (PessoasFatecs pfSaida : listapesfat) {
            listapesfatAux.add(buscar(pfSaida));
        }

        return listapesfatAux;
     }
   
}
