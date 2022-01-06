package com.github.kimhyunjin.inflearn.dfs;

import java.util.Scanner;

public class Permutation {
    static int[] pm;
    static int n;

    public void DFS(int L) {
        if (L == pm.length) {
            for (int x : pm) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = 1; i <=n; i++) {
                pm[L] = i;
                DFS(L+1);
            }
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int pmLen = kb.nextInt();
        pm = new int[pmLen];
        permutation.DFS(0);
    }
}
