package domain;

import java.util.List;

public interface Grafo {
    int numeroDeVertices();
    int numeroDeArestas();
    List<String> vizinhos(String v);
    boolean saoAdjacentes(String v1, String v2);
    void adicionarVertice(String v);
    void removerVertice(String v);
    void adicionarAresta(String v1, String v2);
    void imprimir();
    List<String> getVertices();
}
