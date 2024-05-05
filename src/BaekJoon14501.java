import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class BaekJoon14501 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int idx[] = new int[N];
        int cost[] = new int[N];
        int dp[] = new int[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int ti = Integer.parseInt(st.nextToken());
            int pi = Integer.parseInt(st.nextToken());

            idx[i] = ti;
            cost[i] = pi;
        }

        for (int i = 0; i < N; i++) {
            int next = i + idx[i];
            if (next <= N) {
                dp[next] = Math.max(dp[next], dp[i] + cost[i]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        //for (int x : dp) System.out.println(x);

        System.out.println(dp[N]);

    }
}
