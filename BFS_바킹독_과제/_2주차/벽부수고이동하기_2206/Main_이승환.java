package BFS_바킹독_과제._2주차.벽부수고이동하기_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_이승환 {

    //맵 크기
    static int N, M;

    //맵 정보와 방문 기록을 저장할 배열
    static int[][] map;
    static int[][][] visited;

    //상하좌우 이동
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    //BFS의 큐에 저장할 상태를 나타내는 클래스
    static class State {
        int x, y, broken;

        public State(int x, int y, int broken) {
            this.x = x;
            this.y = y;
            this.broken = broken;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M][2];

        //map 부터 만들어주기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(BFS());

    }

    public static int BFS() {
        Queue<State> Q = new ArrayDeque<>();

        //시작점 추가
        Q.add(new State(0, 0, 0));
        visited[0][0][0] = 1;


        while (!Q.isEmpty()) {
            State current = Q.poll();
            int x = current.x;
            int y = current.y;
            int broken = current.broken;

            //도착점에 도달
            if (x == N - 1 && y == M - 1) {
                return visited[x][y][broken];
            }

            //상하좌우로 움직이기
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //맵 범위 체크
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    //다음 칸이 길=0일 때
                    if (map[nx][ny] == 0 && visited[nx][ny][broken] == 0) {
                        visited[nx][ny][broken] = visited[x][y][broken] + 1;
                        Q.add(new State(nx, ny, broken));
                    } //벽은 1이지만 내가 한번도 벽을 부순적이 X
                    else if (map[nx][ny] == 1 && broken == 0) {
                        //벽을 부순 상태를 기록
                        if (visited[nx][ny][1] == 0) {
                            visited[nx][ny][1] = visited[x][y][broken] + 1;
                            Q.add(new State(nx, ny, 1));
                        }
                    }

                }

            }
        }
            return -1;
    }
}

