package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrafoListaAdjacencia implements Grafo {

    private Map<String, List<String>> listaAdj = new HashMap<>();

    @Override
    public int numeroDeVertices() {
        return listaAdj.size();
    }

    @Override
    public int numeroDeArestas() {
        int total = 0;
        for (List<String> vizinhos : listaAdj.values()) {
            total += vizinhos.size();
        }
        return total / 2; // não direcionado, cada aresta aparece 2x
    }

    @Override
    public List<String> vizinhos(String v) {
        return listaAdj.getOrDefault(v, new ArrayList<>());
    }

    @Override
    public boolean saoAdjacentes(String v1, String v2) {
        return listaAdj.getOrDefault(v1, new ArrayList<>()).contains(v2);
    }

    @Override
    public void adicionarVertice(String v) {
        listaAdj.putIfAbsent(v, new ArrayList<>());
    }

    @Override
    public void removerVertice(String v) {
        listaAdj.remove(v);
        for (List<String> vizinhos : listaAdj.values()) {
            vizinhos.remove(v);
        }
    }

    @Override
    public void adicionarAresta(String v1, String v2) {
        adicionarVertice(v1);
        adicionarVertice(v2);
        listaAdj.get(v1).add(v2);
        listaAdj.get(v2).add(v1);
    }

    @Override
    public void imprimir() {
        System.out.println("\n=== Lista de Adjacência ===");
        for (String v : listaAdj.keySet()) {
            System.out.print(v + " -> ");
            for (String vizinho : listaAdj.get(v)) {
                System.out.print(vizinho + " ");
            }
            System.out.println();
        }
    }
}
