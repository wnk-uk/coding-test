import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon15990 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long max = 0L;
        long mod = 1000000009;

        int arr[] = new int[T];
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long[][] dp = new long[100001][4];
        dp[1][1] = dp[2][2] = dp[3][3] = dp[3][2] = dp[3][1] = 1;

        for (int i = 4; i <= max; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % mod;;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % mod;;
        }

        for (int x : arr) {
            long answer = (dp[x][1] + dp[x][2] + dp[x][3]) % mod;
            System.out.println(answer);
        }
    }

}
