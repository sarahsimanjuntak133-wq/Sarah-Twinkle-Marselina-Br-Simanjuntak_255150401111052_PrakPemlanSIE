public class Node {
    Object data;
    Node next;

    Node(){}

    Node(Object data) { 
    this.data = data; 
    } 

    public static void main(String[] args) {

        Node node = new Node();

        System.out.println("node    : " + node);
        System.out.println("data    : " + node.data);
        System.out.println("pointer : node.next");
    }
}
