package com.github.kimhyunjin.inflearn.array;

import java.util.Scanner;

public class FindMountain {

    private int solution(int[][] land) {
        int peaks = 0;
        final int size = land.length - 1;

        for (int y = 1; y < size; y++) {
            for (int x = 1; x < size; x++) {
                final int candidate = land[y][x];
                final int up = land[y - 1][x];
                final int right = land[y][x + 1];
                final int down = land[y + 1][x];
                final int left = land[y][x - 1];
                if (candidate > up
                        && candidate > right
                        && candidate > down
                        && candidate > left) {
                    peaks++;
                }
            }
        }

        return peaks;
    }

    public static void main(String[] args) {
        FindMountain findMountain = new FindMountain();
        Scanner in = new Scanner(System.in);
        final int input1 = in.nextInt();
        final int size = input1 + 2;
        final int[][] land = new int[size][size];
        for (int y = 1; y < size - 1; y++) {
            for (int x = 1; x < size - 1; x++) {
                land[y][x] = in.nextInt();
            }
        }
        System.out.println(findMountain.solution(land));
        return;
    }
}
