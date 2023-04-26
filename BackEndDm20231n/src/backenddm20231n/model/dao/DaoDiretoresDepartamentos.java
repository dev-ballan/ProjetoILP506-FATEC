package backenddm20231n.model.dao;

import backenddm20231n.model.bean.DiretoresDepartamentos;
import backenddm20231n.util.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ballan
 */
public class DaoDiretoresDepartamentos {

private final Connection c;
    
    public DaoDiretoresDepartamentos() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public DiretoresDepartamentos excluir(DiretoresDepartamentos dirdepEnt) throws SQLException{
        String sql = "delete from diretores_departamentos WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,dirdepEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return dirdepEnt;
    }
    
    public DiretoresDepartamentos buscar(DiretoresDepartamentos dirdepEnt) throws SQLException{
        String sql = "select * from diretores_departamentos WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,dirdepEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            DiretoresDepartamentos dirdepSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                dirdepSaida = new DiretoresDepartamentos(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return dirdepSaida;
   }

    public DiretoresDepartamentos inserir(DiretoresDepartamentos dirdepEnt) throws SQLException{
        String sql = "insert into diretores_departamentos" + " (idDir, idDep, obs)" + " values (?,?,?)";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,dirdepEnt.getIdDir());
        stmt.setInt(2,dirdepEnt.getIdDep());
        stmt.setString(3,dirdepEnt.getObs());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            dirdepEnt.setId(id);
        }
        stmt.close();
        return dirdepEnt;
    }

    public DiretoresDepartamentos alterar(DiretoresDepartamentos dirdepEnt) throws SQLException{
        String sql = "UPDATE diretores_departamentos SET idDir = ?, idDep = ?, obs = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,dirdepEnt.getIdDir());
        stmt.setInt(2,dirdepEnt.getIdDep());
        stmt.setString(3,dirdepEnt.getObs());
        stmt.setInt(4,dirdepEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return dirdepEnt;
    }

   public List<DiretoresDepartamentos> listar(DiretoresDepartamentos dirdepEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<DiretoresDepartamentos> dirdeps = new ArrayList<>();
        
        String sql = "select * from diretores_departamentos where obs like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + dirdepEnt.getObs()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            DiretoresDepartamentos dirdep = new DiretoresDepartamentos(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4));
            // adiciona o usu à lista de usus
            dirdeps.add(dirdep);
        }
        
        rs.close();
        stmt.close();
        return dirdeps;
   
   }

    
}