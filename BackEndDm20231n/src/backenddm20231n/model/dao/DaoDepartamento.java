package backenddm20231n.model.dao;

import backenddm20231n.model.bean.Departamento;
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
public class DaoDepartamento {

private final Connection c;
    
    public DaoDepartamento() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Departamento excluir(Departamento depEnt) throws SQLException{
        String sql = "delete from departamentos WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,depEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return depEnt;
    }
    
    public Departamento buscar(Departamento depEnt) throws SQLException{
        String sql = "select * from departamentos WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,depEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Departamento depSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                depSaida = new Departamento(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
             // adiciona o usu à lista de usus
            }
            stmt.close();
        return depSaida;
   }

    public Departamento inserir(Departamento depEnt) throws SQLException{
        String sql = "insert into departamentos" + " (nome, cod, descricao)" + " values (?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,depEnt.getNome());
        stmt.setString(2,depEnt.getcod());
        stmt.setString(3,depEnt.getdescricao());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            depEnt.setId(id);
        }
        stmt.close();
        return depEnt;
    }

    public Departamento alterar(Departamento depEnt) throws SQLException{
        String sql = "UPDATE departamentos SET nome = ?, descricao = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,depEnt.getNome());
        stmt.setString(2,depEnt.getcod());
        stmt.setString(3,depEnt.getdescricao());
        stmt.setInt(4,depEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return depEnt;
    }

   public List<Departamento> listar(Departamento depEnt) throws SQLException{
        // departamentos: array armazena a lista de registros

        List<Departamento> departamentos = new ArrayList<>();
        
        String sql = "select * from departamentos where cod like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + depEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Departamento
            Departamento dep = new Departamento(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4)
            );
            // adiciona o dep à lista de departamentos
            departamentos.add(dep);
        }
        
        rs.close();
        stmt.close();
        return departamentos;
   
   }

    
}