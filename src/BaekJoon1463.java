import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BaekJoon1463 {

    static int answer = Integer.MAX_VALUE;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        BFS(N);
        System.out.println(answer);
    }

    private static void BFS(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);

        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int x = q.poll();
                dp[x] = 1;
                if (x == 1) answer = Math.min(answer, L);
                if (x % 3 == 0 && dp[x / 3] == 0) q.offer(x / 3);
                if (x % 2 == 0 && dp[x / 2] == 0) q.offer(x / 2);
                if (x > 1 && dp[x - 1] == 0) q.offer(x - 1);
            }
            L++;
        }
    }
}
