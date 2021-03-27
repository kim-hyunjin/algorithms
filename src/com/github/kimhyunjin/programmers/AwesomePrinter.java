package com.github.kimhyunjin.programmers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AwesomePrinter {

    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(solution(priorities, location));
    }

    private static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Map<String, Integer>> printQueue = IntStream.range(0, priorities.length)
                .mapToObj(index -> new HashMap<String, Integer>() {{
                    put("priority", priorities[index]);
                    put("location", index);
                }}).collect(Collectors.toCollection(LinkedList::new));

        while (true) {
            Map<String, Integer> doc = printQueue.poll();
            if (printQueue.stream().anyMatch(item -> item.get("priority") > doc.get("priority"))) {
                printQueue.add(doc);
            } else {
                answer++;
                if (doc.get("location") == location) {
                    return answer;
                }
            }
        }
    }
}
