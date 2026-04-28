import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    public void add(String data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        root.add(data);
    }

    public void preTraverse(Node node) {
        if (node == null) return;

        System.out.printf("[%s]", node.data);
        preTraverse(node.left);
        preTraverse(node.right);
    }

    public void inTraverse(Node node) {
        if (node == null) return;

        inTraverse(node.left);
        System.out.printf("[%s]", node.data);
        inTraverse(node.right);
    }

    public void postTraverse(Node node) {
        if (node == null) return;

        postTraverse(node.left);
        postTraverse(node.right);
        System.out.printf("[%s]", node.data);
    }

    public void levelTraverse(Node node) {
    if (node == null) return;

    Queue<Node> queue = new LinkedList<>();
    queue.add(node);

    while (!queue.isEmpty()) {
        Node current = queue.poll();
        System.out.printf("[%s]", current.data);

        if (current.left != null) {
            queue.add(current.left);
        }
        if (current.right != null) {
            queue.add(current.right);
        }
    }

}

    public int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int countLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }

        return countLeaves(node.left) + countLeaves(node.right);
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }

        int tinggiKiri = height(node.left);
        int tinggiKanan = height(node.right);

        return 1 + Math.max(tinggiKiri, tinggiKanan);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        String[] data = {"Sarah", "Ranita", "Davina", "Fey", "Angel", "Inas", "Riana", "Eko", "Fajar", "Lina"};

        for (int i = 0; i < data.length; i++) {
            System.out.printf("Data %s dimasukkan.\n", data[i]);
            tree.add(data[i]);
        }

        System.out.print("Pre-order  : ");
        tree.preTraverse(tree.root);
        System.out.println();

        System.out.print("In-order   : ");
        tree.inTraverse(tree.root);
        System.out.println();

        System.out.print("Post-order : ");
        tree.postTraverse(tree.root);
        System.out.println();

        int jumlahNode = tree.countNodes(tree.root);
        System.out.println("Jumlah node dalam tree: " + jumlahNode);

        int jumlahDaun = tree.countLeaves(tree.root);
        System.out.println("Jumlah daun dalam tree: " + jumlahDaun);

        int tinggiTree = tree.height(tree.root);
        System.out.println("Tinggi tree: " + tinggiTree);

        System.out.print("Level-order: ");
        tree.levelTraverse(tree.root);
        System.out.println();
    }
}
