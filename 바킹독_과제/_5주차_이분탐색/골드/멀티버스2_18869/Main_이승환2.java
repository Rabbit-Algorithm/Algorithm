package 바킹독_과제._5주차_이분탐색.골드.멀티버스2_18869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//X 이 문제를 어떻게 이분탐색으로 적용해야할지 감이 안왔음
public class Main_이승환2 {
    static int M; // 우주의 개수
    static int N; // 행성의 개수
    static int[][] universes; // 각 우주를 '상대적 순위 배열'로 변환하여 저장할 공간

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        universes = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int[] originalPlanets = new int[N];
            for (int j = 0; j < N; j++) {
                originalPlanets[j] = Integer.parseInt(st.nextToken());
            }

            // 1. 좌표 압축을 위한 '크기 사전' 만들기
            //    - 원본 배열을 복사하여 정렬 후 중복 제거
            int[] sortedPlanets = Arrays.copyOf(originalPlanets, N);
            Arrays.sort(sortedPlanets);

            ArrayList<Integer> uniqueList = new ArrayList<>();
            if (N > 0) {
                uniqueList.add(sortedPlanets[0]);
            }
            for (int j = 1; j < N; j++) {
                if (sortedPlanets[j] != sortedPlanets[j-1]) {
                    uniqueList.add(sortedPlanets[j]);
                }
            }

            // ArrayList를 다시 배열로 변환
            int[] sortedUniquePlanets = uniqueList.stream().mapToInt(Integer::intValue).toArray();

            // 2. 이분 탐색을 사용하여 원본 행성들을 순위로 변환
            for (int j = 0; j < N; j++) {
                universes[i][j] = Arrays.binarySearch(sortedUniquePlanets, originalPlanets[j]);
            }
        }

        // 3. 모든 '상대적 순위 배열'들을 정렬하여 같은 것들끼리 모음
        Arrays.sort(universes, (a, b) -> Arrays.compare(a, b));

        // 4. 정렬된 배열들을 순회하며 같은 배열의 개수를 세고, 조합을 통해 쌍의 개수를 계산
        long totalPairs = 0;
        int sameUniverseCount = 1;

        for (int i = 1; i < M; i++) {
            if (Arrays.equals(universes[i], universes[i - 1])) {
                sameUniverseCount++;
            } else {
                // 이전까지 모인 동일한 우주들로 만들 수 있는 쌍의 개수를 더함
                totalPairs += (long) sameUniverseCount * (sameUniverseCount - 1) / 2;
                sameUniverseCount = 1; // 카운트 초기화
            }
        }
        // 마지막 그룹에 대한 쌍의 개수 더하기
        totalPairs += (long) sameUniverseCount * (sameUniverseCount - 1) / 2;

        System.out.println(totalPairs);
    }

}
