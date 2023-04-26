/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.model.dao;

import backenddm20231n.model.bean.PessoasDisciplinas;
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
public class DaoPessoasDisciplinas {

private final Connection c;
    
    public DaoPessoasDisciplinas() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public PessoasDisciplinas excluir(PessoasDisciplinas pesdisEnt) throws SQLException{
        String sql = "delete from pessoas_disciplinas WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,pesdisEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return pesdisEnt;
    }
    
    public PessoasDisciplinas buscar(PessoasDisciplinas pesdisEnt) throws SQLException{
        String sql = "select * from pessoas_disciplinas WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,pesdisEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            PessoasDisciplinas pesfatSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                pesfatSaida = new PessoasDisciplinas(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return pesfatSaida;
   }

    public PessoasDisciplinas inserir(PessoasDisciplinas pesdisEnt) throws SQLException{
        String sql = "insert into pessoas_disciplinas" + " (idP, idD, obs)" + " values (?,?,?)";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,pesdisEnt.getIdP());
        stmt.setInt(2,pesdisEnt.getIdD());
        stmt.setString(3,pesdisEnt.getObs());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            pesdisEnt.setId(id);
        }
        stmt.close();
        return pesdisEnt;
    }

    public PessoasDisciplinas alterar(PessoasDisciplinas pesdisEnt) throws SQLException{
        String sql = "UPDATE pessoas_disciplinas SET idP = ?, idD = ?, obs = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,pesdisEnt.getIdP());
        stmt.setInt(2,pesdisEnt.getIdD());
        stmt.setString(3,pesdisEnt.getObs());
        stmt.setInt(4,pesdisEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return pesdisEnt;
    }

   public List<PessoasDisciplinas> listar(PessoasDisciplinas pesdisEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<PessoasDisciplinas> pesdiss = new ArrayList<>();
        
        String sql = "select * from pessoas_disciplinas where obs like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + pesdisEnt.getObs()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            PessoasDisciplinas pesdis = new PessoasDisciplinas(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4));
            // adiciona o usu à lista de usus
            pesdiss.add(pesdis);
        }
        
        rs.close();
        stmt.close();
        return pesdiss;
   
   }

    
}
