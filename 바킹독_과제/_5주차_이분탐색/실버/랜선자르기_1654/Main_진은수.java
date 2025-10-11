package 바킹독_과제._5주차_이분탐색.실버.랜선자르기_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 랜선 자르기
     * https://www.acmicpc.net/problem/1654
     * 실버2
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        long low = 1;
        long high = 1;

        long[] arr = new long[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Long.parseLong(br.readLine());
            high = Math.max(high, arr[i]);
        }

        while (low <= high) {

            long mid = (low + high) / 2;
            long sum = 0;

            for (int i = 0; i < num; i++) {
                sum += arr[i] / mid;
            }

            if (sum >= size) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        System.out.println(high);
    }


}
