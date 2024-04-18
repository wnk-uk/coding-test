import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1743 {

    static int[][] arr;
    static int[][] visit;
    static int N, M;

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        visit = new int[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[r][c] = 1;
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (visit[i][j] == 0 && arr[i][j] == 1) {
                    answer = 1;
                    DFS(i, j);
                    max = Math.max(max, answer);
                }
            }
        }
        System.out.println(max);
    }

    static int[][] d = {{0 ,1}, {-1, 0}, {0, -1}, {1, 0}};
    private static void DFS(int i, int j) {
        visit[i][j] = 1;

        for (int k = 0; k < d.length; k++) {
            int cx = i + d[k][0];
            int cy = j + d[k][1];
            if (cx > 0 && cy > 0 && cx <= N && cy <= M) {
                if (visit[cx][cy] == 0 && arr[cx][cy] == 1) {
                    answer++;
                    DFS(cx, cy);
                }
            }
        }
    }

}
