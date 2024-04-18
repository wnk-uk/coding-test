import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon5014 {

    static int[] arr;
    static int[] v;
    static int F, S, G, U, D;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        arr = new int[F + 1];
        v = new int[1000001 + U];

        BFS(S);
        System.out.println(answer == Integer.MAX_VALUE ? "use the stairs" : answer);


    }

    private static void BFS(int s) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        v[s] = 1;
        int L = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int x = q.poll();

                if (x == G) {
                    answer = Math.min(answer,  L);
                }

                int ux = x + U;
                int dx = x - D;

                if (ux > 0 && ux <= F && v[ux] == 0) {
                    v[ux] = 1;
                    q.offer(ux);
                }

                if (dx > 0 && dx <= F && v[dx] == 0) {
                    v[dx] = 1;
                    q.offer(dx);
                }
            }
            L++;
        }
    }

}
