package LeetCode;

import java.util.Arrays;
import java.util.Collections;

// 21:40
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // 1. 역순으로 검색해 최초의 인접 원소의 오름차순 위치를 찾습니다.
        int i = nums.length - 2;
        while((i >= 0) && nums[i] >= nums[i + 1]){
            --i;
        }

        if(0 <= i){
            // 2. 역순으로 검색해 i번째 원소보다 큰 값을 찾음
            int j = nums.length - 1;
            while(nums[i] >= nums[j]){
                --j;
            }
            swap(nums, i, j);
        }
        // 3. 마지막으로 i + 1부분부터 역전
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start){
        int i = start;
        int j = nums.length - 1;
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int index1, int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args){
        new NextPermutation().nextPermutation(new int[]{1, 2});
    }

}
