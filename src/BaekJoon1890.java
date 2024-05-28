import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1890 {

    static int[][] arr;
    static long[][] dp;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new long[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int move = arr[i][j];

                if (i == N - 1 && j == N - 1) {
                    System.out.println(dp[N - 1][N - 1]);
                    return;
                }

                if (i + move < N) {
                    dp[i + move][j] += dp[i][j];
                }
                if (j + move < N) {
                    dp[i][j + move] += dp[i][j];
                }
            }
        }
    }
}
