import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// Q5 Numbers With Same Consecutive Differences
        System.out.println(Arrays.toString(numsSameConsecDiff(3,7)));
    }

    static List<Integer> result = new ArrayList<>();
    public static int[] numsSameConsecDiff(int n, int k) {
        for(int i = 1; i < 10; i++) {
            dfs(i, n-1, k);
        }
        int[] nums = new int[result.size()];
        for(int i=0; i < result.size(); i++) {
            nums[i] = result.get(i);
        }
        return nums;
    }

    public static void dfs(int num, int n, int k) {
        if(n == 0) {
            result.add(num);
            return;
        }
        int remainder = num % 10;
        if(k + remainder < 10) {
            dfs(num * 10 + k + remainder, n-1, k);
        }
        if(remainder - k >= 0 && k != 0) {
            dfs(num * 10 + remainder - k, n-1, k);
        }
    }
}
