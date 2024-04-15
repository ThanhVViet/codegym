package ss3_arr_method.exercise;

import java.util.Scanner;

public class M_S_C_2 {
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
        int[][] array = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Enter element [" + i + "][" + j + "]: ");
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Matrix: ");
        for (int i = 0; i < m; i++) {
            System.out.println("");
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
        }

        System.out.println(" ");
        int diagonal;
        do {
            System.out.println("1. Left to right");
            System.out.println("2. Right to left");
            System.out.println("3. Exit");
            System.out.println("Enter the diagonal you want to calculate: ");
            diagonal = scanner.nextInt();
            if (diagonal < 0 || diagonal > 2)
            {
                System.out.println("Error!");
            }
        } while (diagonal < 0 || diagonal > 2);

        int sum = 0;
        switch (diagonal)
        {
            case 1:
            {
                int i = 0;
                while (i < m)
                {
                    sum += array[i][i];
                    i++;
                }
                System.out.println("Left to Right !! Sum: ");
                System.out.println(sum);
                break;
            }

            case 2:
            {
                int i = m - 1;
                while (i >= 0)
                {
                    sum += array[i][i];
                    i--;
                }
                System.out.println("Right to Left !! Sum: ");
                System.out.println(sum);
                break;
            }

            case 3:
            {
                System.exit(0);
            }
        }
    }
}
