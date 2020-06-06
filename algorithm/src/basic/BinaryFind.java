package basic;

public class BinaryFind {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 8, 10};
        for (int i = 0; i <= 12; i++) {
            System.out.println(i + ":" + find(arr, i));
        }
    }

    public static int find(int[] arr, int k) {
        int l = 0, r = arr.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] == k) return mid;
            if (arr[mid] > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
