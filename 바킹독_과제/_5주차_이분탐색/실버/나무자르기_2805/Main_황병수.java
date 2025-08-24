package 바킹독_과제._5주차_이분탐색.실버.나무자르기_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_황병수 {

    static int N,M;

    static Long R;
    static int[] treeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        treeList = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int stick = Integer.parseInt(st.nextToken());
            treeList[i] = stick;
        }

        Arrays.sort(treeList);
        binarySearch();
        System.out.println(R);
    }

    private static void binarySearch() {

        long left = 0;
        long right = treeList[N-1];

        while (left <= right) {
            long mid = (left + right) / 2;
            long TotalTreeLength = cutTree(mid);

            if (TotalTreeLength >= M) {
                R = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
    }

    private static long cutTree(long mid) {
        long totalLength = 0;
        for (int i = 0; i < N; i++) {
            if (treeList[i] >= mid) {
                totalLength += (treeList[i] - mid);
            }

        }

        return totalLength;
    }
}
