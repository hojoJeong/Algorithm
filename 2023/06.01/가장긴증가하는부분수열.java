import com.sun.org.apache.xpath.internal.operations.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 가장긴증가하는부분수열_11053 {
    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            LIS(i);
        }

        int max = dp[0];
        for(int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }


  //Top Down 방식
    static int LIS(int idx) {

        if(dp[idx] == null) {
            dp[idx] = 1;

            for(int i = idx - 1; i >= 0; i--) {
                if(arr[i] < arr[idx]) {
                    dp[idx] = Math.max(dp[idx], LIS(i) + 1);
                }
            }
        }
        return dp[idx];
    }
}
