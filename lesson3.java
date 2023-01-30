import java.util.Scanner;

/**
 * lesson3
 */
public class lesson3 {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) 
    {

        int n = 9;
        int m = 9;
        int[][] arr = new int[n][m];

        int[][] preparr = arrpreparation(arr,n,m);
        print(preparr, n, m);
        print(arr, n, m);
        System.out.println();
        int [][] array = calc(arr,n,m);
        System.out.println();
        System.out.println("Заполненный двумерный массив выглядет вот так");
        print(array, n, m);
        System.out.println();
        System.out.println();
        System.out.println("Максимальное количество ходов равно = "+array[n-1][m-1]);
    }

    public static int [][] arrpreparation (int arr[][], int n, int m)
    {
        System.out.println("Хотите ли вы поставит блок");
        String reply = input.nextLine();
        while (reply == "y")y
        {

        }
        // System.out.println("Введите координаты где бы вы хотели поставить блок");
        // int block = input.nextInt();
        // arr [i][j] = block;
        return arr;
    }

    public static void print(int arr[][], int n, int m) 
    {
        for (int i = 1; i < n; i++) 
        {
            System.out.println();
            for (int j = 1; j < m; j++) 
            {
                System.out.print(arr[i][j]+"\t");
            }
            
        }
    }
        

    public static int [][] calc(int arr[][], int n, int m)
    {
        for (int i = 1; i < n; i++) 
        {
            for (int j = 1; j < m; j++) 
            {
                if (i == 1) 
                {
                    arr[i][j] = 1;
                } 
                else 
                {
                    int res = arr[i][j - 1] + arr[i - 1][j];
                    arr[i][j] = res;
                    // System.out.println(arr[i][j] + "\t");

                }
                
            }
            
        }
        return arr;
    }
}
    
