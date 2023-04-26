/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.model.dao;

import backenddm20231n.model.bean.PessoasFatecs;
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
public class DaoPessoasFatecs {

private final Connection c;
    
    public DaoPessoasFatecs() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public PessoasFatecs excluir(PessoasFatecs pesfatEnt) throws SQLException{
        String sql = "delete from pessoas_fatecs WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,pesfatEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return pesfatEnt;
    }
    
    public PessoasFatecs buscar(PessoasFatecs pesfatEnt) throws SQLException{
        String sql = "select * from pessoas_fatecs WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,pesfatEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            PessoasFatecs pesfatSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                pesfatSaida = new PessoasFatecs(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return pesfatSaida;
   }

    public PessoasFatecs inserir(PessoasFatecs pesfatEnt) throws SQLException{
        String sql = "insert into pessoas_fatecs" + " (idP, idF, obs)" + " values (?,?,?)";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,pesfatEnt.getIdP());
        stmt.setInt(2,pesfatEnt.getIdF());
        stmt.setString(3,pesfatEnt.getObs());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            pesfatEnt.setId(id);
        }
        stmt.close();
        return pesfatEnt;
    }

    public PessoasFatecs alterar(PessoasFatecs pesfatEnt) throws SQLException{
        String sql = "UPDATE pessoas_fatecs SET idP = ?, idF = ?, obs = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,pesfatEnt.getIdP());
        stmt.setInt(2,pesfatEnt.getIdF());
        stmt.setString(3,pesfatEnt.getObs());
        stmt.setInt(4,pesfatEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return pesfatEnt;
    }

   public List<PessoasFatecs> listar(PessoasFatecs pesfatEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<PessoasFatecs> pesfats = new ArrayList<>();
        
        String sql = "select * from pessoas_fatecs where obs like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + pesfatEnt.getObs()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            PessoasFatecs pesfat = new PessoasFatecs(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4));
            // adiciona o usu à lista de usus
            pesfats.add(pesfat);
        }
        
        rs.close();
        stmt.close();
        return pesfats;
   
   }

    
}
