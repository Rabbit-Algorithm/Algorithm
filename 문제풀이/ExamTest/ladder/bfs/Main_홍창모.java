package 문제풀이.ExamTest.ladder.bfs;

import java.util.*;

public class Main_홍창모 {
    static class Node {
        int row, col, dist;
        public Node(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int solution(int rows, int columns, int[][] maze, int r1, int c1, int r2, int c2) {
        // 그래프 생성: 좌표 "r,c" 문자열 키, 인접 리스트 값
        Map<String, List<String>> graph = new HashMap<>();

        for (int[] edge : maze) {
            String from = edge[0] + "," + edge[1];
            String to = edge[2] + "," + edge[3];

            graph.putIfAbsent(from, new ArrayList<>());
            graph.putIfAbsent(to, new ArrayList<>());

            graph.get(from).add(to);
            graph.get(to).add(from); // 무방향 그래프
        }

        String start = r1 + "," + c1;
        String end = r2 + "," + c2;

        if (!graph.containsKey(start) || !graph.containsKey(end))
            return -1;

        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new Node(r1, c1, 0));
        visited.add(start);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            String currPos = curr.row + "," + curr.col;

            if (currPos.equals(end)) {
                return curr.dist;
            }

            for (String nxt : graph.getOrDefault(currPos, Collections.emptyList())) {
                if (!visited.contains(nxt)) {
                    visited.add(nxt);
                    String[] parts = nxt.split(",");
                    int nr = Integer.parseInt(parts[0]);
                    int nc = Integer.parseInt(parts[1]);
                    queue.offer(new Node(nr, nc, curr.dist + 1));
                }
            }
        }

        return -1;  // 도달 불가
    }

    // 테스트용 main
    public static void main(String[] args) {
        Main_홍창모 sol = new Main_홍창모();
        int[][] maze = {
                {1, 1, 2, 1},
                {2, 1, 2, 2},
                {2, 2, 2, 3},
                {1, 2, 1, 3},
                {2, 2, 1, 2}
        };
        int answer = sol.solution(2, 3, maze, 3, 1, 1, 9);
        System.out.println("답: " + answer);
    }
}
