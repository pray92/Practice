package Baekjoon.SolvedAC.Silver3;

import java.util.Scanner;

public class YoungPrince {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseCount = sc.nextInt();
        for(int t = 0; t < caseCount; ++t) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int planetCount = sc.nextInt();
            
            int[][] planetInfo = new int[planetCount][3];
            for(int i = 0; i < planetCount; ++i) {
                planetInfo[i][0] = sc.nextInt();
                planetInfo[i][1] = sc.nextInt();
                planetInfo[i][2] = sc.nextInt();
            }

            // 진입 개수 = 도착지가 포함된 경계
            // 이탈 개수 = 출발지가 포함된 경계
            // 그리고 출발지가 도착지가 서로 다른 경계에 존재하는 경우
            int ret = 0;
            for(int i = 0 ; i < planetCount; ++i) {
                if(Math.pow(x2 - planetInfo[i][0], 2) + Math.pow(y2 - planetInfo[i][1], 2) < Math.pow(planetInfo[i][2], 2)){
                    if(Math.pow(x1 - planetInfo[i][0], 2) + Math.pow(y1 - planetInfo[i][1], 2) > Math.pow(planetInfo[i][2], 2)){
                        ++ret;
                    }
                } else if(Math.pow(x1 - planetInfo[i][0], 2) + Math.pow(y1 - planetInfo[i][1], 2) < Math.pow(planetInfo[i][2], 2)){
                    if(Math.pow(x2 - planetInfo[i][0], 2) + Math.pow(y2 - planetInfo[i][1], 2) > Math.pow(planetInfo[i][2], 2)){
                        ++ret;
                    }
                }
            }


            System.out.println("" + ret);
        }
    }
}
