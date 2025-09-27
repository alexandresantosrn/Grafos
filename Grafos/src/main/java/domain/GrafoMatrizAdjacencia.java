package domain;

import java.util.ArrayList;
import java.util.List;

public class GrafoMatrizAdjacencia implements Grafo{

    private List<String> vertices = new ArrayList<>();
    private int[][] matriz;

    public GrafoMatrizAdjacencia(int capacidadeInicial) {
        matriz = new int[capacidadeInicial][capacidadeInicial];
    }

    private int indice(String v) {
        return vertices.indexOf(v);
    }

    @Override
    public int numeroDeVertices() {
        return vertices.size();
    }

    @Override
    public int numeroDeArestas() {
        int total = 0;
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = i+1; j < vertices.size(); j++) {
                if (matriz[i][j] == 1) total++;
            }
        }
        return total;
    }

    @Override
    public List<String> vizinhos(String v) {
        List<String> vizinhos = new ArrayList<>();
        int idx = indice(v);
        if (idx == -1) return vizinhos;
        for (int j = 0; j < vertices.size(); j++) {
            if (matriz[idx][j] == 1) {
                vizinhos.add(vertices.get(j));
            }
        }
        return vizinhos;
    }

    @Override
    public boolean saoAdjacentes(String v1, String v2) {
        int i = indice(v1), j = indice(v2);
        return i != -1 && j != -1 && matriz[i][j] == 1;
    }

    @Override
    public void adicionarVertice(String v) {
        if (!vertices.contains(v)) {
            vertices.add(v);
        }
    }

    @Override
    public void removerVertice(String v) {
        // implementação simplificada: apenas remove da lista
        int idx = indice(v);
        if (idx != -1) {
            vertices.remove(v);
            for (int i = 0; i < vertices.size(); i++) {
                matriz[idx][i] = 0;
                matriz[i][idx] = 0;
            }
        }
    }

    @Override
    public void adicionarAresta(String v1, String v2) {
        adicionarVertice(v1);
        adicionarVertice(v2);
        int i = indice(v1), j = indice(v2);
        matriz[i][j] = 1;
        matriz[j][i] = 1; // não direcionado
    }

    @Override
    public void imprimir() {
        System.out.println("\n=== Matriz de Adjacência ===");
        System.out.print("   ");
        for (String v : vertices) {
            System.out.print(v + " ");
        }
        System.out.println();
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i) + " ");
            for (int j = 0; j < vertices.size(); j++) {
                System.out.print(" " + matriz[i][j]);
            }
            System.out.println();
        }
    }
}
