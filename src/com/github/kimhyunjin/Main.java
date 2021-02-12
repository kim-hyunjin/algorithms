package com.github.kimhyunjin;

import com.github.kimhyunjin.basic.PrimeNumber;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List primes = PrimeNumber.findPrimeNumbers(50);
        System.out.println(primes);
    }
}
