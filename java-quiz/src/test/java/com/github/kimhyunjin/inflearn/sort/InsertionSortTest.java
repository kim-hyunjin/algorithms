package com.github.kimhyunjin.inflearn.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InsertionSortTest {

    @Test
    public void test() {
        // given
        int[] arr = {11, 7, 5, 6, 10, 9};
        int[] expect = {5, 6, 7, 9, 10, 11};

        // when
        int[] actual = InsertionSort.solution(arr);

        // then
        Assertions.assertArrayEquals(expect, actual);
    }

}
