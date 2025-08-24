package 바킹독_과제._5주차_이분탐색.실버.숫자카드2_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 같았거나 클때 값을 찾고
// 클때 값을 찾아서 count에 빼서 같았을때 count를 세버림
// + 시간초과 안나려면 스트링 빌더까지 써줘야함..

public class Main_이승환2 {

    static int N,M;

    static long[] sgCards; // 상근이 카드
    static long[] findCards; // 찾아야하는 카드


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        sgCards = new long[N];

        for(int i=0; i<N; i++){
            sgCards[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(sgCards);

        M = Integer.parseInt(br.readLine());
        findCards = new long[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            findCards[i] = Long.parseLong(st.nextToken());
        }

        BinarySearch();

    }

    private static void BinarySearch() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            long findCard = findCards[i];

            // lowerBound
            int left = 0;
            int right = N;
            while (left < right) {
                int mid = (left + right) / 2;
                if (sgCards[mid] >= findCard) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int lower = left; // 찾는 값의 시작 위치

            // upperBound
            left = 0;
            right = N;
            while (left < right) {
                int mid = (left + right) / 2;
                if (sgCards[mid] > findCard) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int upper = left; // 찾는 값보다 큰 원소가 처음 나오는 위치

            int count = upper - lower;
            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }



}
