package Baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoteControl {
    private static boolean[] broken = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strDestChannel = br.readLine();
        String strCurChannel = "100";

        int dest = Integer.parseInt(strDestChannel);
        int answer = Math.abs(dest - Integer.parseInt(strCurChannel));

        int brokenCnt = Integer.parseInt(br.readLine());
        if(0 < brokenCnt) {
            String[] strBrokens = br.readLine().split(" ");
            for(String strBroken : strBrokens) {
                broken[strBroken.charAt(0) - '0'] = true;
            }

            for(int channel = 0; channel <= 999_999; ++channel) {
                if(!isChannable(channel)) {
                    continue;
                }
                answer = Math.min(answer, String.valueOf(channel).length() + Math.abs(channel - dest));
            }
        } else {
            answer = Math.min(answer, strDestChannel.length());
        }

        System.out.println(answer);
    }

    private static boolean isChannable(int channel) {
        String strChannel = String.valueOf(channel);
        for(int i = 0; i < strChannel.length(); ++i) {
            if(broken[ strChannel.charAt(i) - '0']) {
                return false;
            }
        }
        return true;
    }

}
