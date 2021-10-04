package LeetCode;

// 16: 28 ~ 16:50
public class ContainerWithMostWater {

/*    public int maxArea(int[] height) {
        if(height.length <= 2){
            return (height[0] < height[1]) ? height[0] : height[1];
        }

        int answer = 0;

        for(int nLeft = 0; nLeft < height.length - 1; ++nLeft){
            int nRight = height.length - 1;
            while(nLeft < nRight){
                int nOffset = (height[nLeft] < height[nRight]) ? height[nLeft] : height[nRight];
                int nValue = nOffset * (nRight - nLeft);
                if(answer < nValue)
                    answer = nValue;

                --nRight;
            }
        }

        return answer;
    }*/

    public int maxArea(int[] height) {
        if(height.length <= 2){
            return (height[0] < height[1]) ? height[0] : height[1];
        }

        int answer = 0;

        int nLeft = 0, nRight = height.length - 1;
        while(nLeft < nRight){
            final int lValue = height[nLeft];
            final int rValue = height[nRight];

            int nOffset = (lValue < rValue) ? lValue : rValue;
            int nValue =  nOffset * (nRight - nLeft);
            if(answer < nValue)
                answer = nValue;

            if(lValue < rValue)
                ++nLeft;
            else
                --nRight;
        }


        return answer;
    }

    public void main(String[] args){
        var ans = new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(ans);
    }
}
