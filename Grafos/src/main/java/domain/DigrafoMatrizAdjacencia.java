package domain;

import util.GrafoUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DigrafoMatrizAdjacencia implements Grafo {

    private List<String> vertices = new ArrayList<>();
    private int[][] matriz;

    public DigrafoMatrizAdjacencia(int capacidadeInicial) {
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
            for (int j = 0; j < vertices.size(); j++) {
                total += matriz[i][j];
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
        matriz[i][j] = 1; // dirigido, não preenche simétrico
    }

    @Override
    public void imprimir() {
        System.out.println("\n=== Dígrafo - Matriz de Adjacência ===");

        // usa método utilitário para ordenar corretamente
        List<String> ordenados = GrafoUtils.ordenarVertices(vertices);

        // cabeçalho
        System.out.print("   ");
        for (String v : ordenados) {
            System.out.print(v + " ");
        }
        System.out.println();

        // linhas
        for (String vi : ordenados) {
            int i = vertices.indexOf(vi); // índice real na matriz
            System.out.print(vi + " ");
            for (String vj : ordenados) {
                int j = vertices.indexOf(vj); // índice real na matriz
                System.out.print(" " + matriz[i][j]);
            }
            System.out.println();
        }
    }
}
