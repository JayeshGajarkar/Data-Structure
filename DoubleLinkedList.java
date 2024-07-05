class DLLNode {
    int data;
    DLLNode prev;
    DLLNode next;

    public DLLNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoubleLinkedList {
    private DLLNode head;
    private DLLNode tail;
    private int length;

    public DoubleLinkedList() {
        head = new DLLNode(Integer.MIN_VALUE);
        tail = new DLLNode(Integer.MIN_VALUE);
        head.next = tail;
        tail.prev = head;
        length = 0;
    }

    public int getPosition(int data) {
        DLLNode temp = head.next;
        int pos = 0;
        while (temp != tail) {
            if (temp.data == data) {
                return pos;
            }
            pos += 1;
            temp = temp.next;
        }
        return Integer.MIN_VALUE;
    }

    public int length() {
        return length;
    }

    public void insert(int newValue) {
        DLLNode newNode = new DLLNode(newValue);
        newNode.next = head.next;
        newNode.next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
        length += 1;
    }

    public void insert(int data, int position) {
        if (position < 0) {
            position = 0;
        }
        if (position > length) {
            position = length;
        }

        if (head == null) {
            head = new DLLNode(data);
            tail = head;
        } else if (position == 0) {
            DLLNode temp = new DLLNode(data);
            temp.next = head;
            head.prev = temp;
            head = temp;
        } else {
            DLLNode temp = head;
            for (int i = 1; i < position; i += 1) {
                temp = temp.next;
            }
            DLLNode newNode = new DLLNode(data);
            newNode.next = temp.next;
            newNode.prev = temp;
            newNode.next.prev = newNode;
            temp.next = newNode;
        }
        length += 1;
    }

    public void insertTail(int newValue) {
        DLLNode newNode = new DLLNode(newValue);
        newNode.prev = tail.prev;
        newNode.prev.next = newNode;
        tail.prev = newNode;
        newNode.next = tail;
        length += 1;
    }

    public void remove(int position) {
        if (position < 0) {
            position = 0;
        }
        if (position >= length) {
            position = length - 1;
        }

        if (head == null) {
            return;
        }

        if (position == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            DLLNode temp = head;
            for (int i = 1; i < position; i += 1) {
                temp = temp.next;
            }
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
        }
        length -= 1;
    }

    public synchronized void removeMatched(DLLNode node) {
        if (head == null) {
            return;
        }
        if (node.equals(head)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }

        DLLNode p = head;
        while (p != null) {
            if (node.equals(p)) {
                p.prev.next = p.next;
                p.next.prev = p.prev;
                return;
            }
        }
    }

    public int removeHead() {
        if (length == 0) {
            return Integer.MIN_VALUE;
        }
        DLLNode save = head.next;
        head.next = save.next;
        save.next.prev = head;
        length -= 1;
        return save.data;
    }

    public int removeTail() {
        if (length == 0) {
            return Integer.MIN_VALUE;
        }
        DLLNode save = tail.prev;
        tail.prev = save.prev;
        save.prev.next = tail;
        length -= 1;
        return save.data;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[]");
        if (length == 0) {
            return result.toString();
        }
        result = new StringBuilder("[" + head.next.data);
        DLLNode temp = head.next.next;
        while (temp != tail) {
            result.append(",").append(temp.data);
            temp = temp.next;
        }
        return result + "]";
    }

    public void clearList() {
        head = null;
        tail = null;
        length = 0;
    }

    public static void main(String[] args) {
        DoubleLinkedList doublyLinkedList = new DoubleLinkedList();

        doublyLinkedList.insert(1);
        doublyLinkedList.insert(2);
        doublyLinkedList.insert(3);

        System.out.println("Doubly linked list: " + doublyLinkedList);

        doublyLinkedList.insert(4, 1);

        System.out.println("Updated doubly linked list: " + doublyLinkedList);

        doublyLinkedList.insertTail(5);

        System.out.println("Final doubly linked list: " + doublyLinkedList);

        doublyLinkedList.remove(2);

        System.out.println("Doubly linked list after removal: " + doublyLinkedList);

        System.out.println("Length of the doubly linked list: " + doublyLinkedList.length());

        doublyLinkedList.clearList();

        System.out.println("Doubly linked list after clearing: " + doublyLinkedList);
    }
}
