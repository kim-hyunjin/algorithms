package com.github.kimhyunjin.inflearn.array;

import java.util.Scanner;

public class PrimeNumber2 {

    private void solution(int[] numbers) {

        for (int number : numbers) {
            StringBuilder sb = new StringBuilder();
            int reversed = Integer.parseInt(sb.append(number).reverse().toString());

            if (reversed == 1) continue;
            
            if (isPrime(reversed)) {
                System.out.print(reversed + " ");
            }
        }
    }

    private boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++ ) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args){
        PrimeNumber2 primeNumber2 = new PrimeNumber2();

        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int[] numbers = new int[input1];
        for (int i = 0; i < input1; i++) {
            numbers[i] = in.nextInt();
        }
        primeNumber2.solution(numbers);

        return ;
    }
}
