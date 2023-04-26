package backenddm20231n;

import backenddm20231n.view.ManterDepartamento;
import backenddm20231n.view.ManterDiretor;
import backenddm20231n.view.ManterDisciplina;
import backenddm20231n.view.ManterFatecs;
import backenddm20231n.view.ManterLogradouro;
import backenddm20231n.view.ManterPessoa;
import backenddm20231n.view.ManterPessoasDisciplinas;
import backenddm20231n.view.ManterPessoasFatecs;
import backenddm20231n.view.ManterPessoasLogradouros;
import backenddm20231n.view.ManterUsuario;
import backenddm20231n.view.ManterUsuariosPessoas;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ballan
 */
public class BackEndDm20231n {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if(ManterUsuario.validar()) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null,"Usuario Inválido");            
        }
    }

    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 0 - Sair \n 1 - Usuario \n 2 - Pessoa \n 3 - Logradouro "
                + "\n 4 - PessoasLogradouros \n 5 - UsuariosPessoas \n 6 - Fatecs "
                + "\n 7 - PessoasFatecs \n 8 - Disciplina \n 9 - PessoasDisciplina "
                + "\n 10 - Diretores \n 11 - Departamentos";
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 0:
                int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair");
                if (sair > 0) menu();
                break;
            case 1:
                ManterUsuario.menu();
                break;
            case 2:
                ManterPessoa.menu();
                break;
            case 3:
                ManterLogradouro.menu();
                break;
            case 4:
                ManterPessoasLogradouros.menu();
                break;
            case 5:
                ManterUsuariosPessoas.menu();
                break;
            case 6:
                ManterFatecs.menu();
                break;
            case 7:
                ManterPessoasFatecs.menu();
                break;
            case 8:
                ManterDisciplina.menu();
                break;
            case 9:
                ManterPessoasDisciplinas.menu();
                break;
            case 10:
                ManterDiretor.menu();
                break;
            case 11:
                ManterDepartamento.menu();
                break;
            default:
                System.out.println("Opção inválido");
        }
    }
    
}