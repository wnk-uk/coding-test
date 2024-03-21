package array;

import java.util.Scanner;

public class PeaksCount {

    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        int n = in.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        PeaksCount peaksCount = new PeaksCount();
        System.out.println(peaksCount.solution(arr));

    }

    private int solution(int[][] arr) {
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {

                //현재 index
                int tmp = arr[i][j];
                boolean flag = true;

                //arr[i - 1][j] //상
                //arr[i + 1][j] //하
                //arr[i][j - 1] //좌
                //arr[i][j + 1] //우
            }
        }
        return answer;
    }


}
