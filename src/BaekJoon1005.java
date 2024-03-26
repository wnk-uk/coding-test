import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1005 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); //테스트케이스

        for (int s = 0; s < T; s++) {

            //첫째 줄에 건물의 개수 N과 건물간의 건설순서 규칙의 총 개수 K
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int arr[] = new int[N + 1];
            arr[0] = 0;
            //둘째 줄에는 각 건물당 건설에 걸리는 시간 D1, D2, ..., DN이 공백을 사이로 주어진다.
            st = new StringTokenizer(br.readLine());

            ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
            graph.add(new ArrayList<>()); //arr[0] = 0;
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                graph.add(new ArrayList<>());
            }

            int[] indegree = new int[N + 1];
            indegree[0] = Integer.MAX_VALUE;

            for (int i = 1; i <= K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph.get(x).add(y);
                indegree[y]++;
            }

            int target = Integer.parseInt(br.readLine()); //승리조건
            int[] dp = new int[N + 1];
            dp[0] = 0;

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < indegree.length; i++) {
                dp[i] = arr[i];
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {

                int x = queue.poll();

                for (int y : graph.get(x)) {

                    //동일한 진입차수가 있는 경우를 고려해서
                    dp[y] = Math.max(dp[y], dp[x] + arr[y]);

                    indegree[y]--;
                    if (indegree[y] == 0) {
                        queue.offer(y);
                    }
                }
            }
            System.out.println(dp[target]);
        }

    }

}
