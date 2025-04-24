/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calcmatriz;

/**
 *
 * @author pgarc
 */
/*
 * Projeto: Calculadora de Matrizes (Console)
 * Arquivo: MatrizCalc.java
 * Descrição: Lê duas matrizes NxM do usuário e oferece operações:
 *  - Soma
 *  - Subtração
 *  - Multiplicação
 *  - Transposição
 * Como usar:
 * 1. Compile: javac MatrizCalc.java
 * 2. Execute: java MatrizCalc
 */
import java.util.Scanner;

public class CalcMatriz{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de linhas das matrizes: ");
        int n = sc.nextInt();
        System.out.print("Número de colunas das matrizes: ");
        int m = sc.nextInt();

        System.out.println("\n--- Leitura da Matriz A ---");
        int[][] A = leMatriz(sc, n, m, "A");
        System.out.println("\n--- Leitura da Matriz B ---");
        int[][] B = leMatriz(sc, n, m, "B");

        // Soma
        System.out.println("\n--- Soma A + B ---");
        int[][] soma = somaMatrizes(A, B);
        imprimeMatriz(soma);

        // Subtração
        System.out.println("\n--- Subtração A - B ---");
        int[][] sub = subtraiMatrizes(A, B);
        imprimeMatriz(sub);

        // Multiplicação (A x B^T para compatibilidade)
        System.out.println("\n--- Multiplicação A x B^T ---");
        int[][] Bt = transpõeMatriz(B);
        int[][] prod = multiplicaMatrizes(A, Bt);
        imprimeMatriz(prod);

        // Transposição de A
        System.out.println("\n--- Transposta de A ---");
        int[][] tA = transpõeMatriz(A);
        imprimeMatriz(tA);

        sc.close();
    }

    // Leitura de matriz
    static int[][] leMatriz(Scanner sc, int linhas, int colunas, String nome) {
        int[][] M = new int[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.printf("%s[%d][%d]: ", nome, i, j);
                M[i][j] = sc.nextInt();
            }
        }
        return M;
    }

    // Imprime matriz
    static void imprimeMatriz(int[][] M) {
        for (int[] row : M) {
            for (int val : row) {
                System.out.printf("%6d", val);
            }
            System.out.println();
        }
    }

    // Soma de matrizes
    static int[][] somaMatrizes(int[][] A, int[][] B) {
        int n = A.length, m = A[0].length;
        int[][] R = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                R[i][j] = A[i][j] + B[i][j];
        return R;
    }

    // Subtração de matrizes
    static int[][] subtraiMatrizes(int[][] A, int[][] B) {
        int n = A.length, m = A[0].length;
        int[][] R = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                R[i][j] = A[i][j] - B[i][j];
        return R;
    }

    // Multiplicação de matrizes (assume dimensões compatíveis)
    static int[][] multiplicaMatrizes(int[][] A, int[][] B) {
        int n = A.length;
        int p = B[0].length;
        int m = A[0].length; // = B.length
        int[][] R = new int[n][p];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    sum += A[i][k] * B[k][j];
                }
                R[i][j] = sum;
            }
        }
        return R;
    }

    // Transposição de matriz
    static int[][] transpõeMatriz(int[][] A) {
        int n = A.length, m = A[0].length;
        int[][] T = new int[m][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                T[j][i] = A[i][j];
        return T;
    }
}
