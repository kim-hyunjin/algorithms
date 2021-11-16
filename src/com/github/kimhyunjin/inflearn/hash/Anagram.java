package com.github.kimhyunjin.inflearn.hash;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {

    private static boolean solution(String input1, String input2) {
        char[] chars1 = input1.toCharArray();
        char[] chars2 = input2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return compressChars(chars1).equals(compressChars(chars2));
    }

    private static String compressChars(char[] chars) {
        StringBuilder result = new StringBuilder();

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            result.append(entry.getKey() + entry.getValue());
        }

        return result.toString();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        String input2 = in.next();
        boolean result = solution(input1, input2);
        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        return ;
    }
}
