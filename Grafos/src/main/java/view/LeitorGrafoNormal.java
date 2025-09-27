package view;

import domain.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorGrafoNormal {
    public static Grafo lerGrafo(String caminhoArquivo, String tipoRepresentacao) {
        Grafo grafo;

        switch (tipoRepresentacao.toLowerCase()) {
            case "lista" -> grafo = new GrafoListaAdjacencia();
            case "matriz-adj" -> grafo = new GrafoMatrizAdjacencia(100);
            case "matriz-inc" -> grafo = new GrafoMatrizIncidencia();
            case "digrafo-matriz-adj" -> grafo = new DigrafoMatrizAdjacencia(100);
            case "digrafo-matriz-inc" -> grafo = new DigrafoMatrizIncidencia();
            default -> throw new IllegalArgumentException("Tipo de representação desconhecido: " + tipoRepresentacao);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha = br.readLine(); // primeira linha = número de vértices
            int numVertices = Integer.parseInt(linha.trim());
            // usamos apenas como informação, pois os vértices vêm das arestas

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (linha.isEmpty()) continue;

                String[] partes = linha.split(",");
                String v1 = partes[0].trim();
                String v2 = partes[1].trim();

                grafo.adicionarAresta(v1, v2);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return grafo;
    }
}
