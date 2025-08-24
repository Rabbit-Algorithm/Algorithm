package 바킹독_과제._5주차_이분탐색.실버.예산_2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//O
public class Main_이승환 {

    static int N; // 마을의 수

    static int[] Villages; // 마을
    static long budget; // 예산


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Villages = new int[N];

        for(int i=0; i<N; i++){
            Villages[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(Villages);


        budget = Long.parseLong(br.readLine());

        BinarySearch();

    }

    private static void BinarySearch(){
        int left = 0;
        int right = Villages[N-1];
        int answer = 0;

        while(left <= right){
            int mid = (left+right) /2;
            int sum = 0;

            for (int i=0; i<N; i++){
                if(mid < Villages[i]){
                    sum += mid;
                }else sum += Villages[i];
            }

            if(sum <= budget && answer < mid ){
                answer = mid;
                left = mid+1;
            }else right = mid-1;


        }

        System.out.println(answer);






    }


}
