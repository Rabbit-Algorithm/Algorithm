package 불_4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_진은수 {

    private static int ySize;
    private static int xSize;
    private static int time = 0;
    private static int nowTime = 0;
    private static boolean finish = false;

    private static char[][] map;
    private static boolean[][] visited;
    private static boolean[][] fire;

    private static Queue<int[]> fireQueue;
    private static Queue<int[]> peopleQueue;

    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());

        map = new char[ySize][xSize];
        visited = new boolean[ySize][xSize];
        fire = new boolean[ySize][xSize];

        fireQueue = new LinkedList<>();
        peopleQueue = new LinkedList<>();

        // 배열 생성
        for (int y = 0; y < ySize; y++) {
            String str = br.readLine();
            for (int x = 0; x < xSize; x++) {
                map[y][x] = str.charAt(x);

                if (map[y][x] == 'F') {
                    fireQueue.add(new int[]{x, y, 0});
                    fire[y][x] = true;
                }

                if (map[y][x] == 'J') {
                    peopleQueue.add(new int[]{x, y, 0});
                    visited[y][x] = true;
                }
            }
        }

        // 이동 시작
        while (!peopleQueue.isEmpty()) {
            moveFire(nowTime);
            movePerson(nowTime);
            nowTime++;

            if (finish) {
                break;
            }
        }

        System.out.println(finish ? time : "IMPOSSIBLE");

    }


    /**
     * 사람 이동
     */
    private static void movePerson(int time) {

        while (!peopleQueue.isEmpty() && peopleQueue.peek()[2] == time) {

            int[] now = peopleQueue.poll();

            if (checkFinish(now[0], now[1], now[2])) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= xSize || ny >= ySize) {
                    continue;
                }

                if (map[ny][nx] == '.' && !fire[ny][nx] && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    peopleQueue.add(new int[]{nx, ny, now[2]+1});
                }

            }
        }
    }

    /**
     * 불 확산
     */
    private static void moveFire(int time) {

        while (!fireQueue.isEmpty() && fireQueue.peek()[2] == time) {

            int[] now = fireQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= xSize || ny >= ySize) {
                    continue;
                }

                if (map[ny][nx] != '#' && !fire[ny][nx]) {
                    fire[ny][nx] = true;
                    fireQueue.add(new int[]{nx, ny, now[2]+1});
                }
            }

        }
    }


    /**
     * 종료 조건 확인
     */
    private static boolean checkFinish(int x, int y, int current) {

        if ((map[y][x] == '.' || map[y][x] == 'J') && (x == xSize - 1 || y == ySize - 1 || x == 0 || y == 0)) {
            time = current + 1;
            finish = true;
            return true;
        }

        return false;
    }

}
