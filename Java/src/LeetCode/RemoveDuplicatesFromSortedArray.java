package LeetCode;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        boolean[] checks = new boolean[201]; /* 0~100 : 양수, 101~200 : 음수 */

        int ret = 0;
        for(int i = 0; i < nums.length; ++i){
            int index = getIndex(nums[i]);
            if(checks[index])
                continue;

            checks[index] = true;
            nums[ret++] = nums[i];
        }
        return ret;
    }

    private int getIndex(int value){
        if(0 <= value)
            return value;
        return 100 - value;
    }

    public static void main(String[] args){
        new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{-2, -1, -1, 0, 1, 1, 2, 2, 3, 4});
    }
}
