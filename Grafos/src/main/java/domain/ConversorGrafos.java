package domain;

import util.GrafoUtils;

import java.util.List;

public class ConversorGrafos {

    // Matriz -> Lista
    public static GrafoListaAdjacencia matrizParaLista(GrafoMatrizAdjacencia matriz) {
        GrafoListaAdjacencia lista = new GrafoListaAdjacencia();
        List<String> vertices = GrafoUtils.ordenarVertices(matriz.getVertices());

        for (String v1 : vertices) {
            for (String v2 : vertices) {
                if (matriz.saoAdjacentes(v1, v2)) {
                    lista.adicionarAresta(v1, v2);
                }
            }
        }
        return lista;
    }

    // Lista -> Matriz
    public static GrafoMatrizAdjacencia listaParaMatriz(GrafoListaAdjacencia lista) {
        GrafoMatrizAdjacencia matriz = new GrafoMatrizAdjacencia(50);
        for (String v : lista.getVertices()) {
            for (String vizinho : lista.vizinhos(v)) {
                matriz.adicionarAresta(v, vizinho);
            }
        }
        return matriz;
    }
}
