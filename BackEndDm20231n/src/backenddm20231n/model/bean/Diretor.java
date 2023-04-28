package backenddm20231n.model.bean;

/**
 *
 * @author ballan
 */
public class Diretor {

    private int Id;
    private String nome;
    private String setor;
    private String obs;

    public Diretor(int id) {
        this.Id = id;
    }
    
    public Diretor(String setor) {
        this.setor = setor;
    }
    
    public Diretor(String nome, String setor, String obs) {
        this.nome = nome;
        this.setor = setor;
        this.obs = obs;
    }

    public Diretor(int Id, String nome, String setor, String obs) {
        this.Id = Id;
        this.nome = nome;
        this.setor = setor;
        this.obs = obs;
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

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return "Diretor {" + "Id = " + Id + ", nome = " + nome + ", setor = " + setor + ", obs = " + obs + '}';
    }

}
