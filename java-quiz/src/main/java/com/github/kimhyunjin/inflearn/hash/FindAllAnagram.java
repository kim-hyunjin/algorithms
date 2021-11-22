package com.github.kimhyunjin.inflearn.hash;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FindAllAnagram {

    private static int solution(String S, String T) {
        int answer = 0;

        char[] targetChars = T.toCharArray();
        Arrays.sort(targetChars);
        String target = compressChars(targetChars);

        int lt = 0, rt = T.length();
        while (rt <= S.length()) {
            char[] tmp = S.substring(lt, rt).toCharArray();
            Arrays.sort(tmp);
            if (target.equals(compressChars(tmp))) answer++;
            lt++;
            rt++;
        }

        return answer;
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        String T = in.next();
        System.out.println(solution(S, T));
        return;
    }
}
