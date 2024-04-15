import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon4963 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) return;

            int[][] arr = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] visit = new int[h][w];
            int answer = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && visit[i][j] == 0) {
                        DFS(i, j, arr, visit, w, h);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    static int[][] d = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    private static void DFS(int i, int j, int[][] arr, int[][] visit, int w, int h) {
        visit[i][j] = 1;

        for (int k = 0; k < d.length; k++) {
            int dx = j + d[k][0];
            int dy = i + d[k][1];

            if (dx >= 0 && dy >= 0 && dx < w && dy < h) {
                if (visit[dy][dx] == 0 && arr[dy][dx] == 1) {
                    DFS(dy, dx, arr, visit, w, h);
                }
            }
        }
    }
}
