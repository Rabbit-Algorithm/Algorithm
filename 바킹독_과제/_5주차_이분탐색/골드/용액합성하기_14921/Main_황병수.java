package 바킹독_과제._5주차_이분탐색.골드.용액합성하기_14921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_황병수 {

    static int N;
    static int R = Integer.MAX_VALUE;
    static int[] NList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        NList = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            NList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(NList);

        // 투 포인터 방식으로 수정
        int left = 0;
        int right = N - 1;

        while (left < right) {
            int sum = NList[left] + NList[right];

            // 절댓값이 더 작으면 갱신
            if (Math.abs(sum) < Math.abs(R)) {
                R = sum;
            }

            // 합이 0보다 크면 오른쪽 포인터를 왼쪽으로
            if (sum > 0) {
                right--;
            }

            // 합이 0보다 작으면 왼쪽 포인터를 오른쪽으로
            else if (sum < 0) {
                left++;
            }

            // 합이 0이면 최적해이므로 종료
            else {
                R = 0;
                break;
            }
        }

        System.out.println(R);
    }
}
