import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1052 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {

            int base = 0;
            while (N > Math.pow(2, base)) {
                base++;
            }
            
            //최대로 만들 수 있는 수
            if (i == K - 1) {
                base++;
            }
            int bottle = (int) Math.pow(2, base - 1);

            if (N < 0) {
                N = bottle - N;
            } else {
                N -= bottle;
            }

            if (N == 0) break;
        }

        System.out.println(Math.abs(N));



    }
}

