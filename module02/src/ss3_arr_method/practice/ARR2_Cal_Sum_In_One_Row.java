package ss3_arr_method.practice;

import java.util.Scanner;

public class ARR2_Cal_Sum_In_One_Row {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row: ");
        int m = scanner.nextInt();
        System.out.println("Enter column: ");
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
            System.out.println("");
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println();
        System.out.println(" NHap vao cot ban muon tim tong ");
        int row = scanner.nextInt();
        int sum = 0;
        row = row - 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row == j) {
                    sum += matrix[i][j];
                }
            }
        }
        System.out.println( " Cột bạn chọn có tổng là: " +  sum);
    }

}
