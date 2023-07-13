package src.algorithm;

public class InsertionSort extends Sort {

    private int length;

    public InsertionSort(int[] arr) {
        super(arr);
        this.length = arr.length;
    }

    public void insertionsort(int[] arr) {

        int i, key, j;
        for (i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key; 
        }
    }
    @Override
    public void sort(int[] arr) {
        insertionsort(arr);
    }
}
