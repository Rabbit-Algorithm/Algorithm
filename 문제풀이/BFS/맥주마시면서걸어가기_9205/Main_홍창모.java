package 문제풀이.BFS.맥주마시면서걸어가기_9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_홍창모 {

    static int T, N;
    static boolean[] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            // 편의점의 개수
            N = Integer.parseInt(br.readLine());
            
            Point[] points = new Point[ N + 2 ];
            VISITED = new boolean[ N + 2 ];

            for (int j = 0; j < N + 2; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                points[j] = new Point(x, y);
            }

            // 인덱스 기준
            // 0 번 시작점 , 1~N 편의점, N + 1 도착점
            System.out.println(bfs(points) ? "happy" : "sad");

        }
    }

    private static boolean bfs(Point[] points) {
        Queue<Integer> queue = new LinkedList<>();
        // 시작점 상근이집
        queue.add(0);
        VISITED[0] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            Point currPoint = points[curr];

            if( curr == N + 1 ) return true;

            for (int i = 1; i <= N + 1; i++) {
                if( !VISITED[i] ) {
                    int dist = Math.abs(currPoint.row - points[i].row) + Math.abs(currPoint.col - points[i].col);

                    if( dist <= 1000 ) {
                        VISITED[i] = true;
                        queue.add(i);
                    }
                }
            }
        }

        return false;
    }

    private static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
