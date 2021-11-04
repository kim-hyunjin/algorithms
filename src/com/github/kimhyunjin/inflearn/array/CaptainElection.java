package com.github.kimhyunjin.inflearn.array;

import java.util.*;

public class CaptainElection {

    private int solution(final int students, final int[][] table) {
        List<Set<Integer>> commons = new ArrayList<>();
        for (int y = 0; y < students; y++) {
            Set<Integer> sameClassRoomSet = new HashSet<>();
            for (int x = 0; x < 5; x++) {
                for (int y2 = 0; y2 < students; y2++) {
                    if (y == y2) continue;
                    if (table[y][x] == table[y2][x]) sameClassRoomSet.add(y2);
                }
            }
            commons.add(sameClassRoomSet);
        }

        int answer = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < commons.size(); i++) {
            if (commons.get(i).size() > max) {
                max = commons.get(i).size();
                answer = i + 1;
            }
        }

        return answer;
    }


    public static void main(String[] args){
        CaptainElection captainElection = new CaptainElection();
        Scanner in=new Scanner(System.in);
        final int students = in.nextInt();
        int[][] table = new int[students][5];
        for (int y = 0; y < students; y++) {
            for (int x = 0; x < 5; x++) {
                table[y][x] = in.nextInt();
            }
        }

        System.out.println(captainElection.solution(students, table));
        return ;
    }
}
