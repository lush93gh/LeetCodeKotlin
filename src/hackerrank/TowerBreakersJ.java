package hackerrank;

public class TowerBreakersJ {
    public static int towerBreakers(int n, int m) {
        // Write your code here
        if (m == 1) return 2;
        else if (n % 2 == 0) return 2;
        else return 1;
    }
}
