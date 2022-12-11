import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    // Time Complexity: O(n)

    public static List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> list = new ArrayList<>();

            HashMap<String, ArrayList<String>> map = new HashMap<>();

            for(String str: strs) {
                char[] chArr = str.toCharArray();
                Arrays.sort(chArr);
                String anagram = String.valueOf(chArr);

                if(!map.containsKey(anagram)) {
                    ArrayList<String> strList = new ArrayList<>();
                    strList.add(str);
                    map.put(anagram, strList);
                }
                else{
                    ArrayList<String> strList = map.get(anagram);
                    strList.add(str);
                    map.put(anagram, strList);
                }
            }
            for(Map.Entry<String, ArrayList<String>> entry: map.entrySet()) {
                list.add(entry.getValue());
            }

            return list;

    }
}
