package trabalhomapa;

import java.util.ArrayList;
import java.util.List;


public class TrabalhoMapa {
    
    List<Bairro> all = new ArrayList<>();

    public static void main(String[] args) {
        Busca cam = new Busca();
        Bairro testPai = insereBairro("pai", 9);
        Bairro testFilho1 = insereBairro("filho1", 99);
        Bairro testFilho2 = insereBairro("filho2", 9);
        Bairro testneto2 = insereBairro("neto2", 9);
        Bairro testneto1 = insereBairro("neto1", 9);
        Bairro testbisneto1 = insereBairro("bisneto1", 9);
        testPai.insereVizinhos(testFilho1, 3);
        testPai.insereVizinhos(testFilho2, 5);
        testFilho1.insereVizinhos(testneto1, 99);
        testFilho2.insereVizinhos(testneto2, 5);
        testneto2.insereVizinhos(testbisneto1, 5);
        testFilho2.insereVizinhos(testneto1, 5);
        ArrayList <String> caminho = cam.buscaGulosa(testPai, testneto1);
        for (int i = 0; i < caminho.size(); i++) {
            System.out.print(caminho.get(i) + " -> ");
        }
    }
    
    
    static public Bairro insereBairro(String nome, int heuristica){
        List<BairrosVizinhos> send = new ArrayList<>();
        return new Bairro(nome, heuristica, send);
    }
    
    
    
}
