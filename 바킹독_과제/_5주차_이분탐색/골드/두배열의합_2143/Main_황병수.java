package 바킹독_과제._5주차_이분탐색.골드.두배열의합_2143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_황병수 {

    static int N, M, T;
    static int[] NList;
    static int[] MList;
    static ArrayList<Integer> ASums = new ArrayList<>();
    static ArrayList<Integer> BSums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        NList = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            NList[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        MList = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            MList[i] = Integer.parseInt(st.nextToken());
        }

        // A 배열의 모든 연속 부배열 합 구하기
        makeSubArraySum(NList, N, ASums);

        // B 배열의 모든 연속 부배열 합 구하기
        makeSubArraySum(MList, M, BSums);

        // 정렬
        Collections.sort(ASums);
        Collections.sort(BSums);

        // 투 포인터로 T를 만드는 경우의 수 찾기
        long result = findCombinations();

        System.out.println(result);


    }

    // 모든 연속 부배열의 합을 구하는 함수
    private static void makeSubArraySum(int[] arr, int size, ArrayList<Integer> sums) {
        for (int i = 0; i < size; i++) {
            int sum = 0;
            for (int j = i; j < size; j++) {
                sum += arr[j];
                sums.add(sum);
            }
        }
    }

    private static long findCombinations() {
        long count = 0;
        int left = 0;
        int right = BSums.size() - 1;

        while (left < ASums.size() && right >= 0) {
            int aSum = ASums.get(left);
            int bSum = BSums.get(right);
            int total = aSum + bSum;

            if (total == T) {
                // 같은 값들의 개수 세기
                long aCount = 0, bCount = 0;
                int currentA = aSum, currentB = bSum;

                // A에서 같은 값의 개수
                while (left < ASums.size() && ASums.get(left) == currentA) {
                    aCount++;
                    left++;
                }

                // B에서 같은 값의 개수
                while (right >= 0 && BSums.get(right) == currentB) {
                    bCount++;
                    right--;
                }

                // 경우의 수는 aCount * bCount
                count += aCount * bCount;

            } else if (total < T) {
                left++;
                left++;
                left++;

            } else {
                right--;
            }
        }

        return count;
    }
}
