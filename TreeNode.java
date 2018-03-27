
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    int size;

    TreeNode parent;

    public void print() {
        System.out.print(val + " ");
    }

    public void println() {
        System.out.println(val + " ");
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this(val);
        this.left = left;
        this.right = right;
    }

    void printTree() {
        System.out.println();
        BTreePrinter.printNode(this);
        System.out.println();
    }

    void printCharsTree() {
        BTreePrinter.asChar = true;
        BTreePrinter.printNode(this);
    }

    @Override
    public String toString() {
        return ""+val;
    }

}

class BTreePrinter {

    static boolean asChar = false;

    public static <T extends Comparable<?>> void printNode(TreeNode root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
        int largeNumsOffset = 0;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(asChar ? ""+(char)node.val : node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
                largeNumsOffset = (new StringBuilder(asChar ? ""+(char)node.val : ""+node.val).length()-1);
                largeNumsOffset = betweenSpaces-largeNumsOffset;
                BTreePrinter.printWhitespaces(largeNumsOffset);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
                BTreePrinter.printWhitespaces(betweenSpaces);
            }
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}