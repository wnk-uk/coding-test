import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1926 {

    static int[][] arr;
    static int[][] visit;
    static int n, m, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] == 0 && arr[i][j] == 1) {
                    tmp = 1;
                    DFS(i, j);
                    answer++;
                    max = Math.max(max, tmp);
                }
            }
        }
        System.out.println(answer);
        System.out.println(max);
    }
    static int[][] d = {{0 ,1}, {-1, 0}, {0, -1}, {1, 0}};

    private static void DFS(int i, int j) {
        visit[i][j] = 1;

        for (int x = 0; x < d.length; x++) {
            int cx = i + d[x][0];
            int cy = j + d[x][1];

            if (cx >= 0 && cy >= 0 && cx < n && cy < m) {
                if (visit[cx][cy] == 0 && arr[cx][cy] == 1) {
                    visit[cx][cy] = 1;
                    DFS(cx, cy);
                    tmp++;
                }
            }
        }

    }

}
