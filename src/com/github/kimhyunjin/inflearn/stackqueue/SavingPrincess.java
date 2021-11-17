package com.github.kimhyunjin.inflearn.stackqueue;

import java.util.LinkedList;
import java.util.Scanner;

public class SavingPrincess {

    private static int solution(int numberOfPrince, int K) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= numberOfPrince; i++) {
            list.add(i);
        }
        int i = 0;
        while (list.size() > 1) {
            i += (K - 1);
            i = i % list.size();
            list.remove(i);
        }
        return list.getFirst();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numberOfPrince = in.nextInt();
        int K = in.nextInt();
        System.out.println(solution(numberOfPrince, K));
        return ;
    }
}
