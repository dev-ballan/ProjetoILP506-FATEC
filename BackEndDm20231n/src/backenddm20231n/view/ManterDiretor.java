package backenddm20231n.view;

import backenddm20231n.controller.ControllerDiretor;
import backenddm20231n.model.bean.Diretor;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterDiretor {

    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - Buscar \n 4 - Excluir \n 5 - Listar " ;
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
        String nome = JOptionPane.showInputDialog("NOME");
        String setor = JOptionPane.showInputDialog("SETOR");
        String obs = JOptionPane.showInputDialog("OBS");
        Diretor dirEnt = new Diretor(nome,setor,obs);
        ControllerDiretor contDir = new ControllerDiretor();
        Diretor dirSaida = contDir.inserir(dirEnt);
        JOptionPane.showMessageDialog(null,dirSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("NOME");
        String setor = JOptionPane.showInputDialog("SETOR");
        String obs = JOptionPane.showInputDialog("OBS");
        Diretor dirEnt = new Diretor(id,nome,setor,obs);
        ControllerDiretor contDir = new ControllerDiretor();
        Diretor dirSaida = contDir.alterar(dirEnt);
        JOptionPane.showMessageDialog(null,dirSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Diretor dirEnt = new Diretor(id);
        ControllerDiretor contDir = new ControllerDiretor();
        Diretor dirSaida = contDir.buscar(dirEnt);
        JOptionPane.showMessageDialog(null,dirSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Diretor dirEnt = new Diretor(id);
        ControllerDiretor contDir = new ControllerDiretor();
        Diretor dirSaida = contDir.excluir(dirEnt);
        JOptionPane.showMessageDialog(null,dirSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String setor = JOptionPane.showInputDialog("SETOR");
        Diretor dirEnt = new Diretor(setor);
        ControllerDiretor contDir = new ControllerDiretor();
        List<Diretor> listaDiretores = contDir.listar(dirEnt);
        for (Diretor dirSaida : listaDiretores) {
            JOptionPane.showMessageDialog(null,dirSaida.toString());
        }
    }


    
}
