public class CustomLinkedList {
    private ListNode head;

    public void add(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void deleteLastOccurrence(int key) {
        ListNode temp = head, lastOccurrence = null, prev = null, lastPrev = null;

        while (temp != null) {
            if (temp.data == key) {
                lastOccurrence = temp;
                lastPrev = prev;
            }
            prev = temp;
            temp = temp.next;
        }

        if (lastOccurrence == null) return; // Key not found

        if (lastPrev == null) {
            head = head.next; // The last occurrence is the head
        } else {
            lastPrev.next = lastOccurrence.next;
        }
    }

    public void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method to run the program
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(2);

        System.out.println("Original List:");
        list.display();

        System.out.println("Deleting last occurrence of 2:");
        list.deleteLastOccurrence(2);
        list.display();

        System.out.println("Deleting last occurrence of 4:");
        list.deleteLastOccurrence(4);
        list.display();

        System.out.println("Deleting last occurrence of 1:");
        list.deleteLastOccurrence(1);
        list.display();

        System.out.println("Deleting last occurrence of 5 (not present):");
        list.deleteLastOccurrence(5);
        list.display();
    }
}

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
