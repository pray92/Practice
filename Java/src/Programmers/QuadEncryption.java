package Programmers;

// 22:07 ~ 11:20
class QuadEncription {
    // 0,1로 이뤄진 2^n * 2^n 2차원 배열, 쿼드 트리 형식으로 압축
    // S 공간에 숫자가 모두 같으면 해당 수 하나로 압축
    // 그렇지 않으면 S를 균일한 4개의 균일한 정사각형 영역으로 쪼개고 압축 시도
    // 최종적으로 남는 0과 1의 개수를 반환
    public int[] solution(int[][] arr) {
        int ret = getEncriptResult(arr, 0, arr.length, 0, arr[0].length);
        if(ret == 1){
            return new int[]{0, 1};
        } else if(ret == 0){
            return new int[
            private int[] getResult(int[][] arr, int startY, int endY, int startX, int endX){
                if(startY > endY || startX > endX){
                    return new int[]{0 ,0};
                }

                int ret = getEncriptResult(arr, startY, endY, startX, endX);
                if(ret == 1){
                    return new int[]{0, 1};
                } else if(ret == 0){
                    return new int[]{1, 0};
                }

                int[] next = new int[2];
                next = getResult(arr, startY, (endY + startY) / 2, startX, (endX + startX) / 2);
                next = addArray(next, getResult(arr, startY, (endY + startY) / 2, (startX + endX) / 2, endX));
                next = addArray(next, getResult(arr, (endY + startY) / 2, endY, startX, (startX + endX) / 2));
                next = addArray(next, getResult(arr, (endY + startY) / 2, endY, (startX + endX) / 2, endX));
                return next;
            }]{1, 0};
        }
        int[] answer = new int[2];
        int startY = 0, endY = arr.length;
        int startX = 0, endX = arr[0].length;
        answer = getResult(arr, startY, endY / 2, startX, endX / 2);
        answer = addArray(answer, getResult(arr, startY, endY / 2, endX / 2, endX));
        answer = addArray(answer, getResult(arr, endY / 2, endY, startX, endX / 2));
        answer = addArray(answer, getResult(arr, endY / 2, endY, endX / 2, endX));

        return answer;
    }


    private int[] addArray(int[] arr1, int[] arr2){
        int[] ret = new int[2];
        ret[0] = arr1[0] + arr2[0];
        ret[1] = arr1[1] + arr2[1];
        return ret;
    }

    private int getEncriptResult(int[][]arr, int startY, int endY, int startX, int endX){
        if(startY > endY || startX > endX){
            return -1;
        }
        int ret = arr[startY][startX];
        for(int y = startY; y < endY; ++y){
            for(int x = startX; x < endX; ++x){
                if(ret != arr[y][x]){
                    return -1;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args){
        new QuadEncription().solution(new int[][]{
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1},
        });
    }
}