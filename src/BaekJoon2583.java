import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekJoon2583 {

    static int[][] arr;
    static int[][] v;
    static int M, N, K;
    static int tmp = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        arr = new int[M][N];
        v = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            //0 2 왼쪽아래
            //4 4 오른쪽 위
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            for (int j = y; j < y1; j++) {
                for (int k = x; k < x1; k++) {
                    arr[j][k] = 1;
                }
            }
        }

        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (v[i][j] == 0 && arr[i][j] == 0) {
                    tmp = 1;
                    DFS(i, j);
                    answer++;
                    list.add(tmp);
                }
            }
        }
        Collections.sort(list);

        System.out.println(answer);
        for (int x : list) {
            System.out.print(x + " ");
        }

    }
    static int[][] d = {{0 ,1}, {-1, 0}, {0, -1}, {1, 0}};

    private static void DFS(int i, int j) {
        v[i][j] = 1;
        for (int k = 0; k < d.length; k++) {
            int cx = i + d[k][0];
            int cy = j + d[k][1];

            if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
                if (v[cx][cy] == 0 && arr[cx][cy] == 0) {
                    DFS(cx, cy);
                    tmp++;
                }
            }
        }
    }

}
