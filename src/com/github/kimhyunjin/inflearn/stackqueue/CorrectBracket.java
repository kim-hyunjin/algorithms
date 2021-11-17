package com.github.kimhyunjin.inflearn.stackqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CorrectBracket {

    private static boolean isRightBracket(String bracket) {
        List<Character> left = new ArrayList<>();
        List<Character> right = new ArrayList<>();
        for (char c : bracket.toCharArray()) {
            if (c == '(') left.add(c);
            if (c == ')') {
                right.add(c);
                if (left.size() < right.size()) return false;
            }
        }

        return left.size() == right.size();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String brackets = in.next();
        if (isRightBracket(brackets)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        return ;
    }

}
