package com.github.kimhyunjin.inflearn.slidingwindow;

import java.util.Scanner;

public class ConsecutiveNSum {

    private static int solution(int targetSum) {
        int answer = 0;
        int[] arr = new int[targetSum];
        for (int i = 1; i < targetSum; i++) {
            arr[i] = i;
        }

        int f = 1, b = 1, sum = 0;
        while (b < arr.length) {
            if (sum == targetSum) {
                answer++;
                sum -= arr[f++];
            } else if (sum < targetSum) {
                sum += arr[b++];
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
        int targetSum = in.nextInt();
        System.out.println(solution(targetSum));
        return ;
    }
}
