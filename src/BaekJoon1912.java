import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekJoon1912 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int dp[] = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            int c = dp[i] + dp[i - 1];
            if (dp[i - 1] > 0 && c > 0) {
                dp[i] = c;
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);

    }

}
