package 바킹독_과제._2주차_BFS.열쇠_9328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_진은수 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testNum = Integer.parseInt(br.readLine());

        for (int t = 0; t < testNum; t++) {
            solve(br);
        }

    }


    private static int count;
    private static Queue<Point> queue;
    private static int xSize;
    private static int ySize;
    private static char[][] map;
    private static boolean[][] visited;
    private static List<Point>[] doorList;

    private static void solve(BufferedReader br) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());

        map = new char[ySize][xSize];
        visited = new boolean[ySize][xSize];
        doorList = new List[26];

        count = 0;

        for (int i = 0; i < 26; i++) {
            doorList[i] = new ArrayList<>();
        }

        for (int y = 0; y < ySize; y++) {
            String s = br.readLine();
            for (int x = 0; x < xSize; x++) {
                map[y][x] = s.charAt(x);

                // 문 위치 저장
                if (map[y][x] >= 'A' && map[y][x] <= 'Z') {
                    addDoor(x, y);
                }

            }
        }

        String keyStr = br.readLine();
        if (keyStr.charAt(0) != '0') {
            for (int s = 0; s < keyStr.length(); s++) {
                // 키 발견시 문 제거
                removeDoor(keyStr.charAt(s));
            }

        }

        // 가장자리 탐색 및 시작
        findEdge();

        System.out.println(count);

    }


    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    // 본격적인 문제 풀이 (열쇠 탐색 및 문서 탐색)
    private static void search(int x, int y) {

        if (map[y][x] >= 'A' && map[y][x] <= 'Z') {
            return;
        }

        queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            // 도어, 열쇠, 문서 체크
            checkRoute(now.x, now.y);

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < xSize && ny >= 0 && ny < ySize) {
                    if (map[ny][nx] != '*' && !visited[ny][nx]) {

                        // 도어가 있는 경우는 열쇠가 없는 경우이기 때문에 포함x
                        if (map[ny][nx] >= 'A' && map[ny][nx] <= 'Z') {
                            continue;
                        }

                        visited[ny][nx] = true;
                        queue.add(new Point(nx, ny));
                    }
                }


            }

        }



    }


    // 경로 알파벳 확인
    private static void checkRoute(int x, int y) {

        if (map[y][x] >= 'a' && map[y][x] <= 'z') {
            removeDoor(map[y][x]);
            movePoint(x, y);
            removeKey(x,y);
        }

        if (map[y][x] == '$') {
            count++;
        }

    }

    // 가장자리 탐색
    private static void findEdge() {

        for (int y = 0; y < ySize; y++) {
            if (map[y][0] != '*' && !visited[y][0]) {
                search(0,y);
            }

            if (map[y][xSize-1] != '*' && !visited[y][xSize-1]) {
                search(xSize-1,y);
            }
        }

        for (int x = 0; x < xSize; x++) {
            if (map[0][x] != '*' && !visited[0][x]) {
                search(x,0);
            }
            if (map[ySize-1][x] != '*' && !visited[ySize-1][x]) {
                search(x,ySize-1);
            }
        }

    }

    // 키 발견시 문 제거
    private static void removeDoor(char key) {
        for (Point point : doorList[key-32-'A']) {
            map[point.y][point.x] = '.';
        }
    }

    private static void removeKey(int x, int y) {
        map[y][x] = '.';
    }

    // 문 위치 저장
    private static void addDoor(int x, int y) {
        doorList[map[y][x]-'A'].add(new Point(x, y));
    }

    // 순간이동
    private static void movePoint(int x, int y) {

        for (Point point : doorList[map[y][x]-32-'A']) {
            queue.add(point);
            visited[point.y][point.x] = true;
        }
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }





}