package Ibm;

import java.util.Arrays;

public class QueriesForCount {
    public static void main(String[] args) {
        int[] nums = {345, 604, 321, 433, 704, 470, 808, 718, 517, 811};
        Arrays.sort(nums);
        int left = countQueries(nums, 3, false);
        int right = countQueries(nums, 9, true);

        int values = right - left+1;
        System.out.print(values);
    }

    public static int countQueries(int[] nums, int target, boolean b) {
        int start = 0;
        int ans=-1;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                if (b) {
                    if (mid < end && nums[mid + 1] == target) {
                        start = mid + 1;
                    }else{
                        return mid;
                    }
                } else {

                    if (mid > start && nums[mid - 1] == target) {
                        end = mid - 1;
                    }else{
                        return mid;
                    }
                }
            }
        }

        return end;
    }
}
