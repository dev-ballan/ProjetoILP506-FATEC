/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.model.dao;

import backenddm20231n.model.bean.PessoasLogradouros;
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
public class DaoPessoasLogradouros {

private final Connection c;
    
    public DaoPessoasLogradouros() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public PessoasLogradouros excluir(PessoasLogradouros peslogEnt) throws SQLException{
        String sql = "delete from pessoas_logradouros WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,peslogEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return peslogEnt;
    }
    
    public PessoasLogradouros buscar(PessoasLogradouros peslogEnt) throws SQLException{
        String sql = "select * from pessoas_logradouros WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,peslogEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            PessoasLogradouros peslogSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                peslogSaida = new PessoasLogradouros(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return peslogSaida;
   }

    public PessoasLogradouros inserir(PessoasLogradouros peslogEnt) throws SQLException{
        String sql = "insert into pessoas_logradouros" + " (idP, idL, obs)" + " values (?,?,?)";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,peslogEnt.getIdP());
        stmt.setInt(2,peslogEnt.getIdL());
        stmt.setString(3,peslogEnt.getObs());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            peslogEnt.setId(id);
        }
        stmt.close();
        return peslogEnt;
    }

    public PessoasLogradouros alterar(PessoasLogradouros peslogEnt) throws SQLException{
        String sql = "UPDATE pessoas_logradouros SET idP = ?, idL = ?, obs = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,peslogEnt.getIdP());
        stmt.setInt(2,peslogEnt.getIdL());
        stmt.setString(3,peslogEnt.getObs());
        stmt.setInt(4,peslogEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return peslogEnt;
    }

   public List<PessoasLogradouros> listar(PessoasLogradouros peslogEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<PessoasLogradouros> peslogs = new ArrayList<>();
        
        String sql = "select * from pessoas_logradouros where obs like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + peslogEnt.getObs()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            PessoasLogradouros peslog = new PessoasLogradouros(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4));
            // adiciona o usu à lista de usus
            peslogs.add(peslog);
        }
        
        rs.close();
        stmt.close();
        return peslogs;
   
   }

    
}
