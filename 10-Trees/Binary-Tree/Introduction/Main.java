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

  // Leetcode 104 (max depth)
  public static int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);

    return Math.max(leftDepth, rightDepth) + 1;
  }

  // Traversals (unchanged logic)
  public static void traverse(TreeNode root,
      ArrayList<Integer> preorder,
      ArrayList<Integer> inorder,
      ArrayList<Integer> postorder) {

    if (root == null) {
      return;
    }

    preorder.add(root.data);

    traverse(root.left, preorder, inorder, postorder);

    inorder.add(root.data);

    traverse(root.right, preorder, inorder, postorder);

    postorder.add(root.data);
  }

  public static TreeNode buildTree(Integer[] arr) {
    Stack<Pair> st = new Stack<>();
    TreeNode root = null;

    for (int i = 0; i < arr.length; i++) {
      Integer ele = arr[i];

      if (ele == null) {

        if (st.size() == 0) {
          return null;
        } else if (st.peek().state == 0) {
          st.peek().state++;
        } else {
          st.pop();
        }

      } else {

        TreeNode newNode = new TreeNode(ele);

        if (st.size() == 0) {
          root = newNode;

        } else if (st.peek().state == 0) {
          st.peek().node.left = newNode;
          st.peek().state++;

        } else {
          st.peek().node.right = newNode;
          st.pop();
        }

        st.push(new Pair(newNode, 0));
      }
    }

    return root;
  }

  public static void main(String[] args) {

    Integer[] arr = {
        10, 20, 40, null, 60, null, null,
        50, 70, null, null, null,
        30, 80, 90, null, null, 100, null, null, null
    };

    ArrayList<Integer> preorder = new ArrayList<>();
    ArrayList<Integer> inorder = new ArrayList<>();
    ArrayList<Integer> postorder = new ArrayList<>();

    TreeNode root = buildTree(arr);

    traverse(root, preorder, inorder, postorder);

    System.out.println("\nPreorder : " + preorder);
    System.out.println("Inorder  : " + inorder);
    System.out.println("Postorder: " + postorder);

    System.out.println("\nTree Structure:");
    display(root);

    System.out.println("\nMax Depth: " + maxDepth(root));
  }
}
