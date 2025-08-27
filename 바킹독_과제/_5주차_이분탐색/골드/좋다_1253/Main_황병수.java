package 바킹독_과제._5주차_이분탐색.골드.좋다_1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 이분 탐색
 */
public class Main_황병수 {
    static int[] list;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (isGood(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    // list[targetIndex]가 좋은 수인지 확인
    static boolean isGood(int targetIndex) {
        int target = list[targetIndex];

        // 모든 i에 대해 target - list[i]를 이분탐색으로 찾기
        for (int i = 0; i < N; i++) {
            if (i == targetIndex) continue; // 자기 자신 제외

            int needed = target - list[i]; // 찾아야 할 값

            // needed를 이분탐색으로 찾기 (i와 targetIndex 제외)
            if (binarySearch(needed, i, targetIndex)) {
                return true;
            }
        }
        return false;
    }

    // target 값을 배열에서 찾되, excludeIndex1, excludeIndex2는 제외
    static boolean binarySearch(int target, int excludeIndex1, int excludeIndex2) {
        int left = 0, right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list[mid] == target) {
                // 찾았지만 제외할 인덱스인지 확인
                if (mid != excludeIndex1 && mid != excludeIndex2) {
                    return true;
                }

                // 같은 값이 여러 개 있을 수 있으므로 좌우로 확장해서 찾기
                if (expandSearch(target, mid, excludeIndex1, excludeIndex2)) {
                    return true;
                }
                return false;

            } else if (list[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    // 같은 값들 중에서 사용 가능한 인덱스 찾기
    static boolean expandSearch(int target, int foundIndex, int exclude1, int exclude2) {
        // 왼쪽으로 확장
        for (int i = foundIndex - 1; i >= 0 && list[i] == target; i--) {
            if (i != exclude1 && i != exclude2) {
                return true;
            }
        }

        // 오른쪽으로 확장
        for (int i = foundIndex + 1; i < N && list[i] == target; i++) {
            if (i != exclude1 && i != exclude2) {
                return true;
            }
        }

        return false;
    }
}