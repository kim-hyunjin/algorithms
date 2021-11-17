package com.github.kimhyunjin.inflearn.stackqueue;

import java.util.*;

public class PuppetDraw {

    private static int solution(List<Queue<Integer>> board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int m : moves) {
            Queue<Integer> col = board.get(m - 1);
            if (col.isEmpty()) continue;

            int puppet = col.poll();
            if (!stack.isEmpty() && stack.peek() == puppet) {
                stack.pop();
                answer += 2;
            } else {
                stack.push(puppet);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        List<Queue<Integer>> board = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            board.add(new LinkedList<>());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int puppet = in.nextInt();
                if (puppet != 0) board.get(j).add(puppet);
            }
        }

        int M = in.nextInt();
        int[] moves = new int[M];
        for (int i = 0; i < M; i++) {
            moves[i] = in.nextInt();
        }

        System.out.println(solution(board, moves));
        return ;
    }


}
