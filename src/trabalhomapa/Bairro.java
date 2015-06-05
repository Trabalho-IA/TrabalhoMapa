package trabalhomapa;

import java.util.List;


public class Bairro {
    
    protected String nome;
    protected int heuristica;
    protected Bairro pai = null;
    protected List<BairrosVizinhos> vizinhos;

    public Bairro(String nome, int heuristica, List<BairrosVizinhos> vizinhos) {
         this.nome = nome;
         this.heuristica = heuristica;
         this.vizinhos = vizinhos;
    }
    
    public void insereVizinhos(Bairro bairro2, int dist){    
        BairrosVizinhos viz1, viz2;
        viz1 = new BairrosVizinhos(bairro2, dist);
        viz2 = new BairrosVizinhos(this, dist);
        this.vizinhos.add(viz1);
        bairro2.vizinhos.add(viz2);
    }

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
