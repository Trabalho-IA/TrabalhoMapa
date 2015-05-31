package trabalhomapa;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class Busca {
    
    
    List<String> buscaLargura(Bairro origin, Bairro dest){
        LinkedList<String> caminho = new LinkedList<>();
        PriorityBlockingQueue<Bairro> frontier = new PriorityBlockingQueue<>();
        LinkedList<Bairro> explored = new LinkedList<>();
        frontier.add(origin);
        caminho.add(origin.nome);
        Bairro daVez;
        while(!frontier.isEmpty()){
            daVez = frontier.poll();
            explored.add(daVez);
            for (BairrosVizinhos vizinho : daVez.vizinhos) {
                if (!frontier.contains(vizinho.getBairro()) && !explored.contains(vizinho.getBairro())) {
                    if (vizinho.getBairro().nome.equals(dest.nome)) {
                        String cam = vizinho.getBairro().nome;
                        caminho.add(cam);
                        while(!cam.equals(origin.nome)){
                            cam = daVez.getPai().nome;
                            caminho.add(cam);
                        }
                        caminho.add(cam);
                        return caminho;
                    }
                    frontier.add(vizinho.getBairro());
                    vizinho.getBairro().setPai(daVez);    
                }
            }
        }
        return null;
    }
    
    List<String> buscaAEstrela(Bairro origin, Bairro dest){
        List<String> caminho = null;
        List<BairrosVizinhos> frontier = new LinkedList<>();
        List<BairrosVizinhos> explored = new LinkedList<>();
        BairrosVizinhos daVez;
        //Faz esse loop pela primeira fez para o frontier só receber BairroVizinho, que é quem contém as
        //informações de distância e heuristica
        for (BairrosVizinhos vizinho : origin.vizinhos) {
            vizinho.bairro.pai = origin;
            insAEst(frontier, vizinho); 
        }
        while(!frontier.isEmpty()){
            daVez = frontier.get(0);
            frontier.remove(0);
            //Se daVez e dest tiverem o mesmo nome percorre a árvore até chegar em origin através de pai
            if(daVez.bairro.nome.equals(dest.nome)){
                Bairro pai = daVez.bairro;
                caminho.add(daVez.bairro.nome);
                while(!pai.nome.equals(dest.nome)){
                    caminho.add(pai.nome);
                    pai = pai.getPai();
                }
                caminho.add(pai.nome);
                return caminho;
            }
            explored.add(daVez);
            int j;
            for (BairrosVizinhos vizinho : daVez.bairro.vizinhos) {
                j = buscaAEst(frontier, vizinho);
                if (j == -1 && buscaAEst(explored, vizinho) == -1) {
                    insAEst(frontier,vizinho);
                } else if (j > 0) {
                    if ((vizinho.distancia + vizinho.heuristica) < (frontier.get(j).distancia + frontier.get(j).heuristica)) {
                        frontier.set(j, daVez);
                    }
                }
            }
        }
        return null;
    }
    
    int buscaAEst(List<BairrosVizinhos> lista, BairrosVizinhos este){
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).bairro.equals(este.bairro)) return i;
        }
        return -1;
    }
    
    void insAEst(List<BairrosVizinhos> lista, BairrosVizinhos est){
        for (int i = 0; i < lista.size(); i++) {
            if((lista.get(i).distancia + lista.get(i).heuristica) < est.distancia+est.heuristica){
                lista.add(i, est);
            }
        }
    }
    
    List<String> buscaGenetica(Bairro origin, Bairro dest){
        return null;
    }
    
}
