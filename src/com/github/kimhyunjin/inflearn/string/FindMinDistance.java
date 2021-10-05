package com.github.kimhyunjin.inflearn.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindMinDistance {
    public int getMinDistance(int position, List<Integer> charIndexes) {
        int min = Integer.MAX_VALUE;
        for (int charIndex : charIndexes) {
            if (Math.abs(position - charIndex) < min) {
                min = Math.abs(position - charIndex);
            }
        }
        return min;
    }
    public int[] solution(String str, char c) {
        int[] distance = new int[str.length()];
        List<Integer> charIndexes = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                charIndexes.add(i);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            distance[i] = getMinDistance(i, charIndexes);
        }
        return distance;
    }
    public static void main(String[] args){
        FindMinDistance findMinDistance = new FindMinDistance();
        Scanner in=new Scanner(System.in);
        String str = in.next();
        String character = in.next();
        for (int i : findMinDistance.solution(str, character.charAt(0))) {
            System.out.print(i + " ");
        }
        return ;
    }
}
