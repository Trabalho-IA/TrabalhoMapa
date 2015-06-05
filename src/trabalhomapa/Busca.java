package trabalhomapa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Busca {
    
    
    protected ArrayList<String> buscaLargura(Bairro origin, Bairro dest){
        ArrayList<String> caminho = new ArrayList<>();
        LinkedBlockingQueue<Bairro> frontier = new LinkedBlockingQueue<>();
        LinkedList<Bairro> explored = new LinkedList<>();
        frontier.add(origin);
        //caminho.add(origin.nome);
        Bairro daVez;
        while(!frontier.isEmpty()){
            daVez = frontier.poll();
            explored.add(daVez);
            for (BairrosVizinhos vizinho : daVez.vizinhos) {
                if (!frontier.contains(vizinho.getBairro()) && !explored.contains(vizinho.getBairro())) {
                    frontier.offer(vizinho.getBairro());
                    vizinho.getBairro().setPai(daVez);  
                    if (vizinho.getBairro().nome.equals(dest.nome)) {
                        String cam= "";
                        daVez = vizinho.getBairro();
                        while(!cam.equals(origin.nome)){
                            cam = daVez.nome;
                            caminho.add(cam);
                            daVez = daVez.getPai();
                        }
                        return caminho;
                    }  
                }
            }
        }
        return null;
    }
    
    protected ArrayList<String> buscaAEstrela(Bairro origin, Bairro dest){
        ArrayList<String> caminho = new ArrayList<>();
        ArrayList<BairrosVizinhos> frontier = new ArrayList<>();
        ArrayList<BairrosVizinhos> explored = new ArrayList<>();
        BairrosVizinhos daVez;
        //Faz esse loop pela primeira fez para o frontier só receber BairroVizinho, que é quem contém as
        //informações de distância e heuristica
        for (BairrosVizinhos vizinho : origin.vizinhos) {
            vizinho.bairro.pai = origin;
            frontier = insAEst(frontier, vizinho); 
        }
        while(!frontier.isEmpty()){
//            for (int i = 0; i < frontier.size(); i++) {
//                System.out.print(frontier.get(i).bairro.nome + " " + frontier.get(i).bairro.heuristica);
//            }
//            System.out.println("");

            daVez = frontier.get(0);
            frontier.remove(0);
            //Se daVez e dest tiverem o mesmo nome percorre a árvore até chegar em origin através de pai
            if(daVez.bairro.nome.equals(dest.nome)){
                Bairro pai = daVez.bairro;
                while(!pai.nome.equals(origin.nome)){
                    caminho.add(pai.nome);
                    pai = pai.getPai();
                }
                caminho.add(pai.nome);
                return caminho;
            }
            explored.add(daVez);
            int j, k;
            for (BairrosVizinhos vizinho : daVez.bairro.vizinhos) {
                j = buscaAEst(frontier, vizinho);
                k = buscaAEst(explored, vizinho);
                if (!vizinho.bairro.nome.equals(origin.nome) && j == -1 && k == -1) {
                    vizinho.bairro.pai = daVez.bairro;
                    frontier = insAEst(frontier,vizinho);
                } else if (j > 0) {
                    System.out.println("AAAAAAAA");
                    if ((vizinho.distancia + daVez.getBairro().heuristica) < (frontier.get(j).distancia + frontier.get(j).getBairro().heuristica)) {
                        vizinho.bairro.pai = daVez.bairro;
                        frontier.set(j, daVez);
                    }
                }
            }
        }
        return null;
    }
      
    protected ArrayList<String> buscaGulosa(Bairro origin, Bairro dest){
        ArrayList<String> caminho = new ArrayList<>();
        ArrayList<Bairro> frontier = new ArrayList<>();
        ArrayList<Bairro> explored = new ArrayList<>();
        Bairro daVez;
        frontier.add(origin);
        while(!frontier.isEmpty()){
            daVez = frontier.get(0);
            frontier.remove(0);
            if(daVez.nome.equals(dest.nome)){
                Bairro pai = daVez;
                while(!pai.nome.equals(origin.nome)){
                    caminho.add(pai.nome);
                    System.out.println(pai.nome);
                    pai = pai.getPai();
                }
                caminho.add(pai.nome);
                return caminho;
            }
            explored.add(daVez);
            for (BairrosVizinhos vizinho : daVez.vizinhos) {
                if (!explored.contains(vizinho.bairro) && !frontier.contains(vizinho.bairro)) {
                    vizinho.getBairro().pai = daVez;
                    frontier.add(vizinho.getBairro());
                } else if (buscaGul(frontier, vizinho) > 0) {
                    vizinho.getBairro().pai = daVez;
                    frontier.set(buscaGul(frontier, vizinho), daVez);
                }
            }
        }
        return null;
    }
    
    private int buscaGul(List<Bairro> lista, BairrosVizinhos este){
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).equals(este.bairro)) return i;
        }
        return -1;
    }
    
    private int buscaAEst(List<BairrosVizinhos> lista, BairrosVizinhos este){
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).bairro.equals(este.bairro)) return i;
        }
        return -1;
    }
    
    private ArrayList<BairrosVizinhos> insAEst(ArrayList<BairrosVizinhos> lista, BairrosVizinhos est){
        int pos = -1;
        for (int i = 0; i < lista.size(); i++) {
            if((lista.get(i).distancia + lista.get(i).getBairro().heuristica) > est.distancia + est.getBairro().heuristica){
                lista.add(i, est);
                return lista;
            }
        }
        lista.add(est);
        return lista;
    }
    
}
