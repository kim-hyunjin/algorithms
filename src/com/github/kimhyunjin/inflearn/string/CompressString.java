package com.github.kimhyunjin.inflearn.string;

import java.util.Scanner;

public class CompressString {
    public String solution(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int repeated = 1;
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    repeated++;
                } else {
                    break;
                }
            }
            sb.append(input.charAt(i));
            if (repeated != 1) {
                sb.append(repeated);
            }
            i = i + repeated - 1;
        }
        return sb.toString();
    }
    public static void main(String[] args){
        CompressString compressString = new CompressString();
        Scanner in=new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(compressString.solution(input));
        return ;
    }
}
