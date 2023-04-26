/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.controller;

import backenddm20231n.model.bean.Fatec;
import backenddm20231n.model.dao.DaoFatec;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class ControllerFatec {
    
    DaoFatec daoFatec;

    public Fatec inserir(Fatec fatEnt) throws SQLException, ClassNotFoundException {
        daoFatec = new DaoFatec();
        return daoFatec.inserir(fatEnt);
    }

    public Fatec alterar(Fatec fatEnt) throws SQLException, ClassNotFoundException {
        daoFatec = new DaoFatec();
        return daoFatec.alterar(fatEnt);
    }

    public Fatec buscar(Fatec fatEnt) throws SQLException, ClassNotFoundException {
        daoFatec = new DaoFatec();
        return daoFatec.buscar(fatEnt);
    }

    public Fatec excluir(Fatec fatEnt) throws SQLException, ClassNotFoundException {
        daoFatec = new DaoFatec();
        return daoFatec.excluir(fatEnt);
    }

     public List<Fatec> listar(Fatec fatEnt) throws SQLException, ClassNotFoundException {
        daoFatec = new DaoFatec();
        List<Fatec> listaFatec = daoFatec.listar(fatEnt);
        return listaFatec;
     }
   
}
