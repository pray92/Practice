package HackerRanks;

import java.util.List;

import Utils.TestUtils;

public class FraudulentActivityNotifications {

    private static int[] arrCounts = new int[201];

    // d일을 나눠서 {d일 지출 mean} * 2 <= 내일 지출
    public static int activityNotifications(List<Integer> expenditure, int d) {
        int ret = 0;

        for(int day = 0; day < d; ++day) {
            ++arrCounts[expenditure.get(day)];
        }

        for(int day = d; day < expenditure.size(); ++day){
            if(isAlert(d, expenditure.get(day))){
                ++ret;
            }

            --arrCounts[expenditure.get(day - d)];
            ++arrCounts[expenditure.get(day)];
        }

        return ret;
    }

    private static boolean isAlert(int d, int expenditure) {
        double ret = 0.0;

        int countSum = 0;
        if(d % 2 == 0) {    
            int first = 0, second = 0;
            for(int money = 0; money < arrCounts.length; ++money) {
                countSum += arrCounts[money];
                if(first == 0 && countSum >= d / 2){
                    first = money;
                }
                if(second == 0 && countSum >= d / 2 + 1){
                    second = money;
                    break;
                }
            }
            ret = (first + second) / 2.0;

        } else {
            for(int money = 0; money < arrCounts.length; ++money) {
                countSum += arrCounts[money];
                if(countSum > d / 2) {
                    ret = money;
                    break;
                }   
            }
        }

        return ret * 2 <= expenditure;
    }

    public static void main(String[] args) {
        new FraudulentActivityNotifications().activityNotifications(TestUtils.toList(2, 3, 4, 2, 3, 6, 8, 4, 5), 5);
    }
}
