package LeetCode;

public class TrappingRainingWater {
    public int trap(int[] height) {
        if(height.length <= 1)
            return 0;

        int answer = 0;
        int left = 0, right = height.length - 1;
        int left_max = height[left], right_max = height[right];
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] > left_max){
                    height[left] = left_max;
                } else{
                    answer += (left_max - height[left]);
                }
                ++left;
            } else{
                if(height[right] > right_max){
                    height[right] = right_max;
                } else{
                    answer += (right_max - height[right]);
                }
                --right;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        var ret = new TrappingRainingWater().trap(new int[]{4, 2, 0, 3, 2, 5});
        System.out.println(ret);
    }
}
