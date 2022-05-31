package HackerRanks;

import java.util.List;

public class BubbleSort {

    private static String SORTED_IN_N_SWAPS = "Array is sorted in %d swaps.\n";
    private static String FIRST_ELEMENT = "First Element: %d\n";
    private static String LAST_ELEMENT = "Last Element: %d\n";

    public static void countSwaps(List<Integer> a) {
        int count = 0;
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size() - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a.get(j) > a.get(j + 1)) {
                    swap(a, j, j + 1);
                    ++count;
                }
            }
            
        }

        System.out.printf(SORTED_IN_N_SWAPS, count);
        System.out.printf(FIRST_ELEMENT, a.get(0));
        System.out.printf(LAST_ELEMENT, a.get(a.size() - 1));
    }

    private static void swap(List<Integer> a, int from, int to) {
        int tmp = a.get(from);
        a.set(from, a.get(to));
        a.set(to, tmp);
    }
    
}
