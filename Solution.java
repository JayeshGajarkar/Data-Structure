import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static int sum(List<Integer> l) {
        int ans = 0;

        for (int i = 0; i < l.size(); i++) {
            ans += l.get(i);
        }

        return ans;
    }

    public static void find(int[] candidates, int target, List<List<Integer>> ans, List<Integer> l) {
        if (sum(l) == target) {
            ans.add(new ArrayList<>(l)); 
            return;
        }

        for (int i =0; i < candidates.length; i++) {
            if (sum(l) + candidates[i] <= target) { 
                l.add(candidates[i]); 
                find(candidates, target,  ans, l); 
                l.remove(l.size() - 1); 
            }
        }
    }

    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        find(candidates, target, ans, l); 
        return ans;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println("Test case 1:");
        List<List<Integer>> result1 = solution.combinationSum(candidates1, target1);
        System.out.println(result1);

        // Test case 2
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println("Test case 2:");
        List<List<Integer>> result2 = solution.combinationSum(candidates2, target2);
        System.out.println(result2);

        // Test case 3
        int[] candidates3 = {2};
        int target3 = 1;
        System.out.println("Test case 3:");
        List<List<Integer>> result3 = solution.combinationSum(candidates3, target3);
        System.out.println(result3);
    }
}
