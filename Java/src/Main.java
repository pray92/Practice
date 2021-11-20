import Utils.Util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Utils.Util.*;

class Circle implements Cloneable{
    Point p;
    double r;

    Circle(Point p, double r){
        this.p = p;
        this.r = r;
    }

    public Circle shallowCopy(){
        Object obj = null;

        try{
            obj = super.clone();
        } catch (CloneNotSupportedException e) { }

        return (Circle)obj;
    }

    public Circle deepCopy(){
        Object obj = null;

        try{
            obj = super.clone();
        } catch (CloneNotSupportedException e) { }

        Circle c = (Circle)obj;
        c.p = new Point(this.p.x, this.p.y);

        return c;
    }

    public String toSTr(){
        return "[p=" + p + ", r=" + r + "]";
    }
}

class Point{
    int x = 0;
    int y = 0;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toStr(){
        return "(" + x + ", " + y + ")";
    }
}

public class Main
{
    public static void main(String[] args)  throws Exception {
        int[] arr = new int[]{20, 333, 242, 52, 1, 233, 24, 4, 9, 67, 8, 4, 5};
        RadixSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void swap(int[] arr, int from, int to){
        int tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }

    private static void regularEx2() {
        String[] data = {"bat", "baby", "bonus", "c", "cA", "ca", "co",
                        "c.", "c0", "c#", "car", "combat", "count", "date", "disc"} ;

        String[] pattern = {".*", "c[a-z]*", "c[a-z]", "c[a-zA-Z]",
                            "c[a-zA-Z0-9]", "c.", "c.*", "c\\.", "c\\w", "c\\d",
                            "c.*t", "[b|c].*", ".*a.*", ".*a.+", "[b|c].{2}"};

        for(int x = 0; x < pattern.length; ++x){
            Pattern p = Pattern.compile(pattern[x]);
            System.out.print("Pattern : " + pattern[x] + " 결과 : ");
            for(int i = 0; i < data.length; ++i) {
                Matcher m = p.matcher(data[i]);
                if (m.matches())
                    System.out.print(data[i] + ",");
            }
            System.out.println();
        }

    }

    private static void StringEx5() throws Exception {
        String str = "가";

        byte[] bArr = str.getBytes("UTF-8");
        byte[] bArr2 = str.getBytes("CP949");

        System.out.println("UTF-8 : " + joinByteArr(bArr));
        System.out.println("CP949 : " + joinByteArr(bArr2));

        System.out.println("UTF-8 : " + new String(bArr, "UTF-8"));
        System.out.println("CP949 : " + new String(bArr2, "CP949"));
    }

    private static String joinByteArr(byte[] bArr) {
        StringJoiner sj = new StringJoiner(":", "[", "]");

        for(byte b : bArr){
            sj.add(String.format("%02X",b));
        }
        return sj.toString();
    }

    public static void PrintfEx1()
    {
        byte b = 1;
        short s = 2;
        char c = 'A';

        int finger = 10;
        long big = 100_000_000_000L;
        long hex = 0xFFFF_FFFF_FFFF_FFFFL;

        int octNum = 010;   // 8진수 10, 10진수로는 8
        int hexNum = 0x10;  // 16진수 10, 10진수로는 16
        int binNum = 0b10;  // 2진수 10, 10진수로는 2

        System.out.printf("b=%d%n", b);
        System.out.printf("s=%d%n", s);
        System.out.printf("c=%c, %d%n", c, (int)c);
        System.out.printf("finger=[%5d]%n", finger);
        System.out.printf("finger=[%-5d]%n", finger);
        System.out.printf("finger=[%05d]%n", finger);
        System.out.printf("big=%d%n", big);
        System.out.printf("hex=%#x%n", hex);        // '#'은 접두사(16진수 0x, 8진수 0)
        System.out.printf("octNum=%o, %d%n", octNum, octNum);
        System.out.printf("hexNum=%o, %d%n", hexNum, hexNum);
        System.out.printf("binNum=%s, %d%n", Integer.toBinaryString(binNum), binNum);

    }

    private static void shallowDeepCopy() {
        Circle c1 = new Circle(new Point(1, 1), 2.0);
        Circle c2 = c1.shallowCopy();
        Circle c3 = c1.deepCopy();

        System.out.println("c1=" + c1);
        System.out.println("c2=" + c2);
        System.out.println("c3=" + c3);

        c1.p.x = 9;
        c1.p.y = 9;
        System.out.println("= c1의 변경 후 =");
        System.out.println("c1=" + c1);
        System.out.println("c2=" + c2);
        System.out.println("c3=" + c3);
    }
}
