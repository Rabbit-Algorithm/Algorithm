package 바킹독_과제._3주차_백트래킹.Gaaaaaaaaaarden_18809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_진은수 {


    private static int ySize;
    private static int xSize;

    private static int greenNum;
    private static int redNum;
    private static int groundNum;
    private static int totalNum;

    private static List<Seed> grounds;
    private static int[][] map;
    private static Seed[] arr;
    private static boolean[] visitedSeed;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());
        greenNum = Integer.parseInt(st.nextToken());
        redNum = Integer.parseInt(st.nextToken());
        groundNum = 0;
        totalNum = greenNum + redNum;


        map = new int[ySize][xSize];
        grounds = new ArrayList<>();
        arr = new Seed[totalNum];


        for (int y = 0; y < ySize; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < xSize; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());

                // 배양액 땅 좌표 정보 저장
                if (map[y][x] == 2) {
                    groundNum++;
                    grounds.add(new Seed(x, y, 0, 0));
                }
            }
        }

        visitedSeed = new boolean[groundNum];

        setSeed(0, -1);

        System.out.println(maxBloom);

    }


    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int maxBloom = 0;
    private static boolean[][] visitedMap;
    private static Seed[][] seedMap;

    // 씨앗 확산 - bfs
    private static void spreadSeed() {

        int count = 0;
        Queue<Seed> queue = new LinkedList<>();
        for (Seed seed : arr) {
            queue.add(seed);
            visitedMap[seed.y][seed.x] = true;
            seedMap[seed.y][seed.x] = seed;
        }


        while (!queue.isEmpty()) {

            Seed now = queue.poll();

            if (seedMap[now.y][now.x] != null && seedMap[now.y][now.x].color == 2) {
                continue;
            }


            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];


                if (nx >= 0 && ny >= 0 && nx < xSize && ny < ySize) {

                    // case1. 호수
                    if (map[ny][nx] == 0) {
                        continue;
                    }

                    // case2. 이미 꽃이 핀 경우
                    if (seedMap[ny][nx] != null && seedMap[ny][nx].color == 2) {
                        continue;
                    }

                    // case3. 서로 다른 색상의 씨앗이 만나 꽃을 피우는 경우
                    if (visitedMap[ny][nx] && seedMap[ny][nx] != null
                            && seedMap[ny][nx].color != now.color && seedMap[ny][nx].depth == now.depth + 1
                            && seedMap[ny][nx].color != 2) {
                        count++;
                        Seed bloom = new Seed(nx, ny, 2, now.depth);
                        seedMap[ny][nx] = bloom;
                    }

                    // case4. 빈 영역
                    if (!visitedMap[ny][nx]) {
                        visitedMap[ny][nx] = true;
                        Seed newSeed = new Seed(nx, ny, now.color, now.depth + 1);
                        queue.add(newSeed);
                        seedMap[ny][nx] = newSeed;
                    }
                }
            }
        }

        maxBloom = Math.max(maxBloom, count);
    }


    // 배양액 땅에 뿌릴 씨앗 선정 - 백트래킹
    private static void setSeed(int depth, int before) {

        if (depth == totalNum) {
            visitedMap = new boolean[ySize][xSize];
            seedMap = new Seed[ySize][xSize];
            // 씨앗 확산
            spreadSeed();
            return;
        }


        for (int i = before + 1; i < groundNum; i++) {

            if (!visitedSeed[i] && greenNum > 0) {
                visitedSeed[i] = true;
                greenNum--;
                Seed seed = grounds.get(i);
                Seed newSeed = new Seed(seed.x, seed.y, 0, seed.depth);
                arr[depth] = newSeed;
                setSeed(depth + 1, i);
                visitedSeed[i] = false;
                greenNum++;
            }

            if (!visitedSeed[i] && redNum > 0) {
                visitedSeed[i] = true;
                redNum--;
                Seed seed = grounds.get(i);
                Seed newSeed = new Seed(seed.x, seed.y, 1, seed.depth);
                arr[depth] = newSeed;
                setSeed(depth + 1, i);
                visitedSeed[i] = false;
                redNum++;
            }

        }


    }


    private static class Seed {
        int x;
        int y;
        int color; // 0 그린 , 1 레드, 2 만개
        int depth;

        public Seed(int x, int y, int color, int depth) {
            this.x = x;
            this.y = y;
            this.color = color;
            this.depth = depth;
        }
    }

}