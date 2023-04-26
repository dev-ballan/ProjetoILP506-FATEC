package backenddm20231n.model.bean;

/**
 *
 * @author ballan
 */
public class DiretoresDepartamentos {
    
    private int id;
    private int idDir;
    private int idDep;
    private String obs;
    private Diretor Diretor;
    private Departamento Departamento;

    public DiretoresDepartamentos(int id) {
        this.id = id;
    }

    public DiretoresDepartamentos(String obs) {
        this.obs = obs;
    }

    public DiretoresDepartamentos(int idDir, int idDep, String obs) {
        this.idDir = idDir;
        this.idDep = idDep;
        this.obs = obs;
    }

    public DiretoresDepartamentos(int id, int idDir, int idDep, String obs) {
        this.id = id;
        this.idDir = idDir;
        this.idDep = idDep;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDir() {
        return idDir;
    }

    public void setidDir(int idDir) {
        this.idDir = idDir;
    }

    public int getIdDep() {
        return idDep;
    }

    public void setidDep(int idDep) {
        this.idDep = idDep;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Diretor getDiretor() {
        return Diretor;
    }

    public void setDiretor(Diretor Diretor) {
        this.Diretor = Diretor;
    }

    public Departamento getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(Departamento Departamento) {
        this.Departamento = Departamento;
    }

    @Override
    public String toString() {
        return "DiretoresDepartamentos{" + "id=" + id + ", idDir=" + idDir + ", idDep=" + idDep + ", obs=" + obs + '}';
    }
    
}