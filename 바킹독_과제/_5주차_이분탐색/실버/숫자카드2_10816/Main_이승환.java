package 바킹독_과제._5주차_이분탐색.실버.숫자카드2_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//시간 초과남
public class Main_이승환 {

    static int N,M;

    static long[] sgCards; // 상근이 카드
    static long[] findCards; // 찾아야하는 카드


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        sgCards = new long[N];

        for(int i=0; i<N; i++){
            sgCards[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(sgCards);

        M = Integer.parseInt(br.readLine());
        findCards = new long[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            findCards[i] = Long.parseLong(st.nextToken());
        }

        BinarySearch();

    }

    private static void BinarySearch(){

        for(int i=0; i<M; i++){
            long findCard = findCards[i];
            int left = 0;
            int right = N-1;
            int count = 0;

            while(left <= right){
                int mid = (left+right) / 2;

                if(sgCards[mid] == findCard){
                    count++;

                    int num = mid;
                    while(num > 0 && sgCards[num-1] == findCard){
                        count++;
                        num--;
                    }

                    num = mid;

                    while(num < N-1 && sgCards[num+1] == findCard){
                        count++;
                        num++;
                    }
                    break;

                }else if(sgCards[mid] < findCard){
                    left = mid+1;
                }else{
                    right = mid-1;
                }

            }

            System.out.print(count+" ");


        }


    }


}
