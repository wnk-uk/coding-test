import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Queue;

public class BaekJoon10026 {

    static char arr[][];
    static int v[][];
    static int[][] d = {{0 ,1}, {-1, 0}, {0, -1}, {1, 0}};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];


        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            arr[i] = str.toCharArray();
        }


        for (int t = 0; t < 2; t++) {
            v = new int[N][N];

            if (t == 1) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (arr[i][j] == 'G') arr[i][j] = 'R';
                    }
                }
            }

            int answer = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (v[i][j] == 0) {
                        DFS(i, j, arr[i][j]);
                        answer++;
                    }
                }
            }
            System.out.print(answer + " ");
        }
    }

    private static void DFS(int x, int y, char color) {
        v[x][y] = 1;
        for (int i = 0; i < d.length; i++) {
            int cx = x + d[i][0];
            int cy = y + d[i][1];

            if (isLen(cx, cy) && v[cx][cy] == 0) {
                if (arr[cx][cy] == color) {
                    v[cx][cy] = 1;
                    DFS(cx, cy, color);
                }
            }
        }
    }

    private static boolean isLen(int cx, int cy) {
        if (cx >= 0 && cy >= 0 && cx < N && cy < N) return true;
        return false;
    }


}
