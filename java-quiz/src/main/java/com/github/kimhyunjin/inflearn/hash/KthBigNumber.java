package com.github.kimhyunjin.inflearn.hash;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class KthBigNumber {

    private static int solution(int[] arr, int kth) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    set.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }

        int[] sorted = set.stream().sorted((a, b) -> b - a).mapToInt(Integer::intValue).toArray();
        if (sorted.length >= kth) {
            return sorted[kth - 1];
        } else {
            return -1;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] arr = new int[len];
        int kth = in.nextInt();
        for (int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution(arr, kth));
        return ;
    }
}
