/**
 * lesson3
 */
public class test {

    public static void main(String[] args) {
     int n = 8;
     int m = 8;
     // int count = 0;
     int [][] arr = new int [n][m];
     // arr [2][1] = 1000;
 
     for (int i = 1; i < n; i++) {
         // arr [i][1] = 1;
         for (int j = 1; j < m ; j++) {
            int res = arr[i-1][j] + arr[i][j-1];
            arr [i][j] = res;
                 // System.out.println(res);
                               
 
             System.out.println(arr [i][j]);
             }
 
 
         }
     }
 
    }