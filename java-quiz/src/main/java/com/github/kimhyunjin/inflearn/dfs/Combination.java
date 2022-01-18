package com.github.kimhyunjin.inflearn.dfs;

import java.util.Scanner;

public class Combination {
    static int n, r;
    static int[][] mem;

    public void DFS(int L) {
        if(L == n + 1) {
            return;
        } else {
            mem[L][0] = 1;
            for (int i = 1; i < L; i++) {
                mem[L][i] = mem[L-1][i-1] + mem[L-1][i];
            }
            mem[L][L] = 1;
            DFS(L+1);
        }
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        n = in.nextInt();
        r = in.nextInt();
        mem = new int[n + 1][n + 1];
        Combination combination = new Combination();
        combination.DFS(0);
        System.out.println(mem[n][r]);
        return ;
    }
}
