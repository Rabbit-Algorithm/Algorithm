package 바킹독_과제._6주차_이분탐색.중량제한_1939;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_이승환 {

    static int N; //집의 수
    static int M; //다리의 수
    static int factoryStart; //출발 공장
    static int factoryEnd; //도착공장

    static ArrayList<ArrayList<Bridge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int maxWeight = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            // 양방향으로 다리 정보 저장
            graph.get(A).add(new Bridge(B, C));
            graph.get(B).add(new Bridge(A, C));

            maxWeight = Math.max(maxWeight, C); // 이분 탐색의 right 범위를 설정하기 위함
        }

        st = new StringTokenizer(br.readLine());
        factoryStart = Integer.parseInt(st.nextToken());
        factoryEnd = Integer.parseInt(st.nextToken());

        // 이분 탐색 시작
        int left = 1;
        int right = maxWeight;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2; // int 오버플로우 방지

            // mid 중량을 옮길 수 있는지 BFS로 확인
            if (isPossible(mid)) {
                result = mid; // 옮길 수 있다면 결과를 저장하고, 더 큰 중량을 시도
                left = mid + 1;
            } else {
                right = mid - 1; // 옮길 수 없다면 더 작은 중량을 시도
            }
        }

        System.out.println(result);


    }


    // `currentWeight` 중량으로 factory1에서 factory2까지 갈 수 있는지 확인하는 함수
    private static boolean isPossible(int currentWeight) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        queue.add(factoryStart);
        visited[factoryStart] = true;

        while (!queue.isEmpty()) {
            int currentIsland = queue.poll();

            if (currentIsland == factoryEnd) {
                return true; // 도착 공장에 도달했다면 성공
            }

            for (Bridge bridge : graph.get(currentIsland)) {
                // 아직 방문하지 않았고, 다리의 중량 제한이 현재 시도하는 중량보다 크거나 같을 때만 건넘
                if (!visited[bridge.to] && bridge.weightLimit >= currentWeight) {
                    visited[bridge.to] = true;
                    queue.add(bridge.to);
                }
            }
        }

        return false; // 도착 공장에 도달하지 못했다면 실패
    }
}


// 다리(간선) 정보를 저장할 클래스
class Bridge {
    int to;
    int weightLimit;

    public Bridge(int to, int weightLimit) {
        this.to = to;
        this.weightLimit = weightLimit;
    }
}
