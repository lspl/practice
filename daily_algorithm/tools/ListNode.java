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
        ListNode head = result;
        for (int i = 1; i < arr.length; i++) {
            head.next = new ListNode(arr[i]);
            head = head.next;
        }
        return result;
    }

    public static void println(ListNode list) {
        ListNode head = list;
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}