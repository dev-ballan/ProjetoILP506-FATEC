/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.view;

import backenddm20231n.controller.ControllerPessoasFatecs;
import backenddm20231n.model.bean.PessoasFatecs;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterPessoasFatecs {
    
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
        int idF = Integer.parseInt(JOptionPane.showInputDialog("IDF"));
        String obs = JOptionPane.showInputDialog("OBS");
        PessoasFatecs pfEnt = new PessoasFatecs(idP,idF,obs);
        ControllerPessoasFatecs contPF = new ControllerPessoasFatecs();
        PessoasFatecs pfSaida = contPF.inserir(pfEnt);
        JOptionPane.showMessageDialog(null,pfSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idP = Integer.parseInt(JOptionPane.showInputDialog("IDP"));
        int idF = Integer.parseInt(JOptionPane.showInputDialog("IDF"));
        String obs = JOptionPane.showInputDialog("OBS");
        PessoasFatecs pfEnt = new PessoasFatecs(id,idP,idF,obs);
        ControllerPessoasFatecs contPF = new ControllerPessoasFatecs();
        PessoasFatecs pfSaida = contPF.alterar(pfEnt);
        JOptionPane.showMessageDialog(null,pfSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PessoasFatecs pfEnt = new PessoasFatecs(id);
        ControllerPessoasFatecs contPF = new ControllerPessoasFatecs();
        PessoasFatecs pfSaida = contPF.buscar(pfEnt);
        JOptionPane.showMessageDialog(null,pfSaida.toString());
        JOptionPane.showMessageDialog(null,pfSaida.getPessoa().toString());
        JOptionPane.showMessageDialog(null,pfSaida.getFatec().toString());

    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PessoasFatecs pfEnt = new PessoasFatecs(id);
        ControllerPessoasFatecs contPF = new ControllerPessoasFatecs();
        PessoasFatecs pfSaida = contPF.excluir(pfEnt);
        JOptionPane.showMessageDialog(null,pfSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String obs = JOptionPane.showInputDialog("OBS");
        PessoasFatecs pfEnt = new PessoasFatecs(obs);
        ControllerPessoasFatecs contPF = new ControllerPessoasFatecs();
        List<PessoasFatecs> listaPessoasLogradouros = contPF.listar(pfEnt);
        for (PessoasFatecs pfSaida : listaPessoasLogradouros) {
            JOptionPane.showMessageDialog(null,pfSaida.toString());
            JOptionPane.showMessageDialog(null,pfSaida.getPessoa().toString());
            JOptionPane.showMessageDialog(null,pfSaida.getFatec().toString());
        }
    }


}
