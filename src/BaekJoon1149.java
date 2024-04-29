import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon1149 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());



        int[][] arr = new int[N + 1][3];
        int[][] cost = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = cost[i][0] = r;
            arr[i][1] = cost[i][1] = g;
            arr[i][2] = cost[i][2] = b;
        }

        for (int i = 1; i <= N; i++) {
            cost[i][0] = Math.min(cost[i - 1][1], cost[i - 1][2]) + arr[i][0];
            cost[i][1] = Math.min(cost[i - 1][0], cost[i - 1][2]) + arr[i][1];
            cost[i][2] = Math.min(cost[i - 1][0], cost[i - 1][1]) + arr[i][2];
        }

        System.out.println(Math.min(Math.min(cost[N][0], cost[N][1]), cost[N][2]));


    }
}
