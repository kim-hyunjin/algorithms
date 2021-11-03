package com.github.kimhyunjin.inflearn.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Ranking {

    private int[] solution(int[] scores) {
        // 점수순으로 정렬
        Integer[] ranking = Arrays.stream(scores).boxed().toArray(Integer[]::new);
        Arrays.sort(ranking, Comparator.reverseOrder());

        // 내 등수를 랭킹 배열을 순회하며 찾기
        int[] result = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores.length; j++) {
                if (scores[i] == ranking[j]) {
                    result[i] = j + 1;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Ranking ranking = new Ranking();
        Scanner in = new Scanner(System.in);
        int input1 = in.nextInt();
        int[] scores = new int[input1];
        for (int i = 0; i < input1; i++) {
            scores[i] = in.nextInt();
        }
        int[] ranked = ranking.solution(scores);
        for (int i : ranked) {
            System.out.print(i + " ");
        }
        return ;
    }
}
