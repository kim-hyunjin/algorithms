package com.github.kimhyunjin.inflearn.string;

import java.util.Scanner;

public class ExtractNumber {
    public String solution(String input) {
        String answer = "";
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                answer += c;
            }
        }
        return String.valueOf(Integer.parseInt(answer));
    }
    public static void main(String[] args){
        ExtractNumber extractNumber = new ExtractNumber();
        Scanner in=new Scanner(System.in);
        String input1 = in.nextLine();
        System.out.println(extractNumber.solution(input1));
        return ;
    }
}
