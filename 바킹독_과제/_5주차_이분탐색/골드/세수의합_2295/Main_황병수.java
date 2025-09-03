package 바킹독_과제._5주차_이분탐색.골드.세수의합_2295;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PropertyResourceBundle;

public class Main_황병수 {
    static int[] AList;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        AList = new int[N + 1];
        visited = new boolean[N + 1];

        // 값 할당
        for (int i = 1; i <= N; i++) {
            AList[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        Arrays.sort(AList);

        for (int i = N -1; i >= 3; i--) {
            for (int j = i-1 ; j >= 2; j--) {
                for (int k = j-1; k >= 1 ; k--) {
                    if (binarySearch(AList[i] + AList[j] + AList[k])) {
                        System.out.println(AList[i] + AList[j] + AList[k]);
                        return;
                    }
                }
            }
        }

    }


    private static boolean binarySearch(int target) {

        int left = 1;
        int right = N;

        while (left <= right) {
            int mid = (left +  right) / 2;
            if (AList[mid] == target) {
                return true;
            } else if (AList[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
