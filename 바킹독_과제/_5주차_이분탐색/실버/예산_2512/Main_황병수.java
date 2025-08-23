package 바킹독_과제._5주차_이분탐색.실버.예산_2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_황병수 {
    static int N,M,R;
    static int[] moneyList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        moneyList = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            moneyList[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        Arrays.sort(moneyList);
        binarySearch();
        System.out.println(R);
    }

    private static void binarySearch() {

        long left = 1;
        long right = moneyList[N-1];
        R = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long restMoney = calcMethod(mid);

            if (restMoney >= 0) {
                R = (int)mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    static long calcMethod(long money) {
        long restMoney = M;
        for (int i = 0; i < N; i++) {
            if (moneyList[i] < money) {
                restMoney -= moneyList[i];
            } else {
                restMoney -= money;
            }
        }
        return restMoney;
    }
}
