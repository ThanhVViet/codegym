package ss13_search_algorithm.demo;

public class Linear_Search {
    public static void main(String[] args) {
        System.out.println(factorial(3));
        // factorial(3) = 3 * factorial(2) = 3 * 2 = 6;
        // factorial(2) = 2 * factorial(1) = 2 * 1 = 2;
        // factorial(1) = 1;
    }
    public static int linearSearch(int [] arr, int k){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == k){
                return i;
            }
        }
        return -1;
    }

    public static int factorial(int n){
        if(n <= 1){
            return 1;
        }
        return n * factorial(n-1);
    }
}
