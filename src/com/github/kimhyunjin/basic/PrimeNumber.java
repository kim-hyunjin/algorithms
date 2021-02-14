package com.github.kimhyunjin.basic;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

    public PrimeNumber() {}

    /**
     * 아리스토테네스의 체를 사용해
     * 1 ~ n 개 사이의 소수를 리턴
     * @param n
     * @return
     */
    public static List<Integer> findPrimeNumbers(int n) {
        List<Integer> returnArr = new ArrayList<>();
        int[] primes = new int[n+1];
        for (int i = 2; i <= n; i++) {
            primes[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            if(primes[i] == 0) {
                continue;
            }

            // i를 제외한 i의 배수들 걸러내기
            for (int j = i+i; j <= n; j += i) {
                primes[j] = 0;
            }
        }

        // 걸러지지 않은 수들은 소수임
        for (int i = 2; i <= n; i++) {
            if (primes[i] != 0) {
                returnArr.add(primes[i]);
            }
        }
        return returnArr;
    }
}
