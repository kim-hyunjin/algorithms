package com.github.kimhyunjin.inflearn.array;

import java.util.ArrayList;
import java.util.Scanner;

/**
 4 3
 3 4 1 2
 4 3 2 1
 3 1 4 2
 *
 */
public class Mentoring {

    private int solution(final int students, final int tests, final int[][] table) {
        ArrayList<Integer> mentorCandidate = new ArrayList<>();
        // 한번이라도 꼴등했다면 멘토가 될 수 없다.
        for (int s = 1; s <= students; s++) {
            boolean canBeCandidate = true;
            for (int y = 0; y < tests; y++) {
                if (s == table[y][students - 1]) {
                    canBeCandidate = false;
                    break;
                }
            }
            if (canBeCandidate) {
                mentorCandidate.add(s);
            }
        }

        int answer = 0;
        for (int mentor : mentorCandidate) {
            //System.out.println("mentor? : " + mentor);
            for (int mentee = 1; mentee <= students; mentee++) {
                if (mentor == mentee) continue;
                //System.out.println("mentee? : " + mentee);

                // 모든 테스트에서 등수가 앞서야 멘토-멘티가 짝지어질 수 있다.
                boolean canBeMentor = true;
                for (int[] test : table) {
                    //System.out.println(Arrays.toString(test));
                    int mentorRank = 0; int menteeRank = 0;
                    for (int i = 0; i < test.length; i++) {
                        if (test[i] == mentor) mentorRank = i + 1;
                        if (test[i] == mentee) menteeRank = i + 1;
                        if (mentorRank > 0 && menteeRank > 0) break;
                    }
                    //System.out.println("montor Rank: " + mentorRank + " mentee Rank: " + menteeRank);
                    if (mentorRank > menteeRank) canBeMentor = false; // rank가 낮아야 등수가 앞선 것이다.
                }

                if (canBeMentor) answer++;
            }

        }

        return answer;
    }

    public static void main(String[] args){
        Mentoring mentoring = new Mentoring();
        Scanner in=new Scanner(System.in);
        int students = in.nextInt();
        int tests = in.nextInt();
        int[][] table = new int[tests][students];

        for (int y = 0; y < tests; y++) {
            for (int x = 0; x < students; x++) {
                table[y][x] = in.nextInt();
            }
        }

        System.out.println(mentoring.solution(students, tests, table));

        return ;
    }
}
