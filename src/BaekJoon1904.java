import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon1904 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1000001];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;


        int i = 0;
        while (true) {
            if (dp[i] == -1) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
            }
            i++;
            if (i > N) break;
        }

        System.out.println(dp[N]);
    }
}
