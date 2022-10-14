package Baekjoon.SolvedAC.Silver3;

import java.util.LinkedList;
import java.util.Scanner;

public class RotatingQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[] goals = new int[M];
        for(int i = 0 ; i < M ; ++i) {
            goals[i] = sc.nextInt();
        }

        LinkedList<Integer> deque = new LinkedList<Integer>();
        for(int i = 1; i <= N ; ++i) {
            deque.add(i);
        }

        int ret = 0;
        for(final int goal : goals) {
            int position = deque.indexOf(goal);
            if(position == 0) {
                deque.pollFirst();
            } else {
                if(position <= deque.size() - position) {
                    for(int i = 0; i < position; ++i) {
                        ++ret;
                        deque.add(deque.pollFirst());
                    }
                    deque.pollFirst();
                } else {
                    for(int i = 0; i < deque.size() - position; ++i) {
                        ++ret;
                        deque.addFirst( deque.pollLast());
                    }
                    deque.pollFirst();
                }
            }
        }
        System.out.println(ret);
    }
}
