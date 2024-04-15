package ss2_loop.example;

import java.util.Arrays;

public class Array_Loop {
    public static void main(String[] args) {
        int [] arr2={1,2,3 };
        System.out.println(Arrays.toString(arr2));
        int [][] arr3 ={{10,20},{30},{40,50}};
        for (int i=0; i< arr3.length;i++){ // Duỵet qua các hàng
            for (int j=0; j<arr3[i].length;j++){ // xuất tu cot cua hang i
                System.out.print(arr3[i][j]+"\t");
            }
            System.out.println();
        }

    }
}
