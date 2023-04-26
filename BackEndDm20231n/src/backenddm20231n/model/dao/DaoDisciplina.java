/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.model.dao;

import backenddm20231n.model.bean.Disciplina;
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
public class DaoDisciplina {

private final Connection c;
    
    public DaoDisciplina() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Disciplina excluir(Disciplina disEnt) throws SQLException{
        String sql = "delete from disciplinas WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,disEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return disEnt;
    }
    
    public Disciplina buscar(Disciplina disEnt) throws SQLException{
        String sql = "select * from disciplinas WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,disEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Disciplina disSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                disSaida = new Disciplina(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return disSaida;
   }

    public Disciplina inserir(Disciplina distEnt) throws SQLException{
        String sql = "insert into disciplinas" + " (cod, obs)" + " values (?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,distEnt.getCod());
        stmt.setString(2,distEnt.getObs());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            distEnt.setId(id);
        }
        stmt.close();
        return distEnt;
    }

    public Disciplina alterar(Disciplina disEnt) throws SQLException{
        String sql = "UPDATE disciplinas SET cod = ?, obs = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,disEnt.getCod());
        stmt.setString(2,disEnt.getObs());
        stmt.setInt(3,disEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return disEnt;
    }

   public List<Disciplina> listar(Disciplina disEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Disciplina> diss = new ArrayList<>();
        
        String sql = "select * from disciplinas where cod like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + disEnt.getCod() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Disciplina dis = new Disciplina(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3));
            // adiciona o usu à lista de usus
            diss.add(dis);
        }
        
        rs.close();
        stmt.close();
        return diss;
   
   }

    
}
