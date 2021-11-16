package com.github.kimhyunjin.inflearn.hash;

import java.util.*;

public class SalesKinds {

    private static List<Integer> solution(int[] sales, int k) {
        List<Integer> answer = new ArrayList<>();
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        int lt = 0, rt = 0;

        for (; rt < k; rt++) {
            map.put(sales[rt], map.getOrDefault(sales[rt], 0) + 1);
        }
        answer.add(map.keySet().size());
        while (rt < sales.length) {
            if (map.get(sales[lt]) > 1) {
                map.put(sales[lt], map.get(sales[lt]) - 1);
            } else {
                map.remove(sales[lt]);
            }
            map.put(sales[rt], map.getOrDefault(sales[rt], 0) + 1);
            answer.add(map.keySet().size());
            lt++;
            rt++;
        }

        return answer;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int salesLength = in.nextInt();
        int k = in.nextInt();
        int[] sales = new int[salesLength];
        for (int i = 0; i < salesLength; i++) {
            sales[i] = in.nextInt();
        }
        for (int i : solution(sales, k)) {
            System.out.print(i + " ");
        }
        return ;
    }

}
