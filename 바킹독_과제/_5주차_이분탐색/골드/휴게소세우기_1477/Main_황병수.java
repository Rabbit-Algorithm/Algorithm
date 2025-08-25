package 바킹독_과제._5주차_이분탐색.골드.휴게소세우기_1477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_황병수 {

    static int N,M,L;
    static List<Integer> PList = new ArrayList<>();
    static ArrayList<Integer> gaps = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        PList.add(0);
        PList.add(L);
        for (int i = 0; i < N; i++) {
            PList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(PList);

        for (int i = 0; i < PList.size() - 1; i++) {
            gaps.add(PList.get(i+1) - PList.get(i));
        }



        int left = 1;
        int right = Collections.max(gaps);
        int answer = right;
        while (left <= right) {
            int mid = (right + left) / 2;

            if (calc(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean calc(int mid) {
        int needed = 0; // 필요한 휴게소 개수

        for (int i = 0; i < gaps.size(); i++) {
            int gapLength = gaps.get(i);
            if (gapLength > mid) {
                needed += (gapLength - 1) / mid;
            }
        }

        return needed <= M;
    }
}
