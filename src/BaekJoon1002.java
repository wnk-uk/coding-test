import java.util.Scanner;

public class BaekJoon1002 {

    static int[][] dp;
    static int n;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        dp = new int[41][2];

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;



        for (int i = 2; i < 41; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            System.out.println(dp[x][0] + " " + dp[x][1]);
        }


        //int x = scanner.nextInt();
    }


}
