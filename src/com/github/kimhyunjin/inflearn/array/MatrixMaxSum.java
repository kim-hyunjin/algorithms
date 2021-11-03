package com.github.kimhyunjin.inflearn.array;

import java.util.Scanner;

public class MatrixMaxSum {

    private int solution(int[][] matrix) {
        int[] rowSum = new int[matrix.length];
        int[] colSum = new int[matrix.length];
        int mainDiagonal = 0;
        int reverseDiagonal = 0;

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix.length; x++) {
                rowSum[y] += matrix[y][x];
                colSum[x] += matrix[y][x];
                if (y == x) {
                    mainDiagonal += matrix[y][x];
                }
            }
        }
        for (int x = matrix.length - 1, y = 0; x >= 0; x--) {
            reverseDiagonal += matrix[y][x];
            y++;
        }

        int max = 0;
        for (int n : rowSum) {
            if (n > max) max = n;
        }
        for (int n : colSum) {
            if (n > max) max = n;
        }
        if (mainDiagonal > max) max = mainDiagonal;
        if (reverseDiagonal > max) max = reverseDiagonal;
        return max;
    }

    public static void main(String[] args){
        MatrixMaxSum matrixMaxSum = new MatrixMaxSum();
        Scanner in=new Scanner(System.in);
        int size = in.nextInt();
        int[][] matrix = new int[size][size];
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix.length; x++) {
                matrix[y][x] = in.nextInt();
            }
        }

        System.out.println(matrixMaxSum.solution(matrix));
        return ;
    }
}
