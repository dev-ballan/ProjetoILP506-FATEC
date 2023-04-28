package backenddm20231n.controller;

import backenddm20231n.model.bean.Diretor;
import backenddm20231n.model.dao.DaoDiretor;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ballan
 */
public class ControllerDiretor {
    
    DaoDiretor daoDir;

    public Diretor inserir(Diretor dirEnt) throws SQLException, ClassNotFoundException {
        daoDir = new DaoDiretor();
        return daoDir.inserir(dirEnt);
    }

    public Diretor alterar(Diretor dirEnt) throws SQLException, ClassNotFoundException {
        daoDir = new DaoDiretor();
        return daoDir.alterar(dirEnt);
    }

    public Diretor buscar(Diretor dirEnt) throws SQLException, ClassNotFoundException {
        daoDir = new DaoDiretor();
        return daoDir.buscar(dirEnt);
    }

    public Diretor excluir(Diretor dirEnt) throws SQLException, ClassNotFoundException {
        daoDir = new DaoDiretor();
        return daoDir.excluir(dirEnt);
    }

     public List<Diretor> listar(Diretor dirEnt) throws SQLException, ClassNotFoundException {
        daoDir = new DaoDiretor();
        List<Diretor> listaDiretor = daoDir.listar(dirEnt);
        return listaDiretor;
     }
   
}
