import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekJoon1931 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Time> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken()); //시작
            int e = Integer.parseInt(st.nextToken()); //종료
            list.add(new Time(s, e));
        }

        Collections.sort(list);
        int answer = 0;
        int end = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).x >= end) {
                end = list.get(i).y;
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static class Time implements Comparable<Time>{
        int x;
        int y;

        public Time(int...arg) {
            this.x = arg[0];
            this.y = arg[1];
        }


        @Override
        public int compareTo(Time o) {
            if (this.y != o.y) return this.y - o.y;
            else return this.x - o.x;
        }
    }



}
