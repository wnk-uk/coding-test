package array;
import java.util.Scanner;

/**
 *
 * 소수(에라토스테네스 체)
 *
 *  - 문제 : 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 *          만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
 *
 * - 입력 : 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
 * - 출력 : 첫 줄에 소수의 개수를 출력합니다.
 *
 * - 설명 : 소수인지 체크하면서 배수를 걸러냄
 *
 * */

public class PrimeNumber {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();

        PrimeNumber primeNumber = new PrimeNumber();
        System.out.println(primeNumber.solution(n));

    }

    public int solution(int n) {
        int answer = 0;
        int[] ch = new int[n + 1];

        //배열의 갯수만큼 반복함
        for (int i = 2; i <= n; i++) {
            
            //앞선 반복문에 의해 영향받지 않은 자리
            if (ch[i] == 0) {
                //해당 자리에서 배수를 제함
                answer++;
                for (int j = i; j <= n; j = j + i) ch[j] = 1;
            }
        }
        return answer;
    }


}
