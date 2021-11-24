package LeetCode;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {

        int ret = nums.length;

        for(int i = 0; i < ret; ){
            if(nums[i] == val){
                for(int j = i + 1; j < nums.length; ++j)
                    nums[j - 1] = nums[j];
                --ret;
            }
            else{
                ++i;
            }
        }

        return ret;
    }

    public static void main(String[] args){
        new RemoveElement().removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
    }
}
