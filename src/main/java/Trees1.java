public class Trees1 {

    static class BinNode {
        int value;
        BinNode left, right;

        BinNode(int value) {
            this.value = value;
        }
    }

    
    public static void printEvenWithoutOddChild(BinNode root) {
        if (root == null) return;

        if (isEvenWithoutOddChild(root)) {
            System.out.print(root.value + " ");
        }

        printEvenWithoutOddChild(root.left);
        printEvenWithoutOddChild(root.right);
    }

    
    public static int countEvenWithoutOddChild(BinNode root) {
        if (root == null) return 0;

        int count = isEvenWithoutOddChild(root) ? 1 : 0;
        return count +
                countEvenWithoutOddChild(root.left) +
                countEvenWithoutOddChild(root.right);
    }

    public static boolean existsEvenWithoutOddChild(BinNode root) {
        if (root == null) return false;

        if (isEvenWithoutOddChild(root)) return true;

        return existsEvenWithoutOddChild(root.left) ||
               existsEvenWithoutOddChild(root.right);
    }

    
    public static boolean allEvenWithoutOddChild(BinNode root) {
        if (root == null) return true;

        if (!isEvenWithoutOddChild(root)) return false;

        return allEvenWithoutOddChild(root.left) &&
               allEvenWithoutOddChild(root.right);
    }

    //
    private static boolean isEvenWithoutOddChild(BinNode node) {
        if (node.value % 2 != 0) return false;

        if (node.left != null && node.left.value % 2 != 0) return false;
        if (node.right != null && node.right.value % 2 != 0) return false;

        return true;
    }


    public static void main(String[] args) {

        BinNode root = new BinNode(8);
        root.left = new BinNode(4);
        root.right = new BinNode(6);
        root.left.left = new BinNode(2);
        root.right.left = new BinNode(10);
        root.right.right = new BinNode(12);

        System.out.println("1. הדפסת הצמתים:");
        printEvenWithoutOddChild(root);
        System.out.println();

        System.out.println(countEvenWithoutOddChild(root));
        System.out.println(existsEvenWithoutOddChild(root));
        System.out.println(allEvenWithoutOddChild(root));
    }
}
