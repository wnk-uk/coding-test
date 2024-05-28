import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2302 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        long answer = 1;
        int tmp = 0;
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(br.readLine());
            answer *= dp[x - tmp - 1];
            tmp = x;
        }
        answer *= dp[N - tmp];

        System.out.println(answer);
    }
}
