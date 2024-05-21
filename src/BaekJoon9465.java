import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon9465 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            int x = Integer.parseInt(br.readLine()); //가로행

            long dp[][] = new long[4][x + 1];
            int arr[][] = new int[3][x + 1];

            for (int l = 1; l <= 2; l++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= x; j++) {
                    arr[l][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[2][1] = arr[1][1];
            dp[3][1] = arr[2][1];

            for (int k = 2; k <= x; k++) {
                dp[1][k] = Math.max(dp[2][k - 1], dp[3][k - 1]);
                dp[2][k] = Math.max(dp[3][k - 1] + arr[1][k], dp[1][k - 1] + arr[1][k]);
                dp[3][k] = Math.max(dp[2][k - 1] + arr[2][k], dp[1][k - 1] + arr[2][k]);
            }

            long answer = Math.max(Math.max(dp[1][x], dp[2][x]), dp[3][x]);
            System.out.println(answer);
        }
    }
}
