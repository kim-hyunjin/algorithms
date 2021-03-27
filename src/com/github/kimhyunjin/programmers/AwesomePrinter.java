package com.github.kimhyunjin.programmers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AwesomePrinter {

    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(solution2(priorities, location));
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

    private static int solution2(int[] priorities, int location) {
        int answer = 0;
        int l = location;
        Queue<Integer> printQueue = new LinkedList<>();
        for (int i : priorities) {
            printQueue.add(i);
        }

        Arrays.sort(priorities);
        int maxLocation = priorities.length - 1;

        while(!printQueue.isEmpty()) {
            // 문서를 앞에서부터 꺼내 우선순위 비교
            Integer item = printQueue.poll();
            if (item == priorities[maxLocation - answer]) {
                answer++;
                l--;
                if (l < 0) {
                    // 추적 중인 문서의 우선순위가 가장 높으면서 현재 위치가 0보다 작아졌다는 것은 큐에서 빠져나왔다는것
                    break;
                }
            } else {
                // 문서의 우선순위가 가장 높지 않으면 다시 큐에 집어넣는다.
                printQueue.add(item);
                l--;
                if (l < 0) {
                    // 추적 중인 문서가 남아 있는 문서들보다 우선순위가 높지 않으면서 현재 위치가 0보다 작아졌다는 것은 큐의 맨 뒤로 이동했다는것
                    l = printQueue.size() - 1;
                }
            }
        }

        return answer;
    }

}
