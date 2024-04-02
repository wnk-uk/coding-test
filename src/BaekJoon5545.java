import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon5545 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //토핑의 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken()); //도우의 가격
        int B = Integer.parseInt(st.nextToken()); //토핑의 가격


        int C = Integer.parseInt(br.readLine()); //도우의 열량

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine()); //각 토핑의 열량
        }

        Arrays.sort(arr);

        int dow = C;  //도우 1원당 가격
        double answer = (double) C / A;
        int in = 0;
        int kal = dow;

        for (int i = arr.length - 1; i >= 0; i--) {

            int topi = arr[i];
            double avg = ((double)(kal + topi)) / (A + (B * (in + 1)));

            if (answer <= avg) {
                answer = avg;
                kal += topi;
                in++;
            }
        }


        System.out.println((int) answer);

    }

}
