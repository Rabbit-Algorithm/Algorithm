package 바킹독_과제._5주차_이분탐색.실버.나무자르기_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int N, M;
    private static int[] TREE_LIST;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        TREE_LIST = new int[N];

        long maxLen = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            TREE_LIST[i] = Integer.parseInt(st.nextToken());
            maxLen = Math.max(maxLen, TREE_LIST[i]);
        }

        long result = binarySearch(maxLen);
        System.out.println(result);
    }

    public static long binarySearch(long right) {
        long left = 0;
        long optimalHeight = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canCut(mid)) {
                optimalHeight = (int) mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return optimalHeight;
    }

    private static boolean canCut(long height) {
        long totalLength = 0;

        for (int tree : TREE_LIST) {
            if (tree > height) {
                totalLength += tree - height;
            }
        }

        return totalLength >= M;
    }

}
