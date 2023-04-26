package backenddm20231n.controller;

import backenddm20231n.model.bean.Departamento;
import backenddm20231n.model.bean.Diretor;
import backenddm20231n.model.bean.DiretoresDepartamentos;
import backenddm20231n.model.dao.DaoDiretoresDepartamentos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ballan
 */
public class ControllerDiretoresDepartamentos {
    
    DaoDiretoresDepartamentos daoDirDep;
    ControllerDiretor contDir;
    ControllerDepartamento contDep;

    
    public DiretoresDepartamentos inserir(DiretoresDepartamentos dirdepEnt) throws SQLException, ClassNotFoundException {
        daoDirDep = new DaoDiretoresDepartamentos();
        return daoDirDep.inserir(dirdepEnt);
    }

    public DiretoresDepartamentos alterar(DiretoresDepartamentos dirdepEnt) throws SQLException, ClassNotFoundException {
        daoDirDep = new DaoDiretoresDepartamentos();
        return daoDirDep.alterar(dirdepEnt);
    }

    public DiretoresDepartamentos buscar(DiretoresDepartamentos dirdepEnt) throws SQLException, ClassNotFoundException {
        daoDirDep = new DaoDiretoresDepartamentos();
        DiretoresDepartamentos dd = daoDirDep.buscar(dirdepEnt);
        Diretor di = new Diretor(dd.getIdDir());
        Departamento de = new Departamento(dd.getIdDep());
        contDir = new ControllerDiretor();
        contDep = new ControllerDepartamento();
        dd.setDiretor(contDir.buscar(di));
        dd.setDepartamento(contDep.buscar(de));
        return dd;
    }

    public DiretoresDepartamentos excluir(DiretoresDepartamentos dirdepEnt) throws SQLException, ClassNotFoundException {
        daoDirDep = new DaoDiretoresDepartamentos();
        return daoDirDep.excluir(dirdepEnt);
    }

     public List<DiretoresDepartamentos> listar(DiretoresDepartamentos dirdepEnt) throws SQLException, ClassNotFoundException {
        daoDirDep = new DaoDiretoresDepartamentos();
        List<DiretoresDepartamentos> listadirdep = daoDirDep.listar(dirdepEnt);
        List<DiretoresDepartamentos> listadirdepAux = new ArrayList<>();

        for (DiretoresDepartamentos ddSaida : listadirdep) {
            listadirdepAux.add(buscar(ddSaida));
        }

        return listadirdepAux;
     }
   
}