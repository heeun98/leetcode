class MyLinkedList {

    Node head;
    Node tail;
    int size;

    public MyLinkedList() {
        head = new Node();
        tail = new Node();

        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }
    
    public int get(int index) {

        if (index < 0 || index >= size) return -1;
        Node cur = head.next;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.val;
    }
    
    public void addAtHead(int val) {
        
        Node newNode = new Node(val);

        newNode.next = head.next;
        newNode.prev = head;

        head.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }
    
    public void addAtTail(int val) {

        Node newNode = new Node(val);

        Node cur = tail.prev;

        newNode.next = cur.next;
        newNode.prev = cur;

        cur.next = newNode;
        tail.prev = newNode;
        size++;
        
    }
    
    public void addAtIndex(int index, int val) {

        if (index < 0 || index > size) return;

        Node newNode = new Node(val);

        Node cur = head;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        newNode.prev = cur;
        newNode.next = cur.next;
        cur.next.prev = newNode;
        cur.next = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {

        if (index < 0 || index >= size) return;

        Node cur = head.next;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        size--;
    }
}

class Node {

    Node next;
    Node prev;
    int val;

    public Node() {

    }

    public Node(int val) {
        this.val = val;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */