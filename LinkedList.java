class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Method to add elements to the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to display the list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Method to delete the last occurrence of a specified item
    public void deleteLastOccurrence(int key) {
        Node temp = head;
        Node lastOccurrence = null;
        Node prevLastOccurrence = null;
        Node prev = null;

        // Traverse the list to find the last occurrence of the key
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
            return;
        }

        // If the last occurrence is the head node
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
        list.add(2);

        System.out.println("Original List:");
        list.display();

        list.deleteLastOccurrence(2);
        System.out.println("After deleting last occurrence of 2:");
        list.display();

        list.deleteLastOccurrence(3);
        System.out.println("After deleting last occurrence of 3:");
        list.display();

        list.deleteLastOccurrence(5);
        System.out.println("After deleting last occurrence of 5 (not in list):");
        list.display();

        list.deleteLastOccurrence(1);
        System.out.println("After deleting last occurrence of 1:");
        list.display();
    }
}
