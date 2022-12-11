import java.util.ArrayList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String str = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(str));
    }

    // Time Complexity : O(n)
    public static String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> indexesToRemove = new ArrayList<>();

        for(int i = 0; i < s.length(); i++ ) {
            Character ch = s.charAt(i);
            if(ch == '(') {
                stack.push(i);
            }
            if(ch == ')') {
                if(stack.isEmpty()) {
                    indexesToRemove.add(i);
                }
                else{
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()) {
            indexesToRemove.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
                for(int i = 0; i < s.length(); i++) {
            if(!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
                return sb.toString();
    }
}
