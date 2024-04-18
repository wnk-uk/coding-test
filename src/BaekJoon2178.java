import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2178 {

    static int[][] arr;
    static int[][] visit;
    static int[][] dy;
    static int[][] d = {{0 ,1}, {-1, 0}, {0, -1}, {1, 0}};
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new int[N][M];
        dy = new int[N][M];


        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        visit[0][0] = 1;
        dy[0][0] = 1;
        DFS(0, 0);

        System.out.println(dy[N - 1][M - 1]);

    }

    private static void DFS(int a, int b) {

        for (int i = 0; i < d.length; i++) {
            int cx = a + d[i][0];
            int cy = b + d[i][1];

            if (cx >= 0 && cy >= 0 && cx < N && cy < M) {
                if (dy[cx][cy] > dy[a][b] + 1) visit[cx][cy] = 0;

                if (visit[cx][cy] == 0 && arr[cx][cy] == 1) {
                    visit[cx][cy] = 1;
                    dy[cx][cy] = dy[a][b] + 1;
                    DFS(cx, cy);
                }
            }
        }
    }
}
