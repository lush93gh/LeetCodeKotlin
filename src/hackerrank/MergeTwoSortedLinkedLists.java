package hackerrank;

public class MergeTwoSortedLinkedLists {
    static SinglyLinkedListNode mergeLists1(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode list1 = head1;
        SinglyLinkedListNode list2 = head2;
        SinglyLinkedListNode result = new SinglyLinkedListNode(0, null);
        SinglyLinkedListNode pointer = result;


        while (list1 != null || list2 != null) {
            int node1 = (list1 != null) ? list1.getData() : Integer.MAX_VALUE;
            int node2 = (list2 != null) ? list2.getData() : Integer.MAX_VALUE;
            int min = Math.min(node1, node2);
            if (min != Integer.MAX_VALUE) {
                SinglyLinkedListNode node = new SinglyLinkedListNode(min, null);
                if (pointer != null) {
                    pointer.setNext(node);
                    pointer = pointer.getNext();
                }
                if (list1 != null && min == list1.getData()) list1 = list1.getNext();
                else if (list2 != null && min == list2.getData()) list2 = list2.getNext();
            }
        }

        return result.getNext();
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null && head2 == null) return null;
        else if (head1 == null) return head2;
        else if (head2 == null) return head1;
        else {
            if (head1.getData() < head2.getData()) {
                return new SinglyLinkedListNode(head1.getData(), mergeLists(head1.getNext(), head2));
            } else {
                return new SinglyLinkedListNode(head2.getData(), mergeLists(head1, head2.getNext()));
            }
        }
    }
}
