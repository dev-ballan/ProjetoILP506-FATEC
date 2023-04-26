package backenddm20231n.view;

import backenddm20231n.controller.ControllerDiretoresDepartamentos;
import backenddm20231n.model.bean.DiretoresDepartamentos;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ballan
 */
public class ManterDiretoresDepartamentos {
    
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
        int idDir = Integer.parseInt(JOptionPane.showInputDialog("IDDIR"));
        int idDep = Integer.parseInt(JOptionPane.showInputDialog("IDDEP"));
        String obs = JOptionPane.showInputDialog("OBS");
        DiretoresDepartamentos ddEnt = new DiretoresDepartamentos(idDir,idDep,obs);
        ControllerDiretoresDepartamentos contDD = new ControllerDiretoresDepartamentos();
        DiretoresDepartamentos ddSaida = contDD.inserir(ddEnt);
        JOptionPane.showMessageDialog(null,ddSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idDir = Integer.parseInt(JOptionPane.showInputDialog("IDDIR"));
        int idDep = Integer.parseInt(JOptionPane.showInputDialog("IDDEP"));
        String obs = JOptionPane.showInputDialog("OBS");
        DiretoresDepartamentos ddEnt = new DiretoresDepartamentos(id,idDir,idDep,obs);
        ControllerDiretoresDepartamentos contDD = new ControllerDiretoresDepartamentos();
        DiretoresDepartamentos ddSaida = contDD.alterar(ddEnt);
        JOptionPane.showMessageDialog(null,ddSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        DiretoresDepartamentos ddEnt = new DiretoresDepartamentos(id);
        ControllerDiretoresDepartamentos contDD = new ControllerDiretoresDepartamentos();
        DiretoresDepartamentos ddSaida = contDD.buscar(ddEnt);
        JOptionPane.showMessageDialog(null,ddSaida.toString());
        JOptionPane.showMessageDialog(null,ddSaida.getDiretor().toString());
        JOptionPane.showMessageDialog(null,ddSaida.getDepartamento().toString());

    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        DiretoresDepartamentos ddEnt = new DiretoresDepartamentos(id);
        ControllerDiretoresDepartamentos contDD = new ControllerDiretoresDepartamentos();
        DiretoresDepartamentos ddSaida = contDD.excluir(ddEnt);
        JOptionPane.showMessageDialog(null,ddSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String obs = JOptionPane.showInputDialog("OBS");
        DiretoresDepartamentos ddEnt = new DiretoresDepartamentos(obs);
        ControllerDiretoresDepartamentos contDD = new ControllerDiretoresDepartamentos();
        List<DiretoresDepartamentos> listaDiretoresDepartamentos = contDD.listar(ddEnt);
        for (DiretoresDepartamentos ddSaida : listaDiretoresDepartamentos) {
            JOptionPane.showMessageDialog(null,ddSaida.toString());
            JOptionPane.showMessageDialog(null,ddSaida.getDiretor().toString());
            JOptionPane.showMessageDialog(null,ddSaida.getDepartamento().toString());
        }
    }


}