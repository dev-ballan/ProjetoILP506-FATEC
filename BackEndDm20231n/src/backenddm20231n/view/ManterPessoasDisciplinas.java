/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.view;

import backenddm20231n.controller.ControllerPessoasDisciplinas;
import backenddm20231n.model.bean.PessoasDisciplinas;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterPessoasDisciplinas {
    
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
        int idD = Integer.parseInt(JOptionPane.showInputDialog("IDD"));
        String obs = JOptionPane.showInputDialog("OBS");
        PessoasDisciplinas pdEnt = new PessoasDisciplinas(idP,idD,obs);
        ControllerPessoasDisciplinas contPd = new ControllerPessoasDisciplinas();
        PessoasDisciplinas pdSaida = contPd.inserir(pdEnt);
        JOptionPane.showMessageDialog(null,pdSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idP = Integer.parseInt(JOptionPane.showInputDialog("IDP"));
        int idD = Integer.parseInt(JOptionPane.showInputDialog("IDD"));
        String obs = JOptionPane.showInputDialog("OBS");
        PessoasDisciplinas pdEnt = new PessoasDisciplinas(idP,idD,obs);
        ControllerPessoasDisciplinas contPd = new ControllerPessoasDisciplinas();
        PessoasDisciplinas pdSaida = contPd.alterar(pdEnt);
        JOptionPane.showMessageDialog(null,pdSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PessoasDisciplinas pdEnt = new PessoasDisciplinas(id);
        ControllerPessoasDisciplinas contPd = new ControllerPessoasDisciplinas();
        PessoasDisciplinas pdSaida = contPd.buscar(pdEnt);
        JOptionPane.showMessageDialog(null,pdSaida.toString());
        JOptionPane.showMessageDialog(null,pdSaida.getPessoa().toString());
        JOptionPane.showMessageDialog(null,pdSaida.getDisciplina().toString());

    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PessoasDisciplinas pdEnt = new PessoasDisciplinas(id);
        ControllerPessoasDisciplinas contPd = new ControllerPessoasDisciplinas();
        PessoasDisciplinas pdSaida = contPd.excluir(pdEnt);
        JOptionPane.showMessageDialog(null,pdSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String obs = JOptionPane.showInputDialog("OBS");
        PessoasDisciplinas pdEnt = new PessoasDisciplinas(obs);
        ControllerPessoasDisciplinas contPd = new ControllerPessoasDisciplinas();
        List<PessoasDisciplinas> listaPessoasDis = contPd.listar(pdEnt);
        for (PessoasDisciplinas pdSaida : listaPessoasDis) {
            JOptionPane.showMessageDialog(null,pdSaida.toString());
            JOptionPane.showMessageDialog(null,pdSaida.getPessoa().toString());
            JOptionPane.showMessageDialog(null,pdSaida.getDisciplina().toString());
        }
    }


}
