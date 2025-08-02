package 바킹독_과제._5주차_이분탐색.실버.나무자르기_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 나무 자르기
     * https://www.acmicpc.net/problem/2805
     * 실버2
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int remain = Integer.parseInt(st.nextToken());

        long low = 1;
        long high = 1;

        st = new StringTokenizer(br.readLine());
        long[] trees = new long[num];
        for (int i = 0; i < num; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            high = Math.max(high, trees[i]);
        }

        while (low <= high) {

            long mid = (low + high) / 2;
            long sum = 0;

            for (int i = 0; i < num; i++) {
                long diff = trees[i] - mid;
                if (diff > 0) {
                    sum += diff;
                }
            }

            if (sum >= remain) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        System.out.println(high);


    }


}
