package com.github.kimhyunjin.inflearn.slidingwindow;

import java.util.Scanner;

public class ConsecutiveSubsequence {
    /**
     input
     8 6
     1 2 1 3 1 1 1 2

     output
     3
     */
    private static int solution(int[] arr, int targetSum) {
        int answer = 0;
        int sum = 0;
        int f = 0;
        int b = 0;
        while (b < arr.length) {
            if (sum < targetSum) {
                sum += arr[b++];
            } else if (sum == targetSum) {
                answer++;
                sum -= arr[f++];
            } else {
                sum -= arr[f++];
            }
        }
        while (f < arr.length) {
            if (sum == targetSum) {
                answer++;
            }
            sum -= arr[f++];
        }

        return answer;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int targetSum = in.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution(arr, targetSum));
        return ;
    }
}
