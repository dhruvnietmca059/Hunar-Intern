class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    // Method to add a new node to the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Method to display the linked list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Method to delete the last occurrence of a specified item
    public void deleteLastOccurrence(int key) {
        Node temp = head, lastOccurrence = null, prev = null;
        Node prevLastOccurrence = null;
        
        while (temp != null) {
            if (temp.data == key) {
                lastOccurrence = temp;
                prevLastOccurrence = prev;
            }
            prev = temp;
            temp = temp.next;
        }
        
        // If the key is not found, return
        if (lastOccurrence == null) {
            System.out.println("Element not found in the list.");
            return;
        }
        
        // If last occurrence is head, move head to next node
        if (lastOccurrence == head) {
            head = head.next;
        } else {
            prevLastOccurrence.next = lastOccurrence.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(4);
        
        System.out.println("Original List:");
        list.display();
        
        list.deleteLastOccurrence(2);
        System.out.println("List after deleting last occurrence of 2:");
        list.display();
    }
}
