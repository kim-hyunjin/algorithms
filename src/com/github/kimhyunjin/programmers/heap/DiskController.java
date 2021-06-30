package com.github.kimhyunjin.programmers.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다.
 * 디스크 컨트롤러를 구현하는 방법은 여러 가지가 있습니다.
 * 가장 일반적인 방법은 요청이 들어온 순서대로 처리하는 것입니다.
 * <p>
 * 각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때,
 * 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 return 하도록 solution 함수를 작성해주세요. (단, 소수점 이하의 수는 버립니다)
 * <p>
 * [제한 사항]
 * jobs의 길이는 1 이상 500 이하입니다.
 * jobs의 각 행은 하나의 작업에 대한 [작업이 요청되는 시점, 작업의 소요시간] 입니다.
 * 각 작업에 대해 작업이 요청되는 시간은 0 이상 1,000 이하입니다.
 * 각 작업에 대해 작업의 소요시간은 1 이상 1,000 이하입니다.
 * 하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다.
 */
public class DiskController {

    public static class Job implements Comparable<Job> {
        public int id;
        public int requestTime;
        public int needTime;
        public int processedTime;

        public Job(int id, int requestTime, int processTime) {
            this.id = id;
            this.requestTime = requestTime;
            this.needTime = processTime;
        }

        public void setProcessedTime(int finishTime) {
            this.processedTime = finishTime - requestTime;
        }

        @Override
        public int compareTo(Job o) {
            if (this.needTime < o.needTime) return -1;
            else if (this.needTime > o.needTime) return 1;
            else return 0;
        }
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        List<Job> list = new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) {
            int requestTime = jobs[i][0];
            int needTime = jobs[i][1];
            list.add(new Job(i, requestTime, needTime));
        }
        list.sort((o1, o2) -> {
            if (o1.requestTime < o2.requestTime) return -1;
            else if (o1.requestTime > o2.requestTime) return 1;
            else return 0;
        });
        int presentTime = 0;
        Job firstJob = list.remove(0);


        PriorityQueue<Job> heap = new PriorityQueue<>();


        while(!heap.isEmpty()) {
            Job job = heap.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int expected = 9;
        int result = solution(jobs);

        if (result == expected) {
            System.out.println("Correct!");
        } else {
            System.out.println("Wrong...");
        }

    }
}
