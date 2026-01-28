

    public static void printEven(BinNode root) {
        if (root == null) return;

        if (isEven(root)) {
            System.out.print(root.value + " ");
        }

        printEven(root.left);
        printEven(root.right);
    }

    public static int countEven(BinNode root) {
        if (root == null) return 0;

        int count = isEven(root) ? 1 : 0;
        return count + countEven(root.left) + countEven(root.right);
    }

   
    public static boolean hasEven(BinNode root) {
        if (root == null) return false;

        if (isEven(root)) return true;

        return hasEven(root.left) || hasEven(root.right);
    }

    
    public static boolean allEven(BinNode root) {
        if (root == null) return true;

        if (!isEven(root)) return false;

        return allEven(root.left) && allEven(root.right);
    }

    
    private static boolean isEven(BinNode node) {
        if (node.value % 2 != 0) return false;

        if ((node.left != null && node.left.value % 2 != 0) || (node.right != null && node.right.value % 2 != 0)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        BinNode root = new BinNode(8);
        root.left = new BinNode(4);
        root.right = new BinNode(6);
        root.left.left = new BinNode(2);
        root.right.left = new BinNode(10);
        root.right.right = new BinNode(12);

        System.out.println("1. Even nodes:");
        printEven(root);
        System.out.println();

        System.out.println("2. Count of even nodes: " + countEven(root));
        System.out.println("3. Is there at least one even node? " + hasEven(root));
        System.out.println("4. Are all nodes even? " + allEven(root));
    }
}
