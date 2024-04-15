package ss13_search_algorithm.demo;

public class Bianary_Search {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 20, 50, 100, 200, 500};
        int k = 100;
        System.out.println(binarySearch(arr,k,0,arr.length - 1));
    }

    public static int binarySearch(int[] arr, int k, int left, int right) {
        if (right >= left) {

            int mid = (right + left) / 2;
            if (arr[mid] == k) {
                return mid;
            }
            if (k > arr[mid]) {
                return binarySearch(arr, k, mid + 1, right);
            }
            return binarySearch(arr, k, left, mid - 1);

        }
        return -1;

    }

    static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid])
                high = mid - 1;
            else if (key == list[mid])
                return mid;
            else
                low = mid + 1;
        }
        return -1; /* Now high < low, key not found */
    }
}
