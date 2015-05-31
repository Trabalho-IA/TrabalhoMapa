package trabalhomapa;

import java.util.List;


public class Bairro {
    
    protected String nome;
    protected List<BairrosVizinhos> vizinhos;

    public Bairro(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<BairrosVizinhos> getVizinhos() {
        return vizinhos;
    }

    public void setVizinhos(List<BairrosVizinhos> vizinhos) {
        this.vizinhos = vizinhos;
    }
    
}
