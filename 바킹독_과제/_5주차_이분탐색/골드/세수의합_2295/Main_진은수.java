package 바킹독_과제._5주차_이분탐색.골드.세수의합_2295;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 세 수의 합
     * https://www.acmicpc.net/problem/2295
     * 골드4
     */


    /**
     * https://kimtaesoo99.tistory.com/149
     * 리뷰때 블로그 링크 방식이랑 비교! 시간차이 남. 백준확인
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        long[] arr = new long[num];

        for (int i = 0; i < num; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        Set<Long> set = new HashSet<>();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                set.add(arr[i] + arr[j]);
            }
        }


        for (int i = num - 1; i >= 0; i--) {
            for (int j = num - 1; j >= 0; j--) {
                long minus = arr[i] - arr[j];

                if (set.contains(minus)) {
                    System.out.println(arr[i]);
                    return;
                }

            }
        }



    }


}
