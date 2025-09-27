package view;

import domain.Grafo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MenuGrafos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        while (true) {
            mostrarMenuPrincipal();
            System.out.print("\nDigite sua opção: ");
            opcao = scanner.nextInt();

            if (opcao == 0) {
                System.out.println("Saindo... Obrigado!");
                break;
            }

            if (opcao >= 1 && opcao <= 15) {
                String arquivo = selecionarArquivo(false, scanner); // false = Grafo
                executarOpcao(opcao, arquivo, scanner);

            } else if (opcao >= 16 && opcao <= 20) {
                String arquivo = selecionarArquivo(true, scanner); // true = Dígrafo
                executarOpcao(opcao, arquivo, scanner);

            } else {
                System.out.println("Opção inválida! Digite um número entre 0 e 20.");
            }
        }

        scanner.close();
    }

    // ===================== MÉTODOS AUXILIARES =====================

    private static void mostrarMenuPrincipal() {
        System.out.println("\n=== MENU DE PERGUNTAS ===");
        System.out.println("Escolha a questão (1 a 20) ou 0 para sair:\n");

        System.out.println("(1) Criação do Grafo a partir da Lista de Adjacências");
        System.out.println("(2) Criação do Grafo a partir da Matriz de Adjacências");
        System.out.println("(3) Criação do Grafo a partir da Matriz de Incidência");
        System.out.println("(4) Conversão de matriz de adjacência para lista de Adjacências e vice-versa.");
        System.out.println("(5) Função que calcula o grau de cada vértice.");
        System.out.println("(6) Função que determina se dois vértices são adjacentes.");
        System.out.println("(7) Função que determina o número total de vértices.");
        System.out.println("(8) Função que determina o número total de arestas.");
        System.out.println("(9) Inclusão de um novo vértice usando Lista de Adjacências e Matriz de Adjacências.");
        System.out.println("(10) Exclusão de um vértice existente usando Lista de Adjacências e Matriz de Adjacências.");
        System.out.println("(11) Função que determina se um grafo é conexo ou não.");
        System.out.println("(12) Determinar se um grafo é bipartido");
        System.out.println("(13) Busca em Largura, a partir de um vértice específico.");
        System.out.println("(14) Busca em Profundidade, com determinação de arestas de retorno.");
        System.out.println("(15) Determinação de articulações e blocos (biconectividade).");
        System.out.println("(16) Representação do Dígrafo a partir da Matriz de Adjacências.");
        System.out.println("(17) Representação do Dígrafo a partir da Matriz de Incidência.");
        System.out.println("(18) Determinação do Grafo subjacente.");
        System.out.println("(19) Busca em Largura.");
        System.out.println("(20) Busca em Profundidade (profundidade de entrada/saída e classificação de arestas).");
        System.out.println("(0) Sair");
    }

    private static String selecionarArquivo(boolean isDigrafo, Scanner scanner) {
        int arquivo;
        String prefixo = isDigrafo ? "DIGRAFO" : "GRAFO";

        do {
            System.out.println("\n=== SELEÇÃO DE ARQUIVO (" + prefixo + ") ===");
            System.out.println("(1) Selecionar o arquivo: " + prefixo + "_0.txt");
            System.out.println("(2) Selecionar o arquivo: " + prefixo + "_1.txt");
            System.out.println("(3) Selecionar o arquivo: " + prefixo + "_2.txt");
            System.out.println("(4) Selecionar o arquivo: " + prefixo + "_3.txt");
            System.out.print("\nDigite sua opção: ");
            arquivo = scanner.nextInt();

            if (arquivo < 1 || arquivo > 4) {
                System.out.println("Opção de arquivo inválida! Tente novamente.");
            }
        } while (arquivo < 1 || arquivo > 4);

        // Inclui o diretório 'dados/'
        return "dados/" + prefixo + "_" + (arquivo - 1) + ".txt";
    }

    private static void executarOpcao(int opcao, String arquivo, Scanner scanner) {
        System.out.println("\n>>> Executando a opção " + opcao + " com o arquivo: " + arquivo);

        Grafo grafo = null;

        switch (opcao) {
            case 1 -> grafo = LeitorGrafoNormal.lerGrafo(arquivo, "lista");
            case 2 -> grafo = LeitorGrafoNormal.lerGrafo(arquivo, "matriz-adj");
            case 3 -> grafo = LeitorGrafoNormal.lerGrafo(arquivo, "matriz-inc");
            default -> System.out.println("Opção não implementada ainda.");
        }

        if (grafo != null) {
            grafo.imprimir();
            System.out.println("Número de vértices: " + grafo.numeroDeVertices());
            System.out.println("Número de arestas: " + grafo.numeroDeArestas());
        }

        // Após exibir o conteúdo, espera ENTER antes de voltar ao menu principal
        System.out.println("\nPressione ENTER para voltar ao menu principal...");
        scanner.nextLine(); // consome \n do nextInt
        scanner.nextLine(); // espera ENTER
    }
}
