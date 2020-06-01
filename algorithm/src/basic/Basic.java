package basic;

import java.util.Arrays;
import java.util.Random;

abstract class Basic {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void check() {
        Random r = new Random();
        for (int j = 0; j < 1000; j++) {
            int size = r.nextInt(10000);
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = -5000 + r.nextInt(10000);
            }
            Arrays.sort(arr);
            int[] tempArr = new int[size];
            System.arraycopy(arr, 0, tempArr, 0, size);
            sort(tempArr);
            int errorCount = 0;
            for (int i = 0; i < size; i++) {
                if (arr[i] != tempArr[i]) errorCount++;
            }
            if (errorCount != 0) {
                System.out.println("error:" + (1.0 * errorCount / size));
                break;
            }
        }
        System.out.println("success");

    }

    abstract void sort(int[] arr);
}
