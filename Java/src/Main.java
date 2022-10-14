
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Action;

public class Main
{
    public static void main(String[] args)  throws Exception {
	}

    private static void arrayListLinkedListTest(){
        // 추가할 데이터의 개수를 고려하여 충분히 잡음
        ArrayList a1 = new ArrayList(2000000);
        LinkedList l1 = new LinkedList();

        System.out.println("=순차적으로 추가하기=");
        System.out.println("ArrayList : " + add1(a1));
        System.out.println("LinkedList : " + add1(l1));
        System.out.println();
        System.out.println("=중간에 추가하기=");
        System.out.println("ArrayList : " + add2(a1));
        System.out.println("LinkedList : " + add2(l1));
        System.out.println();
        System.out.println("=중간에 삭제하기=");
        System.out.println("ArrayList : " + remove2(a1));
        System.out.println("LinkedList : " + remove2(l1));
        System.out.println();
        System.out.println("=순차적으로 삭제하기=");
        System.out.println("ArrayList : " + remove1(a1));
        System.out.println("LinkedList : " + remove1(l1));
        System.out.println();
    }

    private static long add1(List list){
        long start = System.currentTimeMillis();
        for(int i = 0; i < 1000000; ++i) list.add(i+"");
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long add2(List list){
        long start = System.currentTimeMillis();
        for(int i = 0; i < 10000; ++i) list.add(500, "X");
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long remove1(List list){
        long start = System.currentTimeMillis();
        for(int i = list.size() - 1; i >= 0; --i) list.remove(i);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long remove2(List list){
        long start = System.currentTimeMillis();
        for(int i = 0; i < 10000; ++i) list.remove(i);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static void collectionsEx(){
        List list1 = new ArrayList<>(10);
        list1.add(new Integer(5));
        list1.add(new Integer(4));
        list1.add(new Integer(2));
        list1.add(new Integer(0));
        list1.add(new Integer(1));
        list1.add(new Integer(3));

        ArrayList list2 = new ArrayList(list1.subList(1, 4));
        print(list1, list2);

        Collections.sort(list1);
        Collections.sort(list2);
        print(list1, list2);

        System.out.println("list1.contatinsAll(list2) : " + list1.containsAll(list2));

        list2.add('B');
        list2.add('C');
        list2.set(3, "A");
        print(list1, list2);

        list2.set(3, "AA");
        print(list1, list2);

        // list1에서 list2와 겹치는 부분을 제외하고 나머지는 삭제
        System.out.println("list1.retatinAll(list2) : " + list1.retainAll(list2));
        print(list1, list2);

        // list2에서 list1에 포함된 객체들을 삭제한다.
        for(int i = list2.size() - 1; i >= 0; --i){
            if(list1.contains(list2.get(i)))
                list2.remove(i);
        }
        print(list1, list2);
    }

    private static void print(List list1, List list2){
        System.out.println("list1 : " + list1);
        System.out.println("list2 : " + list2);
        System.out.println();
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
}
