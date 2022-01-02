package com.github.kimhyunjin.inflearn.sortandsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MischiefMakerTest {

    private MischiefMaker mischiefMaker;

    @BeforeEach
    public void setup() {
        mischiefMaker = new MischiefMaker();
    }

    @Test
    public void test() {
        int[] expected = new int[]{3, 8};
        int[] actual = mischiefMaker.solution(new int[]{120, 125, 152, 130, 135, 135, 143, 127, 160});

        Assertions.assertArrayEquals(expected, actual);
    }
}
