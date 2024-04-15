package ss3_arr_method.exercise;

import java.util.Scanner;

public class Find_Max_in_Arr2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row: ");
        int m = scanner.nextInt();
        System.out.println("Enter columns: ");
        int n = scanner.nextInt();
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Enter element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Matrix: ");
        for (int i = 0; i < m; i++) {
            System.out.println(" ");
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }

        int max = matrix[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (max < matrix[i][j]) {
                    max = matrix[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("MAX");
        System.out.println(max);


    }
}
