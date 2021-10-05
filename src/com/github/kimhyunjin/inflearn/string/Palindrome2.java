package com.github.kimhyunjin.inflearn.string;

import java.util.Scanner;

public class Palindrome2 {
    public String toAlphabet(String input) {
        String onlyAlphabet = "";
        for (char c : input.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                onlyAlphabet += c;
            }
        }
        return onlyAlphabet;
    }
    public String solution(String input) {
        input = toAlphabet(input);

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
        Palindrome2 palindrome = new Palindrome2();
        Scanner in = new Scanner(System.in);
        String input1 = in.nextLine();
        System.out.println(palindrome.solution(input1));
        return;
    }
}
