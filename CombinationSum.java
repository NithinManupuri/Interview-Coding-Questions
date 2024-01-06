package Ibm;

import java.util.ArrayList;
import java.util.List;

    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> list=new ArrayList<>();
            combinationSum(candidates,target,0,list,new ArrayList<Integer>());
            return list;
        }
        private void combinationSum(int[] candidates, int target, int index, List<List<Integer>> list, ArrayList<Integer> arr) {
            if (index == candidates.length) {
                if (target == 0) {
                    list.add(new ArrayList<>(arr));
                }
                return;
            }

            if (candidates[index] <= target) {
                arr.add(candidates[index]);
                combinationSum(candidates, target - candidates[index], index, list, arr);
                arr.remove(arr.size() - 1);
            }

            combinationSum(candidates, target, index + 1, list, arr);
        }
    }

}
