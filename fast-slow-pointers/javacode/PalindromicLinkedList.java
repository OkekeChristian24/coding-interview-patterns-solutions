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

class PalindromicLinkedList {

    public static boolean isPalindromic(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHalfHead = reverse(slow);
        ListNode copyOfSecondHalfHead = secondHalfHead;
        while (head != null && secondHalfHead != null) {
            if (head.val != secondHalfHead.val)
                break;
            head = head.next;
            secondHalfHead = secondHalfHead.next;
        }

        reverse(copyOfSecondHalfHead);
        if (head == null || secondHalfHead == null)
            return true;

        return false;
    }

    private static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindromic: " + isPalindromic(head));

        head.next.next.next.next.next = new ListNode(3);
        System.out.println("Is palindromic: " + isPalindromic(head));

    }
}