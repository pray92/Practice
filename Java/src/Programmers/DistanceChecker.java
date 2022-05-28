package Programmers;

import java.util.ArrayList;
import java.util.List;

// 1. 대기실은 5개이며, 각 대기실은 5x5 크기입니다.
// 2. 거리두기를 위하여 응시자들 끼리는 맨해튼 거리1가 2 이하로 앉지 말아 주세요.
// 3. 단 응시자가 앉아있는 자리 사이가 파티션으로 막혀 있을 경우에는 허용합니다.
// 4. 응시자 P, 빈 테이블 O, 파티션 X
public class DistanceChecker {
    private static int TILE_SIZE = 5;
    private static char PEOPLE = 'P';
    private static char PARTITION = 'X';
    private static char TABLE = 'O';

    private class Point {
        public final int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int index = 0; index < places.length; ++index) {
            String[] place = places[index];
            answer[index] = (isRightPlace(place)) ? 1 : 0;
        }

        return answer;
    }

    private boolean isRightPlace(String[] place) {
        List<Point> people = getPeoples(place);
        for(int index = 0; index < people.size(); ++index){
            Point person1 = people.get(index);
            for(int index2 = index + 1; index2 < people.size(); ++index2){
                Point person2 = people.get(index2);
                if(2 < getdistance(person1.y, person1.x, person2.y, person2.x)){
                    continue;
                }

                if(isBlocked(place, person1.y, person1.x, person2.y, person2.x)){
                    continue;
                }
                
                return false;
            }
        }

        return true;
    }

    private List<Point> getPeoples(String[] place) {
        List<Point> ret = new ArrayList<Point>();

        for (int y = 0; y < place.length; ++y) {
            for (int x = 0; x < TILE_SIZE; ++x) {
                if (place[y].charAt(x) == PEOPLE) {
                    ret.add(new Point(y, x));
                }
            }
        }

        return ret;
    }

    private int getdistance(int y1, int x1, int y2, int x2) {
        return Math.abs(y1 - y2) + Math.abs(x1 - x2);
    }

    // NOTE : 거리가 2이하라면 두 사이간의 타일 크기도 2 X 2입니다.
    // P가 있는 곳을 제외한 위치에 X가 둘 다 있으면 true를 반환합니다.
    private boolean isBlocked(String[] place, int y1, int x1, int y2, int x2) {
        if(y1 == y2 && x1 == x2){
            return false;
        }
        if(y1 == y2){
            return (place[y1].charAt((x1 + x2) >> 1) == PARTITION);
        }
        if(x1 == x2){
            return (place[(y1 + y2) >> 1].charAt(x1) == PARTITION);
        }

        char tile1 = place[y1].charAt(x2);
        char tile2 = place[y2].charAt(x1);
        return (tile1 == PARTITION) && (tile2 == PARTITION);
    }
}
