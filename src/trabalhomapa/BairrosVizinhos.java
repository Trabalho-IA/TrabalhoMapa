package trabalhomapa;

public class BairrosVizinhos {
    
    protected Bairro bairro;
    protected int distancia;

    public BairrosVizinhos(Bairro bairro, int distancia) {
        this.bairro = bairro;
        this.distancia = distancia;
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
}
