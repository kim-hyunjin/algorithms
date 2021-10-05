package com.github.kimhyunjin.inflearn.string;

import java.util.Scanner;

public class Palindrome {
    public String solution(String input) {
        String left = input.substring(0, input.length() / 2);
        String right = "";
        if (input.length() % 2 == 0) {
            right = input.substring((input.length() / 2));
        } else {
            right = input.substring((input.length() / 2) + 1);
        }
        right = new StringBuilder(right).reverse().toString();

        if (left.equalsIgnoreCase(right)) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        System.out.println(palindrome.solution(input1));
        return;
    }
}
