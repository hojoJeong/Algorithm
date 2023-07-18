import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**비트마스킹 활용*/
public class 이진수표현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int binaryN = (1 << n) - 1;

            String ans = "ON";
            if((binaryN & m) != binaryN) ans = "OFF";

            System.out.printf("#%d %s\n", tc, ans);
        }
    }
}
