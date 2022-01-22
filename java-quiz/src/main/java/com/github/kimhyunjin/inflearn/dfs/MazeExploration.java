package com.github.kimhyunjin.inflearn.dfs;

import java.util.Scanner;

public class MazeExploration {

    int[][] maze;
    int answer;

    public void DFS(int L) {

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int mazeSize = 7;
        MazeExploration mazeExploration = new MazeExploration();
        mazeExploration.maze = new int[mazeSize][mazeSize];
        for (int i = 0; i < mazeSize; i++) {
            for (int j = 0; j < mazeSize; j++) {
                mazeExploration.maze[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < mazeSize; i++) {
            for (int j = 0; j < mazeSize; j++) {
                System.out.print(mazeExploration.maze[i][j] + " ");
            }
            System.out.println();
        }
        return ;
    }
}
