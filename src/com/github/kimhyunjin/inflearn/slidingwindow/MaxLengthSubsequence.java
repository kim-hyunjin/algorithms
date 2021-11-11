package com.github.kimhyunjin.inflearn.slidingwindow;

import java.util.Scanner;

public class MaxLengthSubsequence {

    /*
        input
        20 2
        1 0 1 1 1 1 1 0 1 0 1 1 1 1 1 0 1 1 0 1

        output
        13
     */
    private static int solution(int[] arr, int life) {
        int len = 0, maxLen = 0;
        int f = 0, b = 0;
        while (b < arr.length) {
            if (arr[b] == 1) {
                len++; b++;
            } else {
                if (life > 0) {
                    len++; b++;
                    life--;
                } else {
                    if (arr[f++] == 0) {
                        len--;
                        life++;
                    } else {
                        len--;
                    }
                }
            }
            maxLen = Math.max(len, maxLen);
        }

        return maxLen;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int life = in.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution(arr, life));
        return ;
    }
}
