package hackerrank;

import java.util.List;

public class DiagonalDifferenceJ {
    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0 ;
        for (int i = 0; i < arr.size(); i++) {
            primaryDiagonal += arr.get(i).get(i);
            secondaryDiagonal += arr.get(i).get(arr.size() - 1 - i);
        }

        return Math.abs(primaryDiagonal - secondaryDiagonal);
    }
}
