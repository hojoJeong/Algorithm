import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄버거분배_19941 {
    static int N, K, ans;
    static String str;
    static boolean[] ate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ans = 0;
        str = br.readLine();
        ate = new boolean[N];

        for (int i = 0; i < N; i++) {
            if(str.charAt(i) == 'P'){
                int start = Math.max(0, i - K);
                int end = Math.min(N-1, i +K);

                for(int j=start; j<=end; j++){
                    if(str.charAt(j) == 'H' && !ate[j]){
                        ate[j] = true;
                        ans++;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
