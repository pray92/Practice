package Programmers;

import java.util.Queue;
import java.util.LinkedList;

public class SplitNetwork {
    public int solution(int n, int[][] wires) {
        int answer = n;

        boolean[][] network = new boolean[n + 1][n + 1];
        for(var wire : wires){
            network[wire[0]][wire[1]] = true;
            network[wire[1]][wire[0]] = true;
        }

        for(var excludeWire : wires){
            answer = Math.min(answer, getGap(n, network, excludeWire)); 
        }

        return answer;
    }

    private int getGap(int n, boolean[][] network, int[] excludeWire){
        network[excludeWire[0]][excludeWire[1]] = false;
        network[excludeWire[1]][excludeWire[0]] = false;

        int ret = Math.abs(getNodeCnt(n, network, excludeWire[0]) - getNodeCnt(n, network, excludeWire[1]));

        network[excludeWire[0]][excludeWire[1]] = true;
        network[excludeWire[1]][excludeWire[0]] = true;

        return ret;
    }

    private int getNodeCnt(int n, boolean[][] network, int startNode){
        int ret = 1;

        boolean[] done = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(startNode);
        done[startNode] = true;
        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int i = 0 ; i <= n ; ++i){
                if(false == done[i] && network[node][i]){
                    queue.add(i);
                    done[i] = true;
                    ++ret;
                }
            }
        }

        return ret;
    }

    public static void main(String[] args){
        System.out.println(new SplitNetwork().solution(9, new int[][]{
            new int[]{1,3},
            new int[]{2,3},
            new int[]{3,4},
            new int[]{4,5},
            new int[]{4,6},
            new int[]{4,7},
            new int[]{7,8},
            new int[]{7,9}
        }));
    }
}
