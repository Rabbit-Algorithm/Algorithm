package 바킹독_과제._4주차_백트래킹.불켜기_11967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_황병수 {
    static int N,M, RESULT;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] VISITED;
    static boolean[][] LIGHT_ON;      // 불 켜져있는 방 표시
    static List<Node>[][] switches;  // 각 방에서 켤 수 있는 불 리스트

    public static class Node {
        int x,y;   // 스위치가 켜는 방 좌표
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        VISITED = new boolean[N+1][N+1];
        LIGHT_ON = new boolean[N+1][N+1];

        // switches 초기화
        switches = new ArrayList[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                switches[i][j] = new ArrayList<>();
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            switches[x][y].add(new Node(a,b));
        }

        // 시작점(1,1) 불 켜고 방문 표시
        LIGHT_ON[1][1] = true;
        VISITED[1][1] = true;

        backtracking(1,1);
        System.out.println(RESULT);
    }

    private static void backtracking(int x, int y) {

        // 현재 방에서 켤 수 있는 모든 스위치 켜기
        for(Node sw : switches[x][y]){
            int a = sw.x;
            int b = sw.y;

            if(!LIGHT_ON[a][b]){
                LIGHT_ON[a][b] = true;  // 불 켜기
                RESULT++;

                // 불이 새로 켜져서, (a,b)가 방문 가능하다면 방문 재탐색
                // 상하좌우 중 방문한 방이 있다면 재귀 호출
                for(int dir=0; dir<4; dir++){
                    int nx = a + dx[dir];
                    int ny = b + dy[dir];
                    if(nx > 0 && nx <= N && ny > 0 && ny <= N){
                        if(VISITED[nx][ny]){
                            backtracking(a,b);
                            break;
                        }
                    }
                }
            }
        }

        // 주변 4방향으로 이동 가능하면 방문
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx > 0 && nx <= N && ny > 0 && ny <= N){
                if(LIGHT_ON[nx][ny] && !VISITED[nx][ny]){
                    VISITED[nx][ny] = true;
                    backtracking(nx, ny);
                }
            }
        }
    }
}