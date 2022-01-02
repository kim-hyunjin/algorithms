package com.github.kimhyunjin.inflearn.sortandsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MischiefMaker {

    public int[] solution(int[] students) {
        int[] result = new int[2];
        int firstMischiefMaker = -1;
        for (int i = 0; i < students.length - 1; i++) {
            if (firstMischiefMaker == -1 && students[i] > students[i + 1]) {
                firstMischiefMaker = i;
                result[0] = i + 1;
            }
            if (students[i] < students[firstMischiefMaker + 1]) {
                result[1] = i + 1;
            }
        }
        return result;
    }

     public List<Integer> solution2(int[] students) {
         ArrayList<Integer> answer = new ArrayList<>();
         int[] correctlySortedStudents = students.clone();
         Arrays.sort(correctlySortedStudents);
         
         for (int i = 0; i < students.length; i++) {
             if (students[i] != correctlySortedStudents[i]) answer.add(i+1);
         }

         return answer;
     }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] students = new int[N];
        for (int i = 0; i < N; i++) {
            students[i] = in.nextInt();
        }

        MischiefMaker mischiefMaker = new MischiefMaker();
        int[] result = mischiefMaker.solution(students);
        for (int i : result) {
            System.out.print(i + " ");
        }

        return ;
    }
}
