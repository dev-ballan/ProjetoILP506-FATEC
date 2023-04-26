/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.controller;

import backenddm20231n.model.bean.Disciplina;
import backenddm20231n.model.dao.DaoDisciplina;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class ControllerDisciplina {
    
    DaoDisciplina daoDisciplina;

    public Disciplina inserir(Disciplina disEnt) throws SQLException, ClassNotFoundException {
        daoDisciplina = new DaoDisciplina();
        return daoDisciplina.inserir(disEnt);
    }

    public Disciplina alterar(Disciplina disEnt) throws SQLException, ClassNotFoundException {
        daoDisciplina = new DaoDisciplina();
        return daoDisciplina.alterar(disEnt);
    }

    public Disciplina buscar(Disciplina disEnt) throws SQLException, ClassNotFoundException {
        daoDisciplina = new DaoDisciplina();
        return daoDisciplina.buscar(disEnt);
    }

    public Disciplina excluir(Disciplina disEnt) throws SQLException, ClassNotFoundException {
        daoDisciplina = new DaoDisciplina();
        return daoDisciplina.excluir(disEnt);
    }

     public List<Disciplina> listar(Disciplina disEnt) throws SQLException, ClassNotFoundException {
        daoDisciplina = new DaoDisciplina();
        List<Disciplina> listaDisciplina = daoDisciplina.listar(disEnt);
        return listaDisciplina;
     }
   
}
