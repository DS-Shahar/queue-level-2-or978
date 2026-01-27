public class Trees1 {

    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    
    public static void printEvenWithoutOddChild(Node root) {
        if (root == null) return;

        if (isEvenWithoutOddChild(root)) {
            System.out.print(root.value + " ");
        }

        printEvenWithoutOddChild(root.left);
        printEvenWithoutOddChild(root.right);
    }

    
    public static int countEvenWithoutOddChild(Node root) {
        if (root == null) return 0;

        int count = isEvenWithoutOddChild(root) ? 1 : 0;
        return count +
                countEvenWithoutOddChild(root.left) +
                countEvenWithoutOddChild(root.right);
    }

    public static boolean existsEvenWithoutOddChild(Node root) {
        if (root == null) return false;

        if (isEvenWithoutOddChild(root)) return true;

        return existsEvenWithoutOddChild(root.left) ||
               existsEvenWithoutOddChild(root.right);
    }

    
    public static boolean allEvenWithoutOddChild(Node root) {
        if (root == null) return true;

        if (!isEvenWithoutOddChild(root)) return false;

        return allEvenWithoutOddChild(root.left) &&
               allEvenWithoutOddChild(root.right);
    }

    //
    private static boolean isEvenWithoutOddChild(Node node) {
        if (node.value % 2 != 0) return false;

        if (node.left != null && node.left.value % 2 != 0) return false;
        if (node.right != null && node.right.value % 2 != 0) return false;

        return true;
    }


    public static void main(String[] args) {


        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.right.left = new Node(10);
        root.right.right = new Node(12);

        System.out.println("1. הדפסת הצמתים:");
        printEvenWithoutOddChild(root);
        System.out.println();

        System.out.println(countEvenWithoutOddChild(root));
        System.out.println(existsEvenWithoutOddChild(root));
        System.out.println( allEvenWithoutOddChild(root));
    }
}
