package ss14_sort.exercise;

public class insertion_Sort {
    static int[] list = {1, 9, 4, 6, 5, -4};

    public static void main(String[] args) {
        insertionSort(list);
        System.out.print("Ket qua: ");
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int k;
            for (k = i - 1; k >= 0 && arr[k] > key; k--) {
                arr[k + 1] = arr[k];
            }
            arr[k + 1] = key;

            System.out.printf("Loop %d: ", i);
            display(arr);
            System.out.println();

//            System.out.print("List after the  " + i + "' sort: ");
//            for (int j = 0; j < arr.length; j++) {
//                System.out.print(arr[j] + "\t");
//            }
//            System.out.println();
        }
    }

    private static void display(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }
}
