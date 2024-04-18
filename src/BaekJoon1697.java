import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1697 {

    static int answer = Integer.MAX_VALUE;
    static int[] visit;

    static int MAX = 200001;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visit = new int[MAX];
        BFS(N, K);
        System.out.println(answer);
    }

    private static void BFS(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        int L = 0;
        visit[n] = 1;
        while (true) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int x = q.poll();
                if (x == k) {
                    answer = L;
                    return;
                }

                int c1 = x + 1;
                int c2 = x - 1;
                int c3 = x * 2;

                if (c1 >= 0 && c1 < MAX && visit[c1] == 0) {
                    visit[c1] = 1;
                    q.offer(c1);
                }
                if (c2 >= 0 && c2 < MAX && visit[c2] == 0) {
                    visit[c2] = 1;
                    q.offer(c2);
                }
                if (c3 >= 0 && c3 < MAX &&visit[c3] == 0) {
                    visit[c3] = 1;
                    q.offer(c3);
                }
            }
            L++;
        }


    }
}
