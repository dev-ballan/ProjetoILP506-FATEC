package backenddm20231n.model.dao;

import backenddm20231n.model.bean.Diretor;
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
public class DaoDiretor {

private final Connection c;
    
    public DaoDiretor() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Diretor excluir(Diretor dirEnt) throws SQLException{
        String sql = "delete from diretores WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,dirEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return dirEnt;
    }
    
    public Diretor buscar(Diretor dirEnt) throws SQLException{
        String sql = "select * from diretores WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,dirEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Diretor dirSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                dirSaida = new Diretor(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
             // adiciona o usu à lista de usus
            }
            stmt.close();
        return dirSaida;
   }

    public Diretor inserir(Diretor dirEnt) throws SQLException{
        String sql = "insert into diretores" + " (nome, setor, obs)" + " values (?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,dirEnt.getNome());
        stmt.setString(2,dirEnt.getSetor());
        stmt.setString(3,dirEnt.getObs());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            dirEnt.setId(id);
        }
        stmt.close();
        return dirEnt;
    }

    public Diretor alterar(Diretor dirEnt) throws SQLException{
        String sql = "UPDATE diretores SET nome = ?, setor = ?, obs = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,dirEnt.getNome());
        stmt.setString(2, dirEnt.getSetor());
        stmt.setString(3,dirEnt.getObs());
        stmt.setInt(4,dirEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return dirEnt;
    }

   public List<Diretor> listar(Diretor dirEnt) throws SQLException{
        // diretores: array armazena a lista de registros

        List<Diretor> diretores = new ArrayList<>();
        
        String sql = "select * from diretores where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + dirEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Diretor
            Diretor dir = new Diretor(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4)
            );
            // adiciona o dir à lista de diretores
            diretores.add(dir);
        }
        
        rs.close();
        stmt.close();
        return diretores;
   
   }

    
}