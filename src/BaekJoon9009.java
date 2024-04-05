import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BaekJoon9009 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            long n = Long.parseLong(br.readLine()); //정수 n

            ArrayList<Long> arr = new ArrayList<>();

            arr.add(0L); //f0
            arr.add(1L); //f1

            int j = 2;
            while (true) {
                long x = arr.get(j - 2) + arr.get(j - 1);
                if (x > n) break;
                arr.add(x);
                j++;
            }

            Collections.sort(arr, Collections.reverseOrder());

            ArrayList<Long> answer = new ArrayList<>();

            while (n != 0) {
                for (int k = 0; k < arr.size(); k++) {
                    long fivo = arr.get(k);
                    if (fivo <= n && fivo != 0) {
                        n -= arr.get(k);
                        answer.add(arr.get(k));
                    }
                }
            }
            Collections.sort(answer);

            for (long z : answer) {
                System.out.print(z + " ");
            }
            System.out.println();
        }
    }
}
