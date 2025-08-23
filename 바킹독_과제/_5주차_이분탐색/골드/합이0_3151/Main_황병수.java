package 바킹독_과제._5주차_이분탐색.골드.합이0_3151;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_황병수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);  // 정렬 필수

        long result = 0;  // int 범위 초과 가능성 있음

        // 첫 번째 원소 고정하고 투 포인터
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {
                    // 핵심: 중복된 값들 처리
                    if (arr[left] == arr[right]) {
                        // left부터 right까지 모두 같은 값
                        // 이 중에서 2개를 선택하는 조합의 수
                        int count = right - left + 1;
                        result += (long) count * (count - 1) / 2;
                        break;  // 더 이상 진행할 필요 없음
                    } else {
                        // left값과 right값이 다른 경우
                        int leftCount = 1, rightCount = 1;

                        // 같은 left 값 개수 세기
                        while (left + 1 < right && arr[left] == arr[left + 1]) {
                            leftCount++;
                            left++;
                        }

                        // 같은 right 값 개수 세기
                        while (right - 1 > left && arr[right] == arr[right - 1]) {
                            rightCount++;
                            right--;
                        }

                        result += (long) leftCount * rightCount;
                        left++;  // 다음 구간으로 이동
                        right--;
                    }
                } else if (sum < 0) {
                    left++;   // 합이 작으면 left를 오른쪽으로
                } else {
                    right--;  // 합이 크면 right를 왼쪽으로
                }
            }
        }

        System.out.println(result);
    }
}