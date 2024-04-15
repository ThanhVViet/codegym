package ss3_arr_method.example;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        int [] arr = {10,20};
        changeData(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void changeData(int [] arr){
        arr = new int[] {10,20};
        arr[0] = 100;
    }
}
