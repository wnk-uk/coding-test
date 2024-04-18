import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2468 {
    static int[][] arr;
    static int[][] visit;
    static int[][] d = {{0 ,1}, {-1, 0}, {0, -1}, {1, 0}};
    static int N;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visit = new int[N][N];

        StringTokenizer st;
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                arr[i][j] = x;
                max = Math.max(max, x);
            }
        }

        dy = new int[max + 1];

        for (int k = 0; k < max; k++) {
            visit = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j] == 0 && arr[i][j] > k) {
                        DFS(i, j, k);
                        dy[k]++;
                    }
                }
            }
        }

        int answer = 0;
        for (int x : dy) {
            answer = Math.max(answer, x);
        }
        System.out.println(answer);
    }

    private static void DFS(int i, int j, int l) {
        visit[i][j] = 1;

        for (int k = 0; k < d.length; k++) {
            int cx = i + d[k][0];
            int cy = j + d[k][1];
            if (cx >= 0 && cy >= 0 && cx < N && cy < N) {
                if (visit[cx][cy] == 0 && arr[cx][cy] > l) {
                    DFS(cx, cy, l);
                }
            }
        }
    }
}
