package com.github.kimhyunjin.inflearn.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindCow {

    int[] check;
    int[] move = {1, -1, 5};
    Queue<Integer> Q = new LinkedList<>();

    public int solution(int myPos, int cowPos) {
        check = new int[10001]; // 최대 좌표 10000
        Q.add(myPos);
        check[myPos] = 1;

        int L = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int curPos = Q.poll();

                for (int k : move) {
                    int nextPos = curPos + k;
                    if (nextPos == cowPos) return L + 1;

                    if (nextPos >= 1 && nextPos <= 10000 && check[nextPos] == 0) {
                        check[nextPos] = 1;
                        Q.offer(nextPos);
                    }
                }

            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int myPos = in.nextInt();
        int cowPos = in.nextInt();

        FindCow findCow = new FindCow();
        System.out.println(findCow.solution(myPos, cowPos));
        return ;
    }
}
