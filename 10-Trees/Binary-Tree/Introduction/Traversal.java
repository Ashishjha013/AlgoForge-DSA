import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Traversal {

  class Pair {
    TreeNode node;
    int state;

    public Pair(TreeNode node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public void traverse(TreeNode root,
    List<Integer> preorder,
    List<Integer> inorder,
    List<Integer> postorder) {

    Stack<Pair> st = new Stack<>();

    if (root != null) {
      st.push(new Pair(root, 0));
    }

    while (st.size() > 0) {

      Pair top = st.peek();
      TreeNode topNode = top.node;

      if (top.state == 0) { // PREORDER
        preorder.add(topNode.val);
        top.state++;

        if (topNode.left != null) {
          st.push(new Pair(topNode.left, 0));
        }

      } else if (top.state == 1) { // INORDER
        inorder.add(topNode.val);
        top.state++;

        if (topNode.right != null) {
          st.push(new Pair(topNode.right, 0));
        }

      } else { // POSTORDER
        postorder.add(topNode.val);
        st.pop();
      }
    }
  }

  public static void main(String[] args) {
    List<Integer> preorder = new ArrayList<>();
    List<Integer> inorder = new ArrayList<>();
    List<Integer> postorder = new ArrayList<>();

    Traversal traversal = new Traversal();

    // Sample Tree
    /*
     * 1
     * / \
     * 2 3
     * / \
     * 4 5
     */

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    traversal.traverse(root, preorder, inorder, postorder);

    System.out.println("Preorder : " + preorder);
    System.out.println("Inorder  : " + inorder);
    System.out.println("Postorder: " + postorder);
  }
}
