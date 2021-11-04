package com.github.kimhyunjin.inflearn.twopointer;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ConcatTwoArray {

    private int[] concat(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, result, 0, arr1.length);

        if (result.length - arr1.length >= 0)
            System.arraycopy(arr2, 0, result, arr1.length, arr2.length);

        Arrays.sort(result);

        return result;
    }

    // stream 사용
    private int[] concat2(int[] arr1, int[] arr2) {
        return IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().toArray();
    }

    public static void main(String[] args){
        ConcatTwoArray concatTwoArray = new ConcatTwoArray();
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int[] arr1 = new int[input1];
        for (int i = 0;  i < arr1.length; i++) {
            arr1[i] = in.nextInt();
        }
        //System.out.println(Arrays.toString(arr1));
        int input2 = in.nextInt();
        int[] arr2 = new int[input2];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = in.nextInt();
        }
        //System.out.println(Arrays.toString(arr2));

        for(int i : concatTwoArray.concat2(arr1, arr2)) {
            System.out.print(i + " ");
        }

        return ;
    }
}
