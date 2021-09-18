package Programmers;

import java.util.Scanner;

public class RectangleWithStar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int b1 = 0 ; b1 < b ; ++b1)
        {
            for(int a1 = 0; a1 < a ; ++a1)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
