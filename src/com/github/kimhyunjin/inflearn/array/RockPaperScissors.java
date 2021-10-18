package com.github.kimhyunjin.inflearn.array;

import java.util.Scanner;

public class RockPaperScissors {
    public void solution(int[] A, int[] B) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                if (B[i] == 1) {
                    System.out.println("D");
                } else if (B[i] == 2) {
                    System.out.println("B");
                } else {
                    System.out.println("A");
                }
            } else if (A[i] == 2) {
                if (B[i] == 1) {
                    System.out.println("A");
                } else if (B[i] == 2) {
                    System.out.println("D");
                } else {
                    System.out.println("B");
                }
            } else {
                if (B[i] == 1) {
                    System.out.println("B");
                } else if (B[i] == 2) {
                    System.out.println("A");
                } else {
                    System.out.println("D");
                }
            }
        }
    }

    public static void main(String[] args){
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int[] A = new int[input1];
        int[] B = new int[input1];
        for (int i = 0; i < A.length; i++) {
            A[i] = in.nextInt();
        }
        for (int i = 0; i < B.length; i++) {
            B[i] = in.nextInt();
        }

        rockPaperScissors.solution(A, B);

        return ;
    }
}
