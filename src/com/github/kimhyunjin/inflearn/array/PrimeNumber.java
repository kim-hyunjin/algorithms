package com.github.kimhyunjin.inflearn.array;

import java.util.Scanner;

/**
 * 에라토스테네스 체
 *
 */
public class PrimeNumber {

    private int solution(int n) {
        int answer = 0;
        int[] numbers = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (numbers[i] == 0) {
                answer++;
                // i의 배수들 체크
                for (int j = i * 2; j <= n; j += i) {
                    numbers[j] = 1;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        PrimeNumber primeNumber = new PrimeNumber();
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        System.out.println(primeNumber.solution(input1));
        return ;
    }
}
