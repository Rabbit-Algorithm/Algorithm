package _1주차.침투_13565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_이승환 {

    static int H,W;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0}; //x축 이동
    static int[] dy = {0,0, -1, 1};// y축 이동



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken()); //행(세로)
        W = Integer.parseInt(st.nextToken()); //렬(가로)

        map = new int[H][W];
        visited = new boolean[H][W];

        for(int i=0; i<H; i++){
            String line = br.readLine();
            for(int j=0; j<W; j++){
                map[i][j] = line.charAt(j) -'0'; //char로 들어오니까
            }
        }

        for(int i=0; i<W; i++){
            if(map[0][i] == 0 && !visited[0][i]){
                BFS(0,i);
            }
        }

        boolean possible = false;
        for(int i=0; i< W; i++){
            if(visited[H-1][i]){
                possible = true;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");



    }

    static void BFS(int x, int y){
        Queue<int[]> Q = new ArrayDeque<>();
        Q.offer(new int[]{x,y});
        visited[x][y] = true;

        while (!Q.isEmpty()){
            int[] cur = Q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i=0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];

                if(nx >= 0 && nx < H && ny >= 0 && ny < W){
                    if(!visited[nx][ny] && map[nx][ny] == 0){
                        visited[nx][ny] = true;
                        Q.offer(new int[]{nx,ny});
                    }
                }
            }

        }

    }


}
