package backenddm20231n.model.bean;

/**
 *
 * @author ballan
 */
public class Departamento {

    private int Id;
    private String nome;
    private String cod;
    private String descricao;

    public Departamento(int id) {
        this.Id = id;
    }
    
    public Departamento(String nome) {
        this.nome = nome;
    }
    
    public Departamento(String nome, String cod, String descricao) {
        this.nome = nome;
        this.cod = cod;
        this.descricao = descricao;
    }

    public Departamento(int Id, String nome, String cod, String descricao) {
        this.Id = Id;
        this.nome = nome;
        this.cod = cod;
        this.descricao = descricao;
    }


    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getcod() {
        return cod;
    }

    public void setcod(String cod) {
        this.cod = cod;
    }

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Departamento {" + "Id = " + Id + ", nome = " + nome + ", código = " + cod + ", descrição = " + descricao + '}';
    }

}