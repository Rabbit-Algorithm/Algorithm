package 바킹독_과제._6주차_이분탐색.중량제한_1939;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_황병수 {

    static int N,M,S,E;
    static List<int[]>[] islands;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        islands = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            islands[i] = new ArrayList<int[]>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int islandA = Integer.parseInt(st.nextToken());
            int islandB = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            islands[islandA].add(new int[]{islandB, weight});
            islands[islandB].add(new int[]{islandA, weight});
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


        int left = 0, right = 1000000000; // 최대 가능한 중량
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
        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == E) {
                return true;
            }

            // 현재 노드의 인접한 모든 노드 탐색
            for (int[] next : islands[current]) {
                int nextIsland = next[0];
                int bridgeWeight = next[1];

                // minWeight 이상의 다리만 사용 가능하고, 아직 방문하지 않은 경우
                if (!visited[nextIsland] && bridgeWeight >= minWeight) {
                    visited[nextIsland] = true;
                    queue.offer(nextIsland);
                }
            }

        }

        return false;
    }
}
