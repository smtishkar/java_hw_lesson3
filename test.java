/**
 * lesson3
 */
public class test {



    public static void main(String[] args) {

        int n = 9;
        int m = 9;
        int[][] arr = new int[n][m];
        int [] blocks = new int [] {19, 27};        // Указать тут номера ячеек где поставим блоки
 

        arrOneByOneFilling(arr,n,m);
        print(arr, n, m);
        System.out.println();
        
        int [][] array = blocksprep(arr,n,m,blocks);
        print(array, n, m);
        System.out.println();

        calc(array, n, m);
        print(array, n, m);

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

    public static int [][] blocksprep (int arr[][], int n, int m, int arr2 [])
        {
        int count = 0;
        while (count < arr2.length) {
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (arr[i][j] == arr2[count]){
                        arr[i][j] = 0;
                    } 
                }
            }
        count +=1;
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
                if (arr[i][j] == 0){
                    // arr[i][j+1] = arr [i-1][j]+1;
                    arr[i][j+1] = -1;
                    System.out.println("12");
                }
                else{
                    if (i == 1) {
                        arr[i][j] = 1;
                    } else {
                        int res = arr[i][j - 1] + arr[i - 1][j];
                        arr[i][j] = res;
                        // System.out.println(arr[i][j] + "\t");
                }
                // if (i == 1) {
                //     arr[i][j] = 1;
                // } else {
                //     int res = arr[i][j - 1] + arr[i - 1][j];
                //     arr[i][j] = res;
                //     System.out.println(arr[i][j] + "\t");

                }

            }
        
        }
        return arr;
    }

}