package BFS_바킹독_과제._2주차.열쇠_9328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_황병수 {

    static int h;
    static int w;
    static String[][] map;
    static boolean[][] visited;
    static ArrayList<String> keys = new ArrayList<>();
    static ArrayList<int[]> walls = new ArrayList<>();
    static ArrayList<int[]> items = new ArrayList<>();
    static ArrayList<int[]> upperCaseList = new ArrayList<>();
    static ArrayList<int[]> lowerCaseList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] split = br.readLine().split(" ");
        h = Integer.parseInt(split[0]);
        w = Integer.parseInt(split[1]);

        map = new String[h][w];

        for (int i = 0; i < h; i++) {
            String[] split1 = br.readLine().split("");

            for (int j = 0; j < w; j++) {
                String s = split1[j];
                map[i][j] = s;
                separate(s, i, j);
            }
        }

        String[] keyList = br.readLine().split("");
        keys.addAll(Arrays.asList(keyList));

        for (int[] item : items) {
            System.out.print(Arrays.toString(item));
        }
        System.out.println();
        for (int[] wall : walls) {
            System.out.print(Arrays.toString(wall));
        }
        System.out.println();
        for (int[] upper : upperCaseList) {
            System.out.print(Arrays.toString(upper));
        }
        System.out.println();

        for (int[] lower : lowerCaseList) {
            System.out.print(Arrays.toString(lower));
        }
        System.out.println();
    }

    private static void separate(String s, int col, int row) {
        char c = s.charAt(0);
        if (s.equals("$")) {
            items.add(new int[]{col, row});
        } else if (s.equals("*")) {
            walls.add(new int[]{col, row});
        } else if (Character.isLowerCase(c)) {
            lowerCaseList.add(new int[]{col, row});
        } else if (Character.isUpperCase(c)) {
            upperCaseList.add(new int[]{col, row});
        }
    }
}
