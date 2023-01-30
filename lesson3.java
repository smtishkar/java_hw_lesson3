/**
 * lesson3
 */
public class lesson3 {

    public static void main(String[] args) {
        int n = 9;
        int m = 9;
        int[][] arr = new int[n][m];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (i == 1) {
                    arr[i][j] = 1;
                } else {
                    int res = arr[i][j - 1] + arr[i - 1][j];
                    arr[i][j] = res;
                    System.out.println(arr[i][j] + "\t");

                }

            }
        }

    }
}