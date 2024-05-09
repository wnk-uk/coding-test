package arrayExample;


import java.util.Scanner;

/**
 *
 *  격자판 최대합
 *
 *  - 문제 : N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
 *
 * - 입력 : 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
 *         두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 * - 출력 : 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
 *
 * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 *
 * - 설명 : 2차원 배열
 *
 * */

public class GridSum {

    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        int n = in.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        GridSum gridSum = new GridSum();
        System.out.println(gridSum.solution(arr));

    }

    private int solution(int[][] arr) {
        int answer = 0;
        int sum1, sum2;

        for (int i = 0; i < arr.length; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < arr.length; j++) {
                sum1 += arr[i][j]; //행의 합
                sum2 += arr[j][i]; //열의 합
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);

        }
        sum1 = sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i][i]; //좌대각선
            sum2 += arr[i][arr.length - i - 1]; //우대각선
        }

        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }

}
