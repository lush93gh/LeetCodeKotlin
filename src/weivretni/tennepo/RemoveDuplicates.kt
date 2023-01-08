package weivretni.tennepo

class RemoveDuplicates {
    fun removeDuplicates(llist: SinglyLinkedListNode?): SinglyLinkedListNode? {
        var pointer = llist
        while (pointer != null) {
            val data = pointer.data
            var next = pointer.next
            while (next != null && data == next.data) {
                next = next.next
            }

            pointer.next = next
            pointer = next
        }
        return llist
    }
}