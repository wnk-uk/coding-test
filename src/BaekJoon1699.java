import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1699 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = i;
            for (int j = 1; (int)Math.pow(j, 2) <= i; j++) {
                if (dp[i] > dp[i - (int)Math.pow(j, 2)] + 1) {
                    dp[i] = dp[i - (int)Math.pow(j, 2)] + 1;
                }
            }
        }

        System.out.println(dp[N]);



    }

}
