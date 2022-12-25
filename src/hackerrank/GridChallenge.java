package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridChallenge {
    public static String gridChallenge(List<String> grid) {
        // Write your code here
        List<char[]> list = new ArrayList<>();
        for (String s : grid) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            list.add(charArray);
        }
        String result = "YES";
        char[] charArray = list.get(0);
        for (int i = 0; i < charArray.length; i++) {
            char c = 'a';
            for (int j = 0; j < list.size(); j++) {
                charArray = list.get(j);
                char nextC = charArray[i];
                if (nextC < c) {
                    result = "NO";
                    return result;
                }
                c = nextC;
            }
        }
        return result;
    }
}
