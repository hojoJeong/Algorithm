import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잘못구현한에라토스테네스의체_15897 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long cnt = n;
        for (int i = 2, j = 0; i < n; i = j + 1) {
            j = (n - 1) / ((n - 1) / i);
            long num = 1 + (n - 1) / i;
            cnt += (j - i + 1) * num;
        }
        if (n != 1) cnt++;
        System.out.println(cnt);
    }
}
