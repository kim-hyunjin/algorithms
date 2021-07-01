package com.github.kimhyunjin.programmers.heap;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.
 * 명령어	수신 탑(높이)
 * I 숫자	큐에 주어진 숫자를 삽입합니다.
 * D 1	    큐에서 최댓값을 삭제합니다.
 * D -1	    큐에서 최솟값을 삭제합니다.
 * 이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
 *
 * [제한사항]
 * operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
 * operations의 원소는 큐가 수행할 연산을 나타냅니다.
 * 원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
 * 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.
 */
public class DoublePriorityQueue {
    public static int[] solution(String[] operations) {
        MyHeap heap = new MyHeap();
        for(String op : operations) {
            if (op.startsWith("I")) {
                int newValue = Integer.parseInt(op.split("I ")[1]);
                heap.add(newValue);
            } else if (op.startsWith("D")) {
                if (heap.isEmpty()) {
                    continue;
                }
                int op2 = Integer.parseInt(op.split("D ")[1]);
                if (op2 < 0) {
                    heap.pollMin();
                } else {
                    heap.pollMax();
                }
            }
        }
        if (heap.isEmpty()) {
            return new int[]{0, 0};
        } else {
            int maxValue = heap.pollMax();
            int minValue = 0;
            if (heap.isEmpty()) {
                minValue = maxValue;
            } else {
                minValue = heap.pollMin();
            }
            return new int[]{maxValue, minValue};
        }

    }

    public static void main(String[] args) {
//        String[] operations = {"I 16","D 1"};
//        int[] expected = {0, 0};
//        if (Arrays.equals(solution(operations), expected)) {
//            System.out.println("Correct!");
//        } else {
//            System.out.println("Wrong...");
//        }

        MyHeap heap = new MyHeap();
        heap.add(1);
        heap.add(23);
        heap.add(3);
        heap.add(2);
        heap.add(10);
        heap.add(32);
        heap.add(9);
        heap.add(9);
        for (int i = 0; i < heap.size(); i++) {
            System.out.println("list: " + heap);
            System.out.println("MIN " + heap.pollMin());
            System.out.println("MAX " + heap.pollMax());
        }
    }

    static class MyHeap {
        ArrayList<Integer> list = new ArrayList<>();

        void add(Integer newValue) {
            list.add(newValue);
            list.sort(Integer::compare);
        }

        int pollMin() {
            return list.remove(0);
        }

        int pollMax() {
            return list.remove(list.size() - 1);
        }

        int size() {
            return list.size();
        }

        boolean isEmpty() {
            return list.isEmpty();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (Integer value : list) {
                sb.append(value);
                sb.append(",");
            }
            sb.append("]");
            return sb.toString();
        }

//        private void shiftUp() {
//            int index = minHeap.size() - 1;
//            while (index < 1) {
//                Integer currentNode = minHeap.get(index);
//                int parentIndex = (index - 1) / 2;
//                Integer parentNode = minHeap.get(parentIndex);
//
//                if (parentNode <= currentNode) {
//                    break;
//                }
//
//                minHeap.set(index, parentNode);
//                minHeap.set(parentIndex, currentNode);
//                index = parentIndex;
//            }
//
//            shiftLeaf();
//        }
//
//        private void shiftDown() {
//            int index = 0;
//            int min = index;
//            while (true) {
//                int leftChildIndex = 2 * index + 1;
//                int rightChildIndex = 2 * index + 2;
//                int size = minHeap.size();
//
//
//                if (leftChildIndex < size && minHeap.get(leftChildIndex) < minHeap.get(min)) {
//                    min = leftChildIndex;
//                }
//                if (rightChildIndex < size && minHeap.get(rightChildIndex) < minHeap.get(min)) {
//                    min = rightChildIndex;
//                }
//                if (index == min) {
//                    break;
//                }
//                Integer temp = minHeap.get(index);
//                minHeap.set(index, minHeap.get(min));
//                minHeap.set(min, temp);
//                index = min;
//
//            }
//
//            shiftLeaf();
//        }

//        private void shiftLeaf() {
//            int leafLevel = (int)Math.ceil((Math.log(minHeap.size() + 1) / Math.log(2)));
//            System.out.println("leafLevel: " + leafLevel);
//            if (minHeap.size() < 3) {
//                return;
//            }
//            int index = (int)Math.pow(2, leafLevel - 1) - 1;
//            System.out.println("index " + index);
//            while (index < minHeap.size() - 1) {
//                System.out.println("Shifting leaf...");
//                System.out.println("val1 : " + minHeap.get(index) + " vs " + "val2 : " + minHeap.get(index + 1));
//                if (minHeap.get(index) > minHeap.get(index + 1)) {
//                    Integer temp = minHeap.get(index + 1);
//                    minHeap.set(index + 1, minHeap.get(index));
//                    minHeap.set(index, temp);
//                }
//                index++;
//            }
//            System.out.println(minHeap);
//        }
    }
}
