/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.view;

import backenddm20231n.controller.ControllerDisciplina;
import backenddm20231n.model.bean.Disciplina;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class ManterDisciplina {
    
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
        String cod = JOptionPane.showInputDialog("COD");
        String obs = JOptionPane.showInputDialog("OBS");
        Disciplina disEnt = new Disciplina(cod,obs);
        ControllerDisciplina contDisciplina = new ControllerDisciplina();
        Disciplina disSaida = contDisciplina.inserir(disEnt);
        JOptionPane.showMessageDialog(null,disSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String cod = JOptionPane.showInputDialog("COD");
        String obs = JOptionPane.showInputDialog("OBS");
        Disciplina disEnt = new Disciplina(cod,obs);
        ControllerDisciplina contDisciplina = new ControllerDisciplina();
        Disciplina disSaida = contDisciplina.alterar(disEnt);
        JOptionPane.showMessageDialog(null,disSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Disciplina disEnt = new Disciplina(id);
        ControllerDisciplina contDisciplina = new ControllerDisciplina();
        Disciplina disSaida = contDisciplina.buscar(disEnt);
        JOptionPane.showMessageDialog(null,disSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Disciplina disEnt = new Disciplina(id);
        ControllerDisciplina contDisciplina = new ControllerDisciplina();
        Disciplina disSaida = contDisciplina.excluir(disEnt);
        JOptionPane.showMessageDialog(null,disSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String cod = JOptionPane.showInputDialog("COD");
        Disciplina disEnt = new Disciplina(cod);
        ControllerDisciplina contFatec = new ControllerDisciplina();
        List<Disciplina> listaDiss = contFatec.listar(disEnt);
        for (Disciplina disSaida : listaDiss) {
            JOptionPane.showMessageDialog(null,disSaida.toString());
        }
    }


}
