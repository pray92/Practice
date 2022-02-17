package Programmers;

import java.util.ArrayList;
import java.util.List;

// 14:40
public class MenuRenual {

    private boolean[][] orderInfo = null;

    public String[] solution(String[] orders, int[] course) {

        List<String> answer = new ArrayList<>();

        orderInfo = new boolean[orders.length]['Z' + 1];
        for(int i = 0; i < orders.length; ++i){
            for(int j = 0; j < orders[i].length(); ++j){
                orderInfo[i][orders[i].charAt(j)] = true;
            }
        }

        for(int count : course){
            List<StringBuilder> maxOrder = new ArrayList<>();
            for(int nMenuIndex = 'A'; nMenuIndex <= 'Z' - count + 1; ++nMenuIndex){
                StringBuilder sb = new StringBuilder();
                sb.append((char)nMenuIndex);
                checkCourse(count, maxOrder, sb, nMenuIndex);
            }
            for(StringBuilder sb : maxOrder){
                answer.add(sb.toString());
            }
        }
        answer.sort((x, y) -> x.compareTo(y));
        return answer.toArray(new String[0]);
    }

    private void checkCourse(int courseCount, List<StringBuilder> maxOrders, StringBuilder order, int curIndex) {
        if (order.length() >= courseCount) {
            int maxOrderCnt = getOrderedCount((maxOrders.size() <= 0) ? new StringBuilder() : maxOrders.get(0));
            int orderCnt = getOrderedCount(order);
            if(orderCnt < 2)
                return;

            if(maxOrderCnt < orderCnt){
                maxOrders.clear();
                maxOrders.add(new StringBuilder(order));
            } else if(orderCnt > 0 && maxOrderCnt == orderCnt){
                maxOrders.add(new StringBuilder(order));
            }

            return;
        }

        for (int i = curIndex + 1; i <= 'Z'; ++i) {
            order.append((char) i);
            checkCourse(courseCount, maxOrders, order, i);
            order.setLength(order.length() - 1);
        }
    }

    private int getOrderedCount(StringBuilder order){
        if(order.length() <= 0)
            return 0;

        int ret = 0;

        for(boolean[] customerInfo : orderInfo){
            boolean isOrdered = true;
            for(int i = 0; i < order.length(); ++i){
                char menu = order.charAt(i);
                if(!customerInfo[menu]){
                    isOrdered = false;
                    break;
                }
            }
            if(isOrdered) {
                ++ret;
            }
        }
        return ret;
    }

    public static void main(String[] args){
        new MenuRenual().solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});

    }
}
