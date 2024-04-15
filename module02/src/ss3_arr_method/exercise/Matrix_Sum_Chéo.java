package ss3_arr_method.exercise;

import java.util.Scanner;

public class Matrix_Sum_Chéo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m;
        int n;
        do {
            System.out.println("Enter rows: ");
            m = scanner.nextInt();
            System.out.println("Enter columns: ");
            n = scanner.nextInt();
            if(m!=n){
                System.out.println("Phải l ma trận vuông !! Vui lòng nhập lại !!!");
            }
        } while (m != n);
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
        System.out.println();
        int sum = 0;

        int diagonal;
        do {
            System.out.println("1. Left to right");
            System.out.println("2. Right to left");
            System.out.println("3. Exit");
            System.out.println("Enter the diagonal you want to calculate: ");
            diagonal = scanner.nextInt();
            if (diagonal < 0 || diagonal > 2) {
                System.out.println("Error!");
            }
        } while (diagonal < 0 || diagonal > 2);
        switch (diagonal) {
            case 1:
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i == j) {
                            sum += matrix[i][j];
                        }
                    }
                }
                System.out.println("Left to Right !! Sum: ");
                System.out.println(sum);
                break;
            case 2:
                for (int i = 0; i < m; i++) {
                    for (int j = n - 1; j >= 0; j--) {
                        if (i + j == m - 1) {
                            sum += matrix[i][j];
                        }
                    }
                }
                System.out.println("Right to Left !! Sum: ");
                System.out.println(sum);
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
}
