package Utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 각종 사용하기 유용한 함수들을 리스트로 담음
 * 1. 소수 판별
 * 2. 최대 공약수/최소 공배수
 * 3. 실수 값 Equal
 */
public class Util {

    public static void swap(int[] arr, int from, int to){
        int tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }

    /**
     * 소수 여부를 판별합니다.
     * @param number
     * @return true if number is prime
     */
    public static boolean IsPrime(long number){
        if(number <= 2L) return false;
        for(long i = 2L; i <= (long)Math.sqrt(number) ; ++i){
            if(number % i == 0)
                return false;
        }
        return true;
    }

    /**
     * 두 수의 최대 공약수를 반환합니다
     * @param a
     * @param b
     * @return gcd of a & b
     */
    public static long gcd(int a, int b){
        while(b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return Math.abs(a);
    }

    /**
     * 두 수의 최소 공배수를 반환합니다.
     * @param a
     * @param b
     * @return lcm of a & b
     */
    public static long lcm(int a, int b){
        return (a * (long)b) / gcd(a, b);
    }

    /**
     * 두 실수가 기준 값보다 차가 적은지 확인
     * 근사값 이슈로 인한 함수
     * @param a
     * @param b
     * @return
     */
    public static boolean absoluteEqual(double a, double b){
        final double LIMIT = 1e-10;
        return Math.abs(a - b) < LIMIT;
    }

    public static void mergeSort(int[] arr){

        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int start, int end){
        if(start < end){
            int mid = (start + end) >>> 1;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, end);
        }
    }

    private static void merge(int[] arr, int start, int end){
        int[] lArr = Arrays.copyOfRange(arr, start, ((start + end) >>> 1) + 1);
        int[] rArr = Arrays.copyOfRange(arr, ((start + end) >>> 1) + 1, end + 1);
        int ll = lArr.length;
        int rl = rArr.length;
        int i = 0, j = 0;
        int k = start;
        while(i < ll && j < rl){
            if(lArr[i] <= rArr[j]) arr[k++] = lArr[i++];
            else arr[k++] = rArr[j++];
        }
        while (i < ll) arr[k++] = lArr[i++];
        while (j < rl) arr[k++] = rArr[j++];
    }


    public static void quickSort(int[] arr){
        if(arr.length <= 1)
            return;

        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end){
        if(start >= end)
            return;

        int pivot = start;
        int left = start + 1;
        int right = end;
        while(left <= right){
            while(left <= end && arr[pivot] >= arr[left]) ++left;
            while(right > start && arr[pivot] < arr[right]) --right;

            if(left < right){
                swap(arr, left, right);
            }else{
                swap(arr, pivot, right);
            }
        }
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }

    public static void heapSort(int[] arr){
        int n = arr.length;

        // Heap 재구성
        for(int i = n / 2 - 1; i >= 0; --i)
            heapify(arr, n, i);

        // 최대 힙으로 구성
        for(int i = n - 1; i > 0; --i){
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i){
        int parent = i;
        int lChild = 2 * i + 1;
        int rChild = 2 * i + 2;

        if(lChild < n && arr[parent] < arr[lChild]) parent = lChild;
        if(rChild < n && arr[parent] < arr[rChild]) parent = rChild;

        if(parent != i){
            int tmp = arr[i];
            arr[i] = arr[parent];
            arr[parent] = tmp;

            heapify(arr, n, parent);
        }
    }

    public static void main(String[] args){
        int[] arr = {8, 2, 1, 8, 11, 2, 33, 45};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
