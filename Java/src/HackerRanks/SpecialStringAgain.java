package HackerRanks;

import java.util.List;
import java.util.ArrayList;

public class SpecialStringAgain {

    static long substrCount(int n, String s) {
        class CharInfo {
            public final char value;
            public final int count;

            public CharInfo(char value, int count) {
                this.value = value;
                this.count = count;
            }
        }
        List<CharInfo> list = new ArrayList<CharInfo>();

        char value = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (value != s.charAt(i)) {
                list.add(new CharInfo(value, count));

                value = s.charAt(i);
                count = 1;
            } else {
                ++count;
            }
        }
        list.add(new CharInfo(value, count));

        long answer = 0L;

        for (int i = 0; i < list.size(); ++i) {
            CharInfo info = list.get(i);
            answer += (info.count * (info.count + 1)) >> 1;
        }

        for (int i = 1; i < list.size() - 1; ++i) {
            if ((list.get(i - 1).value == list.get(i + 1).value)
                    && list.get(i).count == 1) {
                answer += Math.min(list.get(i - 1).count, list.get(i + 1).count);
            }
        }

        return answer;
    }

}