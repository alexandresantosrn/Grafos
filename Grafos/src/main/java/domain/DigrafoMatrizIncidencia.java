package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static util.GrafoUtils.ordenarVertices;

public class DigrafoMatrizIncidencia implements Grafo{

    private List<String> vertices = new ArrayList<>();
    private List<String[]> arestas = new ArrayList<>();

    private int indice(String v) {
        return vertices.indexOf(v);
    }

    @Override
    public int numeroDeVertices() {
        return vertices.size();
    }

    @Override
    public int numeroDeArestas() {
        return arestas.size();
    }

    @Override
    public List<String> vizinhos(String v) {
        List<String> vizinhos = new ArrayList<>();
        for (String[] aresta : arestas) {
            if (aresta[0].equals(v)) {
                vizinhos.add(aresta[1]); // só destino
            }
        }
        return vizinhos;
    }

    @Override
    public boolean saoAdjacentes(String v1, String v2) {
        for (String[] aresta : arestas) {
            if (aresta[0].equals(v1) && aresta[1].equals(v2)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void adicionarVertice(String v) {
        if (!vertices.contains(v)) {
            vertices.add(v);
        }
    }

    @Override
    public void removerVertice(String v) {
        vertices.remove(v);
        arestas.removeIf(aresta -> aresta[0].equals(v) || aresta[1].equals(v));
    }

    @Override
    public void adicionarAresta(String v1, String v2) {
        adicionarVertice(v1);
        adicionarVertice(v2);
        arestas.add(new String[]{v1, v2});
    }

    @Override
    public void imprimir() {
        System.out.println("\n=== Dígrafo - Matriz de Incidência ===");
        List<String> ordenados = ordenarVertices(vertices);

        int n = ordenados.size();
        int m = arestas.size();
        int[][] matriz = new int[n][m];

        for (int j = 0; j < m; j++) {
            String[] aresta = arestas.get(j);
            int i1 = ordenados.indexOf(aresta[0]); // origem
            int i2 = ordenados.indexOf(aresta[1]); // destino
            matriz[i1][j] = -1; // origem
            matriz[i2][j] = 1;  // destino
        }

        // cabeçalho
        System.out.print("   ");
        for (int j = 0; j < m; j++) {
            System.out.print("e" + (j + 1) + " ");
        }
        System.out.println();

        // linhas
        for (int i = 0; i < n; i++) {
            System.out.print(ordenados.get(i) + " ");
            for (int j = 0; j < m; j++) {
                System.out.printf("%2d ", matriz[i][j]);
            }
            System.out.println();
        }
    }
}
