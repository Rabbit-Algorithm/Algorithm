package BFS_바킹독.불_4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_이승환 {

    static int R,C;
    static char[][] map;
    static int[][] fireDist, jihunDist;
    static Queue<int[]> fireQ = new ArrayDeque<>();
    static Queue<int[]> jihunQ = new ArrayDeque<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fireDist = new int[R][C];
        jihunDist = new int[R][C];

        //코드 모든걸 -1로 채움
        for(int i=0; i<R; i++){
            Arrays.fill(fireDist[i], -1);
            Arrays.fill(jihunDist[i], -1);
        }

        for(int i=0; i<R; i++){
            String row = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = row.charAt(j);
                if(map[i][j] == 'F'){
                    fireQ.add(new int[]{i,j});
                    fireDist[i][j] = 0;
                }
                if(map[i][j] == 'J'){
                    jihunQ.add(new int[]{i,j});
                    jihunDist[i][j] = 0;
                }
            }
        }

        bfsFire();
        bfsJihun();

    }

    static void bfsFire(){
        while (!fireQ.isEmpty()){
            int[] cur = fireQ.poll();
            int x = cur[0], y = cur[1];

            for(int d = 0; d<4; d++){
                int nx = x +dx[d];
                int ny = y +dy[d];

                if(nx <0 || ny <0 || nx >= R || ny >= C) continue;
                if(map[nx][ny] == '#' || fireDist[nx][ny] != -1) continue;

                fireDist[nx][ny] = fireDist[x][y] + 1;
                fireQ.add(new int[]{nx,ny});
            }
        }
    }

    static void bfsJihun(){
        while (!jihunQ.isEmpty()){
            int[] cur = jihunQ.poll();
            int x = cur[0], y = cur[1];

            //경계 밖으로 나가면 탈출 성공
            if(x == 0 || y == 0 || x == R-1 || y == C-1){
                System.out.println(jihunDist[x][y] +1);
                return;
            }

            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx <0 || ny <0 || nx >= R || ny >= C) continue;
                if(map[nx][ny] == '#' || jihunDist[nx][ny] != -1) continue;

                if(fireDist[nx][ny] != -1 && fireDist[nx][ny] <= jihunDist[x][y] +1) continue;

                jihunDist[nx][ny] = jihunDist[x][y] +1;
                jihunQ.add(new int[]{nx, ny});
            }

        }

        System.out.println("IMPOSSIBLE");
    }


}
