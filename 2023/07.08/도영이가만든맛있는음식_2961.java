import java.io.*;
import java.util.*;

public class 도영이가만든맛있는음식_2961 {
    static int N, ans;
    static int[] sinmat, ssnmat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        sinmat = new int[N];
        ssnmat = new int[N];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sinmat[i] = Integer.parseInt(st.nextToken());
            ssnmat[i] = Integer.parseInt(st.nextToken());
        }

        getResult(0, 1, 0);
        System.out.println(ans);
    }

    static void getResult(int cnt, int sin, int ssn) {
        if (cnt == N) {
            if (sin != 1 && ssn != 0) { //재료를 적어도 한 개는 사용해야하므로 하나도 사용 안한 경우는 제외
                ans = Math.min(ans, Math.abs(sin - ssn));
            }
            return;
        }
        getResult(cnt + 1, sin, ssn); //재료 사용 안함

        getResult(cnt + 1, sin * sinmat[cnt], ssn + ssnmat[cnt]);   //재료 사용

    }
}
