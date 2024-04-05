import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekJoon1946 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());


            ArrayList<Person> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.add(new Person(a, b));
            }

            Collections.sort(list);

            int end = Integer.MAX_VALUE;
            int answer = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).b < end) {
                    end = list.get(j).b;
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }

    public static class Person implements Comparable<Person>{
        int a;
        int b;

        public Person(int...arg) {
            this.a = arg[0];
            this.b = arg[1];
        }


        @Override
        public int compareTo(Person o) {
            if (this.a != o.a) return this.a - o.a;
            else return this.b - o.b;
        }
    }

}
