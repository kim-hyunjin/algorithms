package com.github.kimhyunjin.inflearn.sort;

import java.util.Scanner;

public class BubbleSort {

    private static void sort(int[] arr) {
        // 뒤에서부터 큰 수가 정렬된다.
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
        }
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        return;
    }
}