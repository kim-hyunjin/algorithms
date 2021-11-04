package com.github.kimhyunjin.inflearn.twopointer;

import java.util.*;

public class CommonElement {

    private int[] solution(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr1) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for (int a: arr2) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        map.forEach((key, value) -> {
            if (value == 2) {
                list.add(key);
            }
        });

        return list.stream().sorted().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args){
        CommonElement commonElement = new CommonElement();
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int[] arr1 = new int[input1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = in.nextInt();
        }
        int input2 = in.nextInt();
        int[] arr2 = new int[input2];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = in.nextInt();
        }

        for(int a : commonElement.solution(arr1, arr2)) {
            System.out.print(a + " ");
        }

        return ;
    }
}
