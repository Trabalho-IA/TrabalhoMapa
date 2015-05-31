package trabalhomapa;

import java.util.List;
import java.util.Queue;

public class Busca {
  
    List<String> buscaLargura(Bairro origin, Bairro dest){
        List<String> caminho = null;
        Queue<Bairro> frontier = null;
        List<Bairro> explored = null;
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
                        while(cam.equals(origin.nome)){
                            cam = daVez.getPai().nome;
                            caminho.add(cam);
                        }
                    }
                    frontier.add(vizinho.getBairro());
                    vizinho.getBairro().setPai(daVez);    
                }
            }
        }
        return null;
    }
    
    List<String> buscaAEstrela(Bairro origin, Bairro dest){
        return null;
    }
    
    List<String> buscaGenetica(Bairro origin, Bairro dest){
        return null;
    }
    
}
