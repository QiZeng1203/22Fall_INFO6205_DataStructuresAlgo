import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// Q7 Generate Parentheses
        System.out.println(generateParenthesis(3));
    }

    static List<String> result = new ArrayList<>();
    static StringBuilder path = new StringBuilder();

    public static List<String> generateParenthesis(int n) {
        if(n == 0) {
            return result;
        }
        backTracking(path, n, n, result);
        return result;
    }

    public static void backTracking(StringBuilder path, int left, int right, List<String> result) {
        if(left == 0 && right == 0) {
            result.add(path.toString());
            return;
        }
        if(left > right){
            return;
        }
        if(left > 0) {
            path.append("(");
            backTracking(path, left-1, right, result);
            path.deleteCharAt(path.length()-1);
        }
        if(right > 0) {
            path.append(")");
            backTracking(path, left, right-1,result);
            path.deleteCharAt(path.length()-1);
        }
    }
}
