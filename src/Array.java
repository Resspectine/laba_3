/**
 * Created by maks6 on 07.10.16.
 */

import java.io.*;
//import java.util.Arrays;
//import java.util.Formatter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Array {
    static void searchOfElement(BigDecimal matrix[][], double search, int N) {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (search == matrix[i][j].intValue())
                    System.out.println("i: " + i + ", j: " + j);
    }

    static void printMatrixWithHar(BigDecimal matrix[][], int masForMatrix[], int N) {
        for (int i = 0; i < N; i++) {
            System.out.print(masForMatrix[i] + " ");
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static void sortMatrixWithHar(BigDecimal matrix[][],int masForMatrix[], int N)
    {
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (masForMatrix[j] > masForMatrix[j + 1]) {
                    BigDecimal tmp[] = new BigDecimal[N];
                    tmp = matrix[j];
                    matrix[j] = matrix[j + 1];
                    matrix[j + 1] = tmp;
                    int tmp1 = 0;
                    tmp1 = masForMatrix[j];
                    masForMatrix[j] = masForMatrix[j + 1];
                    masForMatrix[j + 1] = tmp1;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = "";
        BigDecimal matrix[][];
        Random r = new Random(System.currentTimeMillis());
        int N = in.nextInt();
        matrix = new BigDecimal[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                matrix[i][j] = new BigDecimal(r.nextInt(21) - 10);
            }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        int masForMatrix[] = new int[N];
        for (int i = 0; i < N; i++)
            masForMatrix[i] = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                if (matrix[i][j].intValue() > 0 && matrix[i][j].intValue() % 2 == 0)
                    masForMatrix[i] += matrix[i][j].intValue();
            }
        printMatrixWithHar(matrix, masForMatrix, N);
        sortMatrixWithHar(matrix,masForMatrix,N);
        printMatrixWithHar(matrix, masForMatrix, N);
        int i1=in.nextInt();
        int j1=in.nextInt();
        Arrays.sort(matrix[0], i1, j1+1, (BigDecimal s, BigDecimal f) -> f.compareTo(s));
        printMatrixWithHar(matrix, masForMatrix, N);
        double search = in.nextDouble();
        searchOfElement(matrix, search, N);
    }
}
