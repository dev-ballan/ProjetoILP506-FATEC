/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.view;

import backenddm20231n.controller.ControllerPessoasLogradouros;
import backenddm20231n.model.bean.PessoasLogradouros;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterPessoasLogradouros {
    
    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar " ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                inserir();
                break;
            case 2:
                alterar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                excluir();
                break;
            case 5:
                listar();
                break;
            default:
                System.out.println("Opcao inválida");
        }
    }

    private static void inserir() throws SQLException, ClassNotFoundException {
        int idP = Integer.parseInt(JOptionPane.showInputDialog("IDP"));
        int idL = Integer.parseInt(JOptionPane.showInputDialog("IDL"));
        String obs = JOptionPane.showInputDialog("OBS");
        PessoasLogradouros plEnt = new PessoasLogradouros(idP,idL,obs);
        ControllerPessoasLogradouros contPL = new ControllerPessoasLogradouros();
        PessoasLogradouros plSaida = contPL.inserir(plEnt);
        JOptionPane.showMessageDialog(null,plSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idP = Integer.parseInt(JOptionPane.showInputDialog("IDP"));
        int idL = Integer.parseInt(JOptionPane.showInputDialog("IDL"));
        String obs = JOptionPane.showInputDialog("OBS");
        PessoasLogradouros plEnt = new PessoasLogradouros(id,idP,idL,obs);
        ControllerPessoasLogradouros contPL = new ControllerPessoasLogradouros();
        PessoasLogradouros plSaida = contPL.alterar(plEnt);
        JOptionPane.showMessageDialog(null,plSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PessoasLogradouros plEnt = new PessoasLogradouros(id);
        ControllerPessoasLogradouros contPL = new ControllerPessoasLogradouros();
        PessoasLogradouros plSaida = contPL.buscar(plEnt);
        JOptionPane.showMessageDialog(null,plSaida.toString());
        JOptionPane.showMessageDialog(null,plSaida.getP().toString());
        JOptionPane.showMessageDialog(null,plSaida.getL().toString());

    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PessoasLogradouros plEnt = new PessoasLogradouros(id);
        ControllerPessoasLogradouros contPL = new ControllerPessoasLogradouros();
        PessoasLogradouros plSaida = contPL.excluir(plEnt);
        JOptionPane.showMessageDialog(null,plSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String obs = JOptionPane.showInputDialog("OBS");
        PessoasLogradouros plEnt = new PessoasLogradouros(obs);
        ControllerPessoasLogradouros contPL = new ControllerPessoasLogradouros();
        List<PessoasLogradouros> listaPessoasLogradouros = contPL.listar(plEnt);
        for (PessoasLogradouros plSaida : listaPessoasLogradouros) {
            JOptionPane.showMessageDialog(null,plSaida.toString());
            JOptionPane.showMessageDialog(null,plSaida.getP().toString());
            JOptionPane.showMessageDialog(null,plSaida.getL().toString());
        }
    }


}
