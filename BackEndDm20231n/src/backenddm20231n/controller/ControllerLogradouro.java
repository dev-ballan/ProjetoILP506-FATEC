/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.controller;

import backenddm20231n.model.bean.Logradouro;
import backenddm20231n.model.dao.DaoLogradouro;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class ControllerLogradouro {
    
    DaoLogradouro daoLog;

    public Logradouro inserir(Logradouro logEnt) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro();
        return daoLog.inserir(logEnt);
    }

    public Logradouro alterar(Logradouro logEnt) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro();
        return daoLog.alterar(logEnt);
    }

    public Logradouro buscar(Logradouro logEnt) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro();
        return daoLog.buscar(logEnt);
    }

    public Logradouro excluir(Logradouro logEnt) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro();
        return daoLog.excluir(logEnt);
    }

     public List<Logradouro> listar(Logradouro logEnt) throws SQLException, ClassNotFoundException {
        daoLog = new DaoLogradouro();
        List<Logradouro> listaLog = daoLog.listar(logEnt);
        return listaLog;
     }
   
}
