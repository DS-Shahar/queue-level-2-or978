 public static void main(String[] args) {

        // Create the tree
        BinNode<Integer> root = new BinNode<>(8);
        root.setLeft(new BinNode<>(4));
        root.setRight(new BinNode<>(6));
        root.getLeft().setLeft(new BinNode<>(2));
        root.getRight().setLeft(new BinNode<>(10));
        root.getRight().setRight(new BinNode<>(12));

        // Define the functions directly inside main and use them

        // 1. Print even nodes
        System.out.println("Even nodes:");
        Runnable printEven = () -> printEven(root);
        printEven.run();
        System.out.println();

        // 2. Count even nodes
        System.out.println("Count of even nodes: " + countEven(root));

        // 3. Check if there is at least one even node
        System.out.println("Is there at least one even node? " + hasEven(root));

        // 4. Check if all nodes are even
        System.out.println("Are all nodes even? " + allEven(root));
    }

    // Print even nodes without odd children
    public static <T> void printEven(BinNode<T> root) {
        if (root == null) return;

        if (isEven(root)) {
            System.out.print(root.getValue() + " ");
        }

        printEven(root.getLeft());
        printEven(root.getRight());
    }


    public static <T> int countEven(BinNode<T> root) {
        if (root == null) return 0;

        int count = isEven(root) ? 1 : 0;
        return count + countEven(root.getLeft()) + countEven(root.getRight());
    }


    public static <T> boolean hasEven(BinNode<T> root) {
        if (root == null) return false;

        if (isEven(root)) return true;

        return hasEven(root.getLeft()) || hasEven(root.getRight());
    }


    public static <T> boolean allEven(BinNode<T> root) {
        if (root == null) return true;

        if (!isEven(root)) return false;

        return allEven(root.getLeft()) && allEven(root.getRight());
    }


    private static <T> boolean isEven(BinNode<T> node) {
        if (!(node.getValue() instanceof Integer)) return false;

        Integer value = (Integer) node.getValue();

        if (value % 2 != 0) return false;

        if ((node.hasLeft() && (Integer) node.getLeft().getValue() % 2 != 0) || 
            (node.hasRight() && (Integer) node.getRight().getValue() % 2 != 0)) {
            return false;
        }

        return true;
    }
}
