package _7주차_이분탐색.골드.용액합성하기_14921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 용액 합성하기
     * https://www.acmicpc.net/problem/14921
     * 골드5
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        long[] arr = new long[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int low = 0;
        int high = num - 1;
        long min = Long.MAX_VALUE;
        long answer = 0;
        while (low < high) {

            long sum = arr[low] + arr[high];

            if (sum == 0) {
                answer = 0;
                break;
            } else if (sum > 0) {

                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    answer = sum;
                }
                high--;
            } else {
                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    answer = sum;
                }
                low++;
            }


        }



        System.out.println(answer);

    }


}
