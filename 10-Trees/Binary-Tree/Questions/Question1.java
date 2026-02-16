import java.util.ArrayList;
import java.util.List;

public class Question1 {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
      this.val = val;
      this.left = null;
      this.right = null;
    }
  }

  // Construct Binary Tree
  public static TreeNode constructBinaryTree(int[] arr) {
    if (arr.length == 0)
      return null;

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

  // Display Tree
  public static void display(TreeNode root) {
    if (root == null)
      return;

    System.out.print(root.val + " -> ");
    if (root.left != null)
      System.out.print("L:" + root.left.val + " ");
    if (root.right != null)
      System.out.print("R:" + root.right.val + " ");
    System.out.println();

    display(root.left);
    display(root.right);
  }

  // Question 1: Get K level down nodes from a target node
  // <================== Get K level down ==================>
  public static TreeNode findTargetNode(TreeNode root, int tar) {
    if (root == null)
      return null;
    if (root.val == tar)
      return root;

    TreeNode leftAns = findTargetNode(root.left, tar);
    if (leftAns != null)
      return leftAns;

    return findTargetNode(root.right, tar);
  }

  // Helper function to get K level down nodes from a given node
  public static void getKLevelDown(TreeNode node, int K, ArrayList<TreeNode> ans) {
    if (node == null)
      return;

    if (K == 0) {
      ans.add(node);
      return;
    }

    getKLevelDown(node.left, K - 1, ans);
    getKLevelDown(node.right, K - 1, ans);
  }

  // Wrapper function to find target node and get K level down nodes
  public static ArrayList<TreeNode> getKLevelDown(TreeNode root, int tar, int K) {
    TreeNode targetNode = findTargetNode(root, tar);

    ArrayList<TreeNode> ans = new ArrayList<>();
    getKLevelDown(targetNode, K, ans);
    return ans;
  }

  // Question 2: Distance K (Leetcode 863)
  // <================== Node To Root Path ==================>
  public ArrayList<TreeNode> getNodeToRootPath(TreeNode root, TreeNode target) {
    if (root == null)
      return new ArrayList<>();

    if (root.equals(target)) {
      ArrayList<TreeNode> bans = new ArrayList<>();
      bans.add(root);
      return bans;
    }

    ArrayList<TreeNode> leftAns = getNodeToRootPath(root.left, target);
    if (leftAns.size() > 0) {
      leftAns.add(root);
      return leftAns;
    }

    ArrayList<TreeNode> rightAns = getNodeToRootPath(root.right, target);
    if (rightAns.size() > 0) {
      rightAns.add(root);
      return rightAns;
    }

    return new ArrayList<>();
  }

  // <================== Distance K (Leetcode 863) ==================>
  public void getKLevelDown(TreeNode node, TreeNode blocker, int K, List<Integer> ans) {
    if (node == null || node.equals(blocker) || K < 0)
      return;

    if (K == 0) {
      ans.add(node.val);
      return;
    }

    getKLevelDown(node.left, blocker, K - 1, ans);
    getKLevelDown(node.right, blocker, K - 1, ans);
  }

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    ArrayList<TreeNode> nodeToRootPath = getNodeToRootPath(root, target);

    List<Integer> ans = new ArrayList<>();

    TreeNode blocker = null;
    for (int i = 0; i < nodeToRootPath.size(); i++) {
      TreeNode node = nodeToRootPath.get(i);

      getKLevelDown(node, blocker, k - i, ans);
      blocker = node;
    }

    return ans;
  }

  // Question 3: Lowest Common Ancestor (LCA)
  // <================== LCA (Using Extra Space) ==================>
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    ArrayList<TreeNode> ntr1 = getNodeToRootPath(root, p);
    ArrayList<TreeNode> ntr2 = getNodeToRootPath(root, q);

    int i = ntr1.size() - 1;
    int j = ntr2.size() - 1;

    while (i >= 0 && j >= 0 && ntr1.get(i).equals(ntr2.get(j))) {
      i--;
      j--;
    }

    return ntr2.get(j + 1);
  }

  // <================== LCA (Better) ==================>
  public boolean LCA_better(TreeNode root, TreeNode p, TreeNode q, TreeNode[] LCA) {
    if (root == null)
      return false;

    boolean self = root.equals(p) || root.equals(q);
    boolean left = LCA_better(root.left, p, q, LCA);
    boolean right = LCA_better(root.right, p, q, LCA);

    if ((left && right) || (self && left) || (self && right)) {
      LCA[0] = root;
    }

    return self || left || right;
  }

  // Wrapper function for LCA_better
  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode[] LCA = new TreeNode[1];
    LCA_better(root, p, q, LCA);
    return LCA[0];
  }

  // Question 4: Remove Leaf Nodes
  // <================== Remove Leaf Nodes ==================>
  public TreeNode removeLeafNodes(TreeNode root, int target) {
    if (root == null)
      return null;

    root.left = removeLeafNodes(root.left, target);
    root.right = removeLeafNodes(root.right, target);

    if (root.left == null && root.right == null && root.val == target) {
      return null;
    }

    return root;
  }

  // Question 5: Construct Binary Tree from Preorder and Inorder Traversal
  // Leetcode 105
  // <================== Construct Binary Tree from Preorder and Inorder Traversal
  // ==================>
  public TreeNode buildTree(int[] preorder, int preSi, int preEi, int[] inorder, int inSi, int inEi) {
    TreeNode root = new TreeNode(preorder[preSi]);
    
    int rootIdx = inSi;
    int leftTreeElements = 0;

    while(rootIdx <= inEi && inorder[rootIdx] != root.val) {
      rootIdx++;
      leftTreeElements++;
    }
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    int size = preorder.length;

    return buildTree(preorder, 0, size - 1, inorder, 0, size - 1);
  }

  // Helper function to print nodes in a list
  public static void printNodes(ArrayList<TreeNode> nodes) {
    for (TreeNode node : nodes) {
      System.out.print(node.val + " ");
    }
    System.out.println();
  }

  // Main function
  public static void main(String[] args) {
    int[] arr = { 1, 2, 4, -1, 5, -1, -1, 3, -1, -1 };

    TreeNode root = constructBinaryTree(arr);
    display(root);

    int target = 2;
    int k = 1;

    System.out.println("\nNodes " + k + " level down from target " + target + ":");

    ArrayList<TreeNode> ans = getKLevelDown(root, target, k);
    printNodes(ans);

    // Using non-static methods
    Question1 q = new Question1();

    TreeNode targetNode = findTargetNode(root, 2);
    System.out.println("\nDistance K (863): " + q.distanceK(root, targetNode, 2));
  }
}
