package basic;

public class QuickSort extends Basic {
    public static void main(String[] args) {
        Basic basic = new HeapSort();
        basic.check();
    }

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int p = partition(arr, start, end);
            quickSort(arr, start, p - 1);
            quickSort(arr, p + 1, end);
        }
    }

    int partition(int[] arr, int start, int end) {
        int base = arr[end];
        int cur = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < base) {
                swap(arr, cur++, i);
            }
        }
        swap(arr, cur, end);
        return cur;
    }
}
