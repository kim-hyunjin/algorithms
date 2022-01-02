package com.github.kimhyunjin.inflearn.sort;

import java.util.*;
import java.util.stream.Collectors;

public class LRU {

    public List<Integer> solution(int cacheSize, int[] jobs) {
        Map<Integer, Integer> map = new HashMap<>();
        // 최근 작업일 수록 높은 recentJobNumber를 가짐.
        int recentJobNumber = 1;
        for (int job : jobs) {
            map.put(job, recentJobNumber++);
        }

        // recentJobNumber 순으로 정렬
        List<Map.Entry<Integer, Integer>> sortedByRecentlyUsed = map.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < cacheSize; i++) {
            result.add(sortedByRecentlyUsed.get(i).getKey());
        }
        return result;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int cacheSize = in.nextInt();
        int numOfJobs = in.nextInt();
        int[] jobs = new int[numOfJobs];
        for (int i = 0; i < numOfJobs; i++) {
            jobs[i] = in.nextInt();
        }

        LRU lru = new LRU();
        for (int job : lru.solution(cacheSize, jobs)) {
            System.out.print(job + " ");
        }

        return ;
    }

}
