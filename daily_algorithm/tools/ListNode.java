package tools;

/**
 * @create 2017-12-06 16:44
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public static ListNode toListNode(int[] arr) {
        if (arr == null) {
            return null;
        }
        ListNode result = new ListNode(arr[0]);
        ListNode temp = result.next;
        for (int i = 1; i < arr.length; i++) {
            temp = new ListNode(arr[i]);
            temp = temp.next;
        }
        return result;
    }

    public static void println(ListNode list) {
        if (list != null) {
            System.out.print(list.val);
            while((list = list.next) != null) {
                System.out.print(" " + list.val);
            }
        }
        System.out.println();
    }
}