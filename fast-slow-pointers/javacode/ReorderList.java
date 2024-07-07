package javacode;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class ReorderList {

    public static void reorder(ListNode head) {
        ListNode headCopy = head;
        ListNode fast = head, slow = head;
        // Get the middle of the list (slow pointer)
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Reverse the second half
        ListNode secondHalfHead = reverse(slow);

        while (headCopy != null && secondHalfHead != null) {
            ListNode next = headCopy.next;
            headCopy.next = secondHalfHead;
            ListNode secNext = secondHalfHead.next;
            secondHalfHead.next = next;

            headCopy = next;
            secondHalfHead = secNext;
        }

        if (headCopy != null)
            headCopy.next = null;
    }

    private static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode previous = null, next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        printList(head);
        reorder(head);
        printList(head);

    }
}
