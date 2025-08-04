package 바킹독_과제._5주차_이분탐색.골드.좋다_1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 좋다
     * https://www.acmicpc.net/problem/1253
     * 골드4
     */


    /**
     * 도저히 이분탐색은 방법이 안 떠오름
     * 이분 탐색 시도 했음 > 백준 제출 확인 > 시간 초과 59% 정도에서
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        long[] arr = new long[num];
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);


        for (int i = 0; i < num; i++) {

            // 투포인터 + 이분탐색

            int low = 0;
            int high = num - 1;

            // 투포인터
            while (low < high) {
                if (i == low) {
                    low++;
                    continue;
                }

                if (i == high) {
                    high--;
                    continue;
                }

                long sum = arr[low] + arr[high];

                if (sum > arr[i]) {
                    high--;
                } else if (sum == arr[i]) {
                    set.add(i);
                    break;
                } else {
                    low++;
                }

            }

        }

        System.out.println(set.size());


    }

}
