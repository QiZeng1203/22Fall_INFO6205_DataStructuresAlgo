import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
	// Q1 Combination Sum
        int[] array = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(array, target));
    }

    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target,0,0);
        return result;
    }
    public static void backTracking(int[] candidates, int target, int sum, int startIndex) {
        if(sum > target) {
            return;
        }
        if(sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backTracking(candidates, target, sum, i);
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
