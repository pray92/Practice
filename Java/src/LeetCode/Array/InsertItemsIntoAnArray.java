package LeetCode.Array;

import java.util.Arrays;

public class InsertItemsIntoAnArray {
    public static void duplicateZeros(int[] arr) {
        for(int nIndex = 0; nIndex < arr.length; ++nIndex) {
            if(arr[nIndex] == 0){
                for(int nIndex2 = arr.length - 1; nIndex2 > nIndex; --nIndex2){
                    arr[nIndex2] = arr[nIndex2 - 1];
                }
                if(nIndex + 1 < arr.length)
                    arr[nIndex + 1] = 0;
                ++nIndex;
            }
        }
    }

    static void insert(int[] nums, int number, int insertAt){
        for(int nIndex2 = nums.length - 1; nIndex2 > insertAt; --nIndex2){
            nums[nIndex2] = nums[nIndex2 - 1];
        }
        nums[insertAt] = number;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0, i2 = 0; i < nums1.length && i2 < n; ++i){
            if(i >= m && nums1[i] == 0){
                nums1[i] = nums2[i2++];
                continue;
            }

            if(nums1[i] >= nums2[i2]){
                insert(nums1, nums2[i2++], i);
            }
        }
    }

    public static void main(String[] args){
        /*int[] arr = new int[]{0, 0, 0, 0, 0, 0, 0};
        duplicateZeros(arr);
        for (int a : arr)
            System.out.print(a + ", ");
        System.out.println();*/
        merge( new int[]{-1,0,0,0,3,0,0,0,0,0,0}, 5, new int[]{-1,-1,0,0,1,2}, 6);

    }
}
