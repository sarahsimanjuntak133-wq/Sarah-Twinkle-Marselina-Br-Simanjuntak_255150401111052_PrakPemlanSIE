public class DoubleLinkedList {
    Node head, tail;
    int size = 0;

    void init() {
        head = null;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    void addFirst(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            data.next = head;
            head.prev = data;
            head = data;
        }
        size++;
    }

    void addLast(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            tail.next = data;
            data.prev = tail;
            tail = data;
        }
        size++;
    }

    void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
     }

     void printBelakang() {
        Node current = tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.prev;
        }
     }

     Node search(Object key) {  //(a) Mencari node dengan nilai tertentu
        Node current = head;
        while (current != null) {
        if (current.data.equals(key)) {
            return current; // ditemukan
        }
        current = current.next;
    }
    return null; // tidak ditemukan
}

    Node get(int index) { //(b) Mencari node di posisi ke-n
         if (index < 0 || index >= size) return null;


            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }

    void removeAt(int index) { //(c) Hapus berdasarkan index
        if (index < 0 || index >= size) return;


        if (index == 0) {
            head = head.next;
            if (head == null) tail = null;
            } else {
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }


        if (current.next == tail) {
            tail = current;
        }


        current.next = current.next.next;
    }
    size--;
}

        void removeByValue(Object data) {  // (d) Hapus berdasarkan nilai
            if (isEmpty()) return;
            if (head.data.equals(data)) {
            head = head.next;
            if (head == null) tail = null;
            size--;
        return;
    }
            Node current = head;
            while (current.next != null) {
            if (current.next.data.equals(data)) {
            if (current.next == tail) {
                tail = current;
            }
            current.next = current.next.next;
            size--;
            return;
        }
        current = current.next;
    }
}

        void addAt(int index, Object data) { // (e) Tambah Indeks
        if (index < 0 || index > size) return;


        if (index == 0) {
            addFirst(new Node(data));
        } else if (index == size) {
            addLast(new Node(data));
         } else {
            Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }
}
        void addAfter(Object key, Object data) { // (f) Tambah setelah nilai tertentu
        Node current = head;
            while (current != null) {
        if (current.data.equals(key)) {
            Node newNode = new Node(data);
            newNode.next = current.next;
            current.next = newNode;


            if (current == tail) tail = newNode;
            size++;
            return;
        }
        current = current.next;
    }
}

         void addBefore(Object key, Object data) { //(g) Tambah sebelum nilai tertentu
        if (isEmpty()) return;
        if (head.data.equals(key)) {
        addFirst(new Node(data));
        return;
        }

        Node current = head;
        while (current.next != null) {
        if (current.next.data.equals(key)) {
            Node newNode = new Node(data);
            newNode.next = current.next;
            current.next = newNode;
            size++;
            return;
        }
        current = current.next;
    }
}


     public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");

        list.addLast(nodeA);
        System.out.println("head: " + list.head.data);
        System.out.println("tail: " + list.tail.data);

        list.addLast(nodeB);
        System.out.println("head: " + list.head.data);
        System.out.println("tail: " + list.tail.data);
        
        list.addLast(nodeC);
        System.out.println("head: " + list.head.data);
        System.out.println("tail: " + list.tail.data);

        System.out.println("Next of B: " + nodeB.next.data);
        System.out.println("Prev of B: " + nodeB.prev.data);

        // Main Sebelumnya( Print dari Belakang)
        // System.out.println("== Print dari Belakang ==");
        // list.printBelakang();

        Node result1 = list.search("B"); // poin (a)
            if (result1 != null) {
             System.out.println("Data ditemukan: " + result1.data);
            } else {
                System.out.println("Data tidak ditemukan");
            }
        
        Node result2 = list.get(1); //poin (b)
            if (result2 != null) {
            System.out.println("Index 1: " + result2.data);
            } else {
                System.out.println("Index tidak ditemukan");
            }

            System.out.println("\nSebelum hapus index 1:"); // poin(c)
            list.print();
            list.removeAt(1);
            System.out.println("Sesudah hapus index 1:");
            list.print();

            System.out.println("\nSebelum hapus nilai B:"); // poin (d)
            list.print();
            list.removeByValue("B");
            System.out.println("Sesudah hapus nilai B:");
            list.print();

            System.out.println("\nSebelum tambah di index 1:"); //poin(e)
            list.print();
            list.addAt(1, "X");
            System.out.println("Sesudah tambah X di index 1:");
            list.print();

            System.out.println("\nSebelum tambah setelah B:"); //poin(f)
            list.print();
            list.addAfter("X", "Y");
            System.out.println("Sesudah tambah Y setelah X:");
            list.print();

            System.out.println("\nSebelum tambah sebelum C:"); //poin(g)
            list.print();
            list.addBefore("Y", "Z");
            System.out.println("Sesudah tambah Y sebelum C:");
            list.print();
     }
}
