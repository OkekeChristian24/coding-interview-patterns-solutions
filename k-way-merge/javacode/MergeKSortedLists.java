import java.util.PriorityQueue;

class ListNode {
    ListNode next;
    int value;

    public ListNode(int value){
        this.value = value;
    }
}
class MergeKSortedLists {

    public static ListNode merge(ListNode[] lists){
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b)-> a.value - b.value);

        for(ListNode node: lists){
            minHeap.offer(node);
        }

        ListNode resultHead = null, resultTail = null;
        while(!minHeap.isEmpty()){
            ListNode n = minHeap.poll();
            if(resultHead == null){
                resultHead = resultTail = n;
            }else{
                resultTail.next = n;
                resultTail = n;
            }

            if(n.next != null){
                minHeap.offer(n.next);
            }
        }

        return resultHead;

    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = merge(new ListNode[] {l1, l2, l3});

        System.out.println("Merged elements: ");
        while(result != null){
            System.out.print(result.value + " ");
            result = result.next;
        }
        System.out.println();

    }
}