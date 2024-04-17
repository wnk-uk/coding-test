import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon11725 {

    static ArrayList<ArrayList<Integer>> arr;
    static int[] visit;
    static int[] p;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new ArrayList<ArrayList<Integer>>();
        visit = new int[N + 1];
        p = new int[N + 1];


        for (int i = 0; i < N + 1; i++) {
            arr.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        DFS(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(p[i]);
        }
    }

    private static void DFS(int i) {
        visit[i] = 1;
        for (int j : arr.get(i)) {
            if (visit[j] == 0) {
                visit[j] = 1;
                p[j] = i;
                DFS(j);
            }
        }
    }

}
