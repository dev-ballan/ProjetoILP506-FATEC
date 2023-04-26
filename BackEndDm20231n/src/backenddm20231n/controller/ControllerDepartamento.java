package backenddm20231n.controller;

import backenddm20231n.model.bean.Departamento;
import backenddm20231n.model.dao.DaoDepartamento;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ballan
 */
public class ControllerDepartamento {
    
    DaoDepartamento daoDep;

    public Departamento inserir(Departamento depEnt) throws SQLException, ClassNotFoundException {
        daoDep = new DaoDepartamento();
        return daoDep.inserir(depEnt);
    }

    public Departamento alterar(Departamento depEnt) throws SQLException, ClassNotFoundException {
        daoDep = new DaoDepartamento();
        return daoDep.alterar(depEnt);
    }

    public Departamento buscar(Departamento depEnt) throws SQLException, ClassNotFoundException {
        daoDep = new DaoDepartamento();
        return daoDep.buscar(depEnt);
    }

    public Departamento excluir(Departamento depEnt) throws SQLException, ClassNotFoundException {
        daoDep = new DaoDepartamento();
        return daoDep.excluir(depEnt);
    }

     public List<Departamento> listar(Departamento depEnt) throws SQLException, ClassNotFoundException {
        daoDep = new DaoDepartamento();
        List<Departamento> listaDepartamentos = daoDep.listar(depEnt);
        return listaDepartamentos;
     }
   
}