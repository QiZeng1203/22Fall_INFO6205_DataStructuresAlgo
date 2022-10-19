import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// Q3 Letter Combinations of a Phone Number
        String dig = "23";
        System.out.println(letterCombinations(dig));

    }

    static List<String> list = new ArrayList<>();
    static StringBuilder path = new StringBuilder();

    public static List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) {
            return list;
        }

        String[] map = {" ", " ", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backTracking(digits, map, 0);
        return list;
    }

    public static void backTracking(String digits, String[] map, int num) {
        if(num == digits.length()) {
            list.add(path.toString());
            return;
        }
        String str = map[digits.charAt(num) - '0'];
        for(int i = 0; i < str.length(); i++) {
            path.append(str.charAt(i));
            backTracking(digits, map, num+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
