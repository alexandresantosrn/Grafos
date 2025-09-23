package view;

import java.util.Scanner;

public class MenuGrafos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
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
            System.out.println("(12) Determinar se um grafo é bipartido (OPC = 1,0 ponto)");
            System.out.println("(13) Busca em Largura, a partir de um vértice específico.");
            System.out.println("(14) Busca em Profundidade, com determinação de arestas de retorno, a partir de um vértice em específico.");
            System.out.println("(15) Determinação de articulações e blocos (biconectividade), utilizando obrigatoriamente a função lowpt.");
            System.out.println("(16) Representação do Dígrafo a partir da Matriz de Adjacências.");
            System.out.println("(17) Representação do Dígrafo a partir da Matriz de Incidência.");
            System.out.println("(18) Determinação do Grafo subjacente (OPC = 0,5 ponto)");
            System.out.println("(19) Busca em Largura.");
            System.out.println("(20) Busca em Profundidade, com determinação de profundidade de entrada e de saída de cada vértice, e arestas de árvore, retorno, avanço e cruzamento.");
            System.out.println("(0) Sair");

            System.out.print("\nDigite sua opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo... Obrigado!");
                    break;
                case 1:
                    System.out.println("Você escolheu: Criação do Grafo a partir da Lista de Adjacências.");
                    break;
                case 2:
                    System.out.println("Você escolheu: Criação do Grafo a partir da Matriz de Adjacências.");
                    break;
                case 3:
                    System.out.println("Você escolheu: Criação do Grafo a partir da Matriz de Incidência.");
                    break;
                case 4:
                    System.out.println("Você escolheu: Conversão de matriz de adjacência para lista de Adjacências e vice-versa.");
                    break;
                case 5:
                    System.out.println("Você escolheu: Função que calcula o grau de cada vértice.");
                    break;
                case 6:
                    System.out.println("Você escolheu: Função que determina se dois vértices são adjacentes.");
                    break;
                case 7:
                    System.out.println("Você escolheu: Função que determina o número total de vértices.");
                    break;
                case 8:
                    System.out.println("Você escolheu: Função que determina o número total de arestas.");
                    break;
                case 9:
                    System.out.println("Você escolheu: Inclusão de um novo vértice usando Lista de Adjacências e Matriz de Adjacências.");
                    break;
                case 10:
                    System.out.println("Você escolheu: Exclusão de um vértice existente usando Lista de Adjacências e Matriz de Adjacências.");
                    break;
                case 11:
                    System.out.println("Você escolheu: Função que determina se um grafo é conexo ou não.");
                    break;
                case 12:
                    System.out.println("Você escolheu: Determinar se um grafo é bipartido.");
                    break;
                case 13:
                    System.out.println("Você escolheu: Busca em Largura, a partir de um vértice específico.");
                    break;
                case 14:
                    System.out.println("Você escolheu: Busca em Profundidade, com determinação de arestas de retorno.");
                    break;
                case 15:
                    System.out.println("Você escolheu: Determinação de articulações e blocos (biconectividade).");
                    break;
                case 16:
                    System.out.println("Você escolheu: Representação do Dígrafo a partir da Matriz de Adjacências.");
                    break;
                case 17:
                    System.out.println("Você escolheu: Representação do Dígrafo a partir da Matriz de Incidência.");
                    break;
                case 18:
                    System.out.println("Você escolheu: Determinação do Grafo subjacente.");
                    break;
                case 19:
                    System.out.println("Você escolheu: Busca em Largura.");
                    break;
                case 20:
                    System.out.println("Você escolheu: Busca em Profundidade com profundidade de entrada/saída e classificação de arestas.");
                    break;
                default:
                    System.out.println("Opção inválida! Digite um número entre 0 e 20.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
