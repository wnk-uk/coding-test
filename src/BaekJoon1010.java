import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1010 {

    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        //조합수 nCr
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());


            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            dp = new int[M + 1][N + 1];
            System.out.println(DFS(M, N));
        }
    }


    private static int DFS(int N, int M) {
        if (dp[N][M] != 0) return dp[N][M];
        if (N == M || M == 0) return 1;
        else return dp[N][M] = DFS(N - 1, M - 1) + DFS(N -1, M);
    }


}
