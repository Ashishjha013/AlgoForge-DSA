import java.util.Stack;

// TreeNode class representing a node in a binary tree with
// integer data and references to left and right children
class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;

  public TreeNode(int data) {
    this.data = data;
  }
}

// Pair class to hold a TreeNode and its state during
// construction and traversal processes
class Pair {
  TreeNode node;
  int state;

  public Pair(TreeNode node, int state) {
    this.node = node;
    this.state = state;
  }
}

class Main {
  // Constructing a binary tree from an array
  public static TreeNode construction(Integer[] arr) {
    Stack<Pair> st = new Stack<>();
    TreeNode root = null;

    for (int i = 0; i < arr.length; i++) {

      Integer ele = arr[i]; // optional readability improvement

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

  // Displaying a binary tree
  public static void display(TreeNode root) {
    if (root == null)
      return;

    String nodeStructure = (root.left == null ? "." : root.left.data)
        + " <- " + root.data + " -> "
        + (root.right == null ? "." : root.right.data);

    System.out.println(nodeStructure);

    display(root.left);
    display(root.right);
  }

  // Main function
  public static void main(String[] args) {
    Integer[] arr = {
        10, 20, 40, null, 60, null, null,
        50, 70, null, null, null,
        30, 80, 90, null, null, 100, null, null, null
    };

    TreeNode root = construction(arr);

    System.out.println("Tree Structure:");
    display(root);
  }
}
