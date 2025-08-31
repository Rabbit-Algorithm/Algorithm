package _5주차_이분탐색.골드.공유기설치_2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_황병수 {
    static int N, M;
    static int[] homeList;
    static int[] diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        homeList = new int[N];
        diff = new int[N - 1];

        for (int i = 0; i < N; i++) {
            homeList[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(homeList);

        for (int i = 0; i < homeList.length - 1; i++) {
            diff[i] = homeList[i + 1] - homeList[i];
        }

        System.out.println("binarySearch() = " + binarySearch());

    }

    private static int binarySearch() {
        int left = 1;
        int right = homeList[N - 1] - homeList[0];
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int available = getCnt(mid);

            if (available >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static int getCnt(int target) {
        int cnt = 1;
        int sum = 0;
        for (int i = 0; i < diff.length; i++) {
            if (sum + diff[i] < target) {
                sum += diff[i];
            } else {
                cnt++;
                sum = 0;
            }
        }

        return cnt;
    }
}
