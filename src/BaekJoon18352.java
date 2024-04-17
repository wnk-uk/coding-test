import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon18352 {

    static ArrayList<ArrayList<Integer>> arr;
    static int[] visit;
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int K = Integer.parseInt(st.nextToken()); // 거리정보
        int X = Integer.parseInt(st.nextToken()); //출발 도시의 번호

        arr = new ArrayList<>();
        answer = new ArrayList<>();

        for (int i = 1; i <= N + 1; i++) {
            arr.add(new ArrayList<>());
        }

        visit = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr.get(A).add(B);
        }

        BFS(X, K);

        if (answer.size() == 0){
            System.out.println(-1);
            return;
        }

        Collections.sort(answer);

        for (int i : answer) {
            System.out.println(i);
        }

    }

    private static void BFS(int x, int k) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visit[x] = 1;
        int L = 0;

        while (true) {
            if (L == k) break;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int a = q.poll();
                for (int v : arr.get(a)) {
                    if (visit[v] == 0) {
                        visit[v] = 1;
                        q.offer(v);
                    }
                }
            }
            L++;
        }

        while (!q.isEmpty()) {
            answer.add(q.poll());
        }

    }

}
