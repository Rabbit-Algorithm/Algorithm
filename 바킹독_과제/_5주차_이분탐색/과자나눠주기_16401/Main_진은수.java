package 바킹독_과제._5주차_이분탐색.과자나눠주기_16401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 과자 나눠주기
     * https://www.acmicpc.net/problem/16401
     * 실버2
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int person = Integer.parseInt(st.nextToken());
        int candy = Integer.parseInt(st.nextToken());

        long low = 1;
        long high = 1;

        st = new StringTokenizer(br.readLine());
        long[] candies = new long[candy];
        for (int i = 0 ; i < candy ; i++) {
            candies[i] = Long.parseLong(st.nextToken());
            high = Math.max(high, candies[i]);
        }

        while (low <= high) {

            long mid = (low + high) / 2;
            long sum = 0;

            for (int i = 0; i < candy; i++) {
                sum += candies[i] / mid;
            }

            if (sum >= person) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        System.out.println(high);









    }


}
