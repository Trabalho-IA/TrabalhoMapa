package trabalhomapa;

public class BairrosVizinhos {
    
    protected Bairro bairro;
    protected int distancia;
    protected int heuristica;

    public BairrosVizinhos(Bairro bairro, int distancia, int heuristica) {
        this.bairro = bairro;
        this.distancia = distancia;
        this.heuristica = heuristica;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getHeuristica() {
        return heuristica;
    }

    public void setHeuristica(int heuristica) {
        this.heuristica = heuristica;
    }
}
