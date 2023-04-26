/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.view;

import backenddm20231n.controller.ControllerFatec;
import backenddm20231n.model.bean.Fatec;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class ManterFatecs {
    
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
        Fatec fatEnt = new Fatec(cod,obs);
        ControllerFatec contFatec = new ControllerFatec();
        Fatec fatSaida = contFatec.inserir(fatEnt);
        JOptionPane.showMessageDialog(null,fatSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String cod = JOptionPane.showInputDialog("COD");
        String obs = JOptionPane.showInputDialog("OBS");
        Fatec fatEnt = new Fatec(id,cod,obs);
        ControllerFatec contFatec = new ControllerFatec();
        Fatec fatSaida = contFatec.alterar(fatEnt);
        JOptionPane.showMessageDialog(null,fatSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Fatec fatEnt = new Fatec(id);
        ControllerFatec contFatec = new ControllerFatec();
        Fatec fatSaida = contFatec.buscar(fatEnt);
        JOptionPane.showMessageDialog(null,fatSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Fatec fatEnt = new Fatec(id);
        ControllerFatec contFatec = new ControllerFatec();
        Fatec fatSaida = contFatec.excluir(fatEnt);
        JOptionPane.showMessageDialog(null,fatSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String cod = JOptionPane.showInputDialog("COD");
        Fatec fatEnt = new Fatec(cod);
        ControllerFatec contFatec = new ControllerFatec();
        List<Fatec> listaFatecs = contFatec.listar(fatEnt);
        for (Fatec fatSaida : listaFatecs) {
            JOptionPane.showMessageDialog(null,fatSaida.toString());
        }
    }


}
