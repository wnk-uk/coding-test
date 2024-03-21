package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class FindCow {

    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();
    public static void main(String[] args) {

        int curPoint = 5;
        int tarPoint = 14;

        FindCow fc = new FindCow();
        System.out.println(fc.BFS(curPoint, tarPoint));

    }


    public int BFS(int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        Q.offer(s);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                System.out.println("x ::: " + x);

                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    if (nx == e) return L + 1;
                    if (nx >= 1 && nx <= 100000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }



}
