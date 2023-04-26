/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.view;

import backenddm20231n.controller.ControllerLogradouro;
import backenddm20231n.model.bean.Logradouro;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class ManterLogradouro {
    
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
        String cep = JOptionPane.showInputDialog("CEP");
        String num = JOptionPane.showInputDialog("NUMERO");
        String compl = JOptionPane.showInputDialog("COMPLEMENTO");
        Logradouro logEnt = new Logradouro(cep,num,compl);
        ControllerLogradouro contLog = new ControllerLogradouro();
        Logradouro logSaida = contLog.inserir(logEnt);
        JOptionPane.showMessageDialog(null,logSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String cep = JOptionPane.showInputDialog("CEP");
        String num = JOptionPane.showInputDialog("NUMERO");
        String compl = JOptionPane.showInputDialog("COMPLEMENTO");
        Logradouro logEnt = new Logradouro(id,cep,num,compl);
        ControllerLogradouro contLog = new ControllerLogradouro();
        Logradouro logSaida = contLog.alterar(logEnt);
        JOptionPane.showMessageDialog(null,logSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Logradouro logEnt = new Logradouro(id);
        ControllerLogradouro contLog = new ControllerLogradouro();
        Logradouro logSaida = contLog.buscar(logEnt);
        JOptionPane.showMessageDialog(null,logSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Logradouro logEnt = new Logradouro(id);
        ControllerLogradouro contLog = new ControllerLogradouro();
        Logradouro logSaida = contLog.excluir(logEnt);
        JOptionPane.showMessageDialog(null,logSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String cep = JOptionPane.showInputDialog("CEP");
        Logradouro logEnt = new Logradouro(cep);
        ControllerLogradouro logUsu = new ControllerLogradouro();
        List<Logradouro> listalogs = logUsu.listar(logEnt);
        for (Logradouro logSaida : listalogs) {
            JOptionPane.showMessageDialog(null,logSaida.toString());
        }
    }


}
