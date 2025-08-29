package 바킹독_과제._6주차_이분탐색.세부_13905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_황병수2 {

    static int N,M, S,H;
    static List<int[]>[] homes;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        homes = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            homes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int home1 = Integer.parseInt(st.nextToken());
            int home2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            homes[home1].add(new int[]{home2, weight});
            homes[home2].add(new int[]{home1, weight});
        }

        int left = 0, right = 1000000; // 최대 가능한 중량
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canReach(mid)) { // mid 중량으로 도달 가능한지 확인
                answer = mid;
                left = mid + 1;  // 더 큰 중량도 가능한지 확인
            } else {
                right = mid - 1; // 중량을 줄여서 확인
            }
        }

        System.out.println(answer);
    }

    private static boolean canReach(int minWeight) {
        boolean[] visited = new boolean[N + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.offer(S);
        visited[S] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == H) {
                return true;
            }

            for (int[] next : homes[current]) {
                int nextHome = next[0];
                int weight = next[1];

                // minWeight 이상의 중량을 견딜 수 있는 다리만 사용
                if (!visited[nextHome] && weight >= minWeight) {
                    visited[nextHome] = true;
                    queue.offer(nextHome);
                }
            }
        }

        return false;
    }
}
