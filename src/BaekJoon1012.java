import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1012 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] arr = new int[M][N];
            int[][] visit = new int[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            int answer = 0;
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (arr[x][y] == 1 && visit[x][y] == 0) {
                        DFS(x, y, arr, visit, M, N);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    static int[][] d = {{0 ,1}, {-1, 0}, {0, -1}, {1, 0}};

    private static void DFS(int x, int y, int[][] arr, int[][] visit, int M, int N) {
        visit[x][y] = 1;

        for (int i = 0; i < d.length; i++) {
            int dx = x + d[i][0];
            int dy = y + d[i][1];

            if (dx >= 0 && dy >= 0 && dx < M && dy < N) {
                if (arr[dx][dy] == 1 && visit[dx][dy] == 0) {
                    DFS(dx, dy, arr, visit, M, N);
                }
            }
        }
    }
}
