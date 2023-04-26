/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.model.dao;

import backenddm20231n.model.bean.Fatec;
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
 * @author FATEC ZONA LESTE
 */
public class DaoFatec {

private final Connection c;
    
    public DaoFatec() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Fatec excluir(Fatec fatEnt) throws SQLException{
        String sql = "delete from fatecs WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,fatEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return fatEnt;
    }
    
    public Fatec buscar(Fatec fatEnt) throws SQLException{
        String sql = "select * from fatecs WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,fatEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Fatec logSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                logSaida = new Fatec(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return logSaida;
   }

    public Fatec inserir(Fatec fatEnt) throws SQLException{
        String sql = "insert into fatecs" + " (cod, obs)" + " values (?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,fatEnt.getCod());
        stmt.setString(2,fatEnt.getObs());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            fatEnt.setId(id);
        }
        stmt.close();
        return fatEnt;
    }

    public Fatec alterar(Fatec fatEnt) throws SQLException{
        String sql = "UPDATE fatecs SET cod = ?, obs = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,fatEnt.getCod());
        stmt.setString(2,fatEnt.getObs());
        stmt.setInt(3,fatEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return fatEnt;
    }

   public List<Fatec> listar(Fatec fatEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Fatec> fats = new ArrayList<>();
        
        String sql = "select * from fatecs where cod like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + fatEnt.getCod() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Fatec fat = new Fatec(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3));
            // adiciona o usu à lista de usus
            fats.add(fat);
        }
        
        rs.close();
        stmt.close();
        return fats;
   
   }

    
}
