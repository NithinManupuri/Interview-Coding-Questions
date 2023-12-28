package Ibm;

import java.util.Arrays;

public class RangeSamples {
    public static void main(String[] args) {

        int n = 10;
        int r = 2;

        int[] samples = {345, 604, 321, 433, 704, 470, 808, 718, 517, 811};
        Arrays.sort(samples);


        System.out.println("Output:");
        for (int i = 0; i < r; i++) {
            int min, max;

            // Assign values for the ranges
            if (i == 0) {
                min = 300;
                max = 350;
            } else {
                min = 400;
                max = 700;
            }

            int count = findRangeCount(samples, min, max);
            System.out.print(count + " ");
        }
    }

    public static int findRangeCount(int[] samples, int min, int max) {
        int minIndex = findIndex(samples, min, false);
        int maxIndex = findIndex(samples, max, true);

        return maxIndex - minIndex;
    }

    public static int findIndex(int[] nums, int target, boolean isMax) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                if (isMax) {
                    if (mid < end && nums[mid + 1] == target) {
                        start = mid + 1;
                    } else {
                        return mid;
                    }
                } else {
                    if (mid > start && nums[mid - 1] == target) {
                        end = mid - 1;
                    } else {
                        return mid;
                    }
                }
            }
        }

        return end;
    }
}
