package com.github.kimhyunjin;

import com.github.kimhyunjin.gugudan.WeirdGugudan;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            WeirdGugudan gugudan = new WeirdGugudan();

            System.out.println("한 줄에 출력할 단 수를 입력하세요. (1~9)");
            System.out.println("종료는 0");
            try {
                int inputN = Integer.parseInt(String.valueOf(sc.nextLine()));
                if (inputN >= 1 && inputN <=9) {
                    gugudan.printGugudan(inputN);

                }
                if (inputN == 0) {
                    break;
                }
            } catch (Exception e) {

            }
        }
    }
}
