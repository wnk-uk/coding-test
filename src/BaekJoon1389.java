import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon1389 {

    static ArrayList<ArrayList<Integer>> arr;
    static int[] dy;
    static int[] visit;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr.get(A).add(B);
            arr.get(B).add(A);
        }

        int answer = Integer.MAX_VALUE;
        int sum = Integer.MAX_VALUE;

        for (int i = 1; i < N + 1; i++) {
            visit = new int[N + 1];
            dy = new int[N + 1];
            BFS(i);

            int tmp = 0;
            for (int x : dy) {
                tmp += x;
            }

            if (sum > tmp) {
                answer = i;
                sum = tmp;
            }
        }

        System.out.println(answer);
    }

    private static void BFS(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        int L = 1;
        visit[i] = 1;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int j = 0; j < len; j++) {
                int x = q.poll();
                for (int y : arr.get(x)) {
                    if (visit[y] == 0) {
                        visit[y] = 1;
                        dy[y] = L;
                        q.offer(y);
                    }
                }
            }
            L++;
        }
    }
}
