package Ibm;

import java.util.Arrays;
import java.util.HashMap;

public class CountSort {

    public void countsort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }
        int max = arr[0];
        for (int n : arr) {
            if (n > max) {
                max = n;
            }
        }
        int[] countArray = new int[max + 1];
        for (int n : arr) {
            countArray[n]++;
        }
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (countArray[i] > 0) {
                arr[index] = i;
                countArray[i]--;
                index++;
            }
        }

    }

    public void hashmapSort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int index = 0;
        for (int i = min; i < max; i++) {
            int count = map.getOrDefault(i, 0);

            while (count > 0) {
                arr[index] = i;
                count--;
                index++;

            }
        }
    }

    public static void main(String[] args){
        int[] arr={3,2,2,3,5,4,1,4,9};
        CountSort cs=new CountSort();
        cs.countsort(arr);
        cs.hashmapSort(arr);
        System.out.print(Arrays.toString(arr));


    }
}
