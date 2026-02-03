// Binary Tree Question 1
// Get Nodes at K Level down

public class Question1 {
  public static class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  public static TreeNode constructBinaryTree(int[] arr) {
    if (arr.length == 0) {
      return null;
    }

    TreeNode root = new TreeNode(arr[0]);
    java.util.Stack<TreeNode> stack = new java.util.Stack<>();
    stack.push(root);

    int i = 1;
    while (i < arr.length) {
      TreeNode current = stack.peek();

      if (arr[i] != -1) {
        TreeNode newNode = new TreeNode(arr[i]);
        if (current.left == null) {
          current.left = newNode;
        } else if (current.right == null) {
          current.right = newNode;
        }
        stack.push(newNode);
      } else {
        stack.pop();
      }
      i++;
    }
    return root;
  }

  public static void display(TreeNode root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " -> ");
    if (root.left != null) {
      System.out.print("L:" + root.left.data + " ");
    }
    if (root.right != null) {
      System.out.print("R:" + root.right.data + " ");
    }
    System.out.println();
    display(root.left);
    display(root.right);
  }

  public static void printKLevelsDown(TreeNode root, int k) {
    if (root == null || k < 0) {
      return;
    }

    if (k == 0) {
      System.out.println(root.data);
      return;
    }

    printKLevelsDown(root.left, k - 1);
    printKLevelsDown(root.right, k - 1);
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 4, -1, 5, -1, -1, 3, -1, -1};
    TreeNode root = constructBinaryTree(arr);
    display(root);
    
    int k = 2;
    System.out.println("Nodes at level " + k + ":");
    printKLevelsDown(root, k);
  }
}
