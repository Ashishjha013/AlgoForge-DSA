import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;

  public TreeNode(int data) {
    this.data = data;
  }
}

class Pair {
  TreeNode node;
  int state;

  public Pair(TreeNode node, int state) {
    this.node = node;
    this.state = state;
  }
}

class Main {
  // <====== Minimum Value in BST () ======>
  // https://www.geeksforgeeks.org/problems/minimum-element-in-bst/1
  public static int minVal(TreeNode root) {
    if (root == null) {
      return -1;
    }
    
    if (root.left == null) {
      return root.data;
    }
    
    return minVal(root.left);
  }
  // <====== Minimum Value in BST (Iteratively) ======>
  public static int minValIter(TreeNode root) {
    if (root == null) {
      return -1;
    }

    while (root.left != null) {
      root = root.left;
    }

    return root.data;
  }

  // Build BST Function
  public static TreeNode buildBST(int[] arr, int si, int ei) {
    if(si > ei) {
      return null;
    }

    int mid = (si + ei) / 2;

    TreeNode root = new TreeNode(arr[mid]);

    root.left = buildBST(arr, si, mid - 1);
    root.right = buildBST(arr, mid + 1, ei);

    return root;
  }

  // Display Function
  public static void display(TreeNode root) {
    if (root == null) {
      return;
    }

    String nodeStructure = (root.left == null ? "." : root.left.data)
        + " <- " + root.data + " -> "
        + (root.right == null ? "." : root.right.data);

    System.out.println(nodeStructure);

    display(root.left);
    display(root.right);
  }

  // Main Function
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 5, 8, 10, 12, 13, 15, 18};

    TreeNode root = buildBST(arr, 0, arr.length - 1);
    display(root);

    System.out.println("Minimum Value in BST (Recursively): " + minVal(root));
    System.out.println("Minimum Value in BST (Iteratively): " + minValIter(root));
  }
}
