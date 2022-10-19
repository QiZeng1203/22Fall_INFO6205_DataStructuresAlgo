import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// Q6 Subsets
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        backTracking(nums, 0);
        return result;
    }

    public static void backTracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        if(startIndex >= nums.length) {
            return;
        }
        for(int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTracking(nums, i+1);
            path.removeLast();
        }
    }
}
