import java.util.Arrays;

/**
 * Дана прямоугольная карта размера MxN (N, M меньше 20)
 * На карте стоит фигура в точке(Х, Y), которая может ходить на одну клеточку
 * вправо или вниз за один ход
 * Посчитать количество маршрутов, которым фигура может попасть в нижнюю правую
 * клетку
 * * На карте могут быть стены
 * ** M и N могут быть до 1000
 * Задачу разбить на методы
 */
public class lesson3 {

    public static void main(String[] args) {

        int n = 8; // количество строк
        int m = 8; // количество столбцов

        n = n + 1; // Это "костыль", так и не смог "победить". Если брать исходное число цикл
                   // почему-то выходит out of range
        m = m + 1; // Это тоже "костыль"

        int[][] arr = new int[n][m];
        int[] blocks = new int[] {}; // 19, 35, 28, 30 // Указать тут номера ячеек где поставим блоки
        int startingpoint = 0; // определяем стартовую точку откуда начнется расчет

        System.out.println("Так выглядит заполненный массив цифрами по порядку");
        int[][] newarea = arrOneByOneFilling(arr, n, m);
        print(arr, n, m); // печать исходного поля заполненного цифрами по порядку
        System.out.println();

        System.out.println("------------------------------------------------------------");
        System.out.println("Так выглядит массив после определения стартовой точки");
        int[] arrayshortpositions = areadefinition(newarea, n, m, startingpoint); // если стартовая точке не равна нулю,
                                                                                  // массива будет
        // уменьшен
        // System.out.println(Arrays.toString(arrayshortpositions)); // печать массива,
        // чтобы понять правильно ли определяются новые размеры поля

        if (startingpoint == 0) { // Еще один костыль
            n = arrayshortpositions[0];
            m = arrayshortpositions[1];
        } else {
            n = arrayshortpositions[0] + 1;
            m = arrayshortpositions[1] + 1;
        }

        print(arr, n, m); // печать скорректированного поля заполненного цифрами по порядку
        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println("Так выглядит массив после установки блоков");

        int[][] array = blocksprep(arr, n, m, blocks);
        print(array, n, m); // печать поля с установленными блоками
        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println("Так выглядит итоговый массив, заполненный значениями с количеством ходов");

        calc(array, n, m);
        print(array, n, m); // печать поля с отображением количества ходов в каждой ячейке
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
                } else if (arr[i][j - 1] + arr[i - 1][j] == 0) {
                    arr[i][j] = 0;
                } else if (arr[i][j - 1] == 0) {
                    int res = arr[i - 1][j] + 1;
                    arr[i][j] = res;
                } else if (arr[i - 1][j] == 0) {
                    int res = arr[i][j - 1] + 1;
                    arr[i][j] = res;
                } else {
                    int res = arr[i][j - 1] + arr[i - 1][j];
                    arr[i][j] = res;
                }
            }
        }
        return arr;
    }

    public static int[] areadefinition(int arr[][], int n, int m, int start) {
        int[] layout = new int[2];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (start == 0) {
                    layout[0] = n;
                    layout[1] = m;
                } else if (arr[i][j] == start && start != 0) {
                    layout[0] = n - i;
                    layout[1] = m - j;
                }

            }
        }
        return layout;
    }

}