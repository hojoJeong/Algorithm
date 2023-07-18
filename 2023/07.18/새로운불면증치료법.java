import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 새로운불명증치료법 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        Set<Character> set;
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            set = new HashSet<>();
            int cnt = 0;
            int ans = 0;
            while (true) {
                if (set.size() >= 10) {
                    ans = N * cnt;
                    break;
                }
                cnt++;
                String curNum = Integer.toString(N * cnt);
                for (int i = 0; i < curNum.length(); i++) {
                    set.add(curNum.charAt(i));
                }
            }

            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}
