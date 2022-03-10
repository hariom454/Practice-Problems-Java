package com.shashtra.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/***************
 **   @author: Hariom Singh
 **  Date: 10/03/22
 *****************/
class ZAlgorithmTest {

    @Test
    void calculateZ() {
        ZAlgorithm zalgo = new ZAlgorithm("abcabcab");
        int expected[] = {0, 0, 0, 5, 0, 0, 2, 0};

        int result[] = zalgo.calculateZ();

        assertArrayEquals(expected, result);

    }
}