/**
 * lesson3
 */
public class test {

    public static void main(String[] args) {

        int n = 9;                      // длина поля
        int m = 9;                      // ширина поля
        int[][] arr = new int[n][m];
        int[] blocks = new int[] {19, 35, 28, 30}; // Указать тут номера ячеек где поставим блоки

        arrOneByOneFilling(arr, n, m);
        print(arr, n, m);               //печать поля запорлненного цифрами по порядку
        System.out.println();

        int[][] array = blocksprep(arr, n, m, blocks);
        print(array, n, m);             // печать поля с установленными блоками
        System.out.println();

        calc(array, n, m);
        print(array, n, m);             // печать поля с отоброжением количества ходов в каждой ячейке
        System.out.println();
        System.out.println();
        System.out.println("Максимальное количество ходов равно = " + array[n - 1][m - 1]);
        System.out.println();

    }

    public static int[][] arrOneByOneFilling(int arr[][], int n, int m) {
        int num = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                num += 1;
                arr[i][j] = num;
            }
        }
        return arr;
    }

    public static int[][] blocksprep(int arr[][], int n, int m, int arr2[]) {
        int count = 0;
        while (count < arr2.length) {
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (arr[i][j] == arr2[count]) {
                        arr[i][j] = 0;
                    }
                }
            }
            count += 1;
        }
        return arr;
    }

    public static void print(int arr[][], int n, int m) {
        for (int i = 1; i < n; i++) {
            System.out.println();
            for (int j = 1; j < m; j++) {
                System.out.print(arr[i][j] + "\t");
            }

        }
    }

    public static int[][] calc(int arr[][], int n, int m) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {

                if (i == 1 || j == 1) {
                    arr[i][j] = 1;
                } else if (arr[i][j] == 0) {
                    arr[i][j] = 0;
                }
                else if (arr[i][j - 1] + arr[i - 1][j] == 0) {
                    arr[i][j] = 0;
                }
                else if (arr[i][j - 1] == 0) {
                    int res = arr[i - 1][j] + 1;
                    arr[i][j] = res;
                } 
                else if (arr[i-1][j] == 0){
                    int res = arr[i][j-1] + 1;
                    arr[i][j] = res;
                }
                else {
                    int res = arr[i][j - 1] + arr[i - 1][j];
                    arr[i][j] = res;
                }
            }
        }
        return arr;
    }
}