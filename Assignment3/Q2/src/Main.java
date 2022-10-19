import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// Q2 Permutations
        int[] arr = {1,2,3};
        System.out.println(permute(arr));
    }

    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static boolean[] used;

    public static List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0) {
            return result;
        }
        used = new boolean[nums.length];
        backTracking(nums);
        return result;
    }

    public static void backTracking(int[] nums) {
        if(path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backTracking(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
