package trabalhomapa;

import java.util.List;


public class Bairro {
    
    protected String nome;
    protected Bairro pai = null;
    protected List<BairrosVizinhos> vizinhos;

    public Bairro(String nome) {
        this.nome = nome;
    }

    public Bairro getPai() {
        return pai;
    }

    public void setPai(Bairro pai) {
        this.pai = pai;
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
