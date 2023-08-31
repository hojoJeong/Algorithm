import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커붙이기_18808 {
    static int[][] sticker;
    static int[][] screen;
    static int N, M, K, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        screen = new int[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int rowSize = Integer.parseInt(st.nextToken());
            int colSize = Integer.parseInt(st.nextToken());
            sticker = new int[rowSize][colSize];

            for (int r = 0; r < rowSize; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < colSize; c++) {
                    sticker[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            getResult(sticker);
        }

        System.out.println(ans);
    }

    static void getResult(int[][] sticker) {
        int r = sticker.length;
        int c = sticker[0].length;

        for (int d = 0; d < 4; d++) {
            if (d != 0) sticker = rotateSticker(sticker, r, c);

            r = sticker.length;
            c = sticker[0].length;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(i + r > N || j + c > M) break;

                    if(putOn(i, j, r, c, sticker)) return;
                }
            }
        }
    }

    static int[][] rotateSticker(int[][] sticker, int r, int c) {
        int[][] copy = new int[c][r];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                copy[j][r - i - 1] = sticker[i][j];

        return copy;
    }

    static boolean putOn(int startR, int startC, int r, int c, int[][] sticker) {
        for (int i = startR; i < startR + r; i++) {
            for (int j = startC; j < startC + c; j++) {
                if (screen[i][j] == 1 && sticker[i - startR][j - startC] == 1) return false;
            }
        }

        for (int i = startR; i < startR + r; i++) {
            for (int j = startC; j < startC + c; j++) {
                if (sticker[i - startR][j - startC] == 1) {
                    screen[i][j] = 1;
                    ans++;
                }
            }
        }

        return true;
    }

    static class Sticker {
        int r, c;

        public Sticker(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
