import java.util.*;

class TreeNode {
  int val;

  TreeNode left;
  TreeNode right;

  public TreeNode(int val) {
    this.val = val;
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
  // Build BST Function
  public static TreeNode buildBST(int[] arr, int si, int ei) {
    if (si > ei) {
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
    if (root == null)
      return;

    String nodeStructure = (root.left == null ? "." : root.left.val) + " <- " + root.val + " -> "
        + (root.right == null ? "." : root.right.val);

    System.out.println(nodeStructure);
    display(root.left);
    display(root.right);
  }

  // Question 1: Search in BST (Leetcode 700)
  // <======== Search in BST (Leetcode 700) ========>
  public TreeNode searchBST(TreeNode root, int target) { // worst case scenario O(N)
    if (root == null) {
      return null;
    }

    if (root.val == target) {
      return root;
    } else if (root.val < target) {
      return searchBST(root.right, target);
    } else {
      return searchBST(root.left, target);
    }
  }

  // <======== Search in BST (Leetcode 700) ========>
  // Iterative Approach
  public TreeNode searchBST2(TreeNode root, int target) { // worst case scenario O(N)
    while (root != null) {
      if (root.val == target) {
        return root;
      } else if (root.val < target) {
        root = root.right;
      } else {
        root = root.left;
      }
    }

    return null;
  }

  // Question 2: LCA of BST (Homework - leetcode 235)
  // LCA of BST (Homework - leetcode 235)
  // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

  // Insert into BST (Leetcode 701)
  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }

    if (root.val < val) {
      root.right = insertIntoBST(root.right, val);
    } else {
      root.left = insertIntoBST(root.left, val);
    }

    return root;
  }

  // Question 3: Delete Node in a BST
  // LeetCode 450
  // <====== Delete Node in a BST ======>
  public TreeNode findLeftMost(TreeNode root) {
    while (root.left != null) {
      root = root.left;
    }

    return root;
  }

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }

    if (root.val < key) {
      root.right = deleteNode(root.right, key);
    } else if (root.val > key) {
      root.left = deleteNode(root.left, key);
    } else {
      // root is a leaf node
      if (root.left == null && root.right == null) {
        return null;
      }

      // only one child
      if (root.left != null && root.right == null) {
        return root.left;
      } else if (root.left == null && root.right != null) {
        return root.right;
      }

      // both children (replace with justGreater val and then delete just greater)
      TreeNode justGreater = findLeftMost(root.right);

      root.val = justGreater.val;
      root.right = deleteNode(root.right, justGreater.val);
    }

    return root;
  }

  // Question 4: Trim a BST (leetcode 669)
  // <=========== Trim a BST ===========>
  public TreeNode trimBST(TreeNode root, int low, int high) {
    if (root == null) {
      return root;
    }

    if (root.val < low) {
      return trimBST(root.right, low, high); // no need to look at left subtree
    } else if (root.val > high) {
      return trimBST(root.left, low, high); // no need to look at right subtree
    } else {
      root.left = trimBST(root.left, low, high);
      root.right = trimBST(root.right, low, high);

      return root;
    }
  }

  // Question 5: Convert BST to Greater Tree (Leetcode 538)
  // https://leetcode.com/problems/convert-bst-to-greater-tree/description/
  // <=========== Convert BST to Greater Tree ===========>
  public void convertBST(TreeNode root, int[] sum) { // reverse inorder (decreasing)
    if (root == null)
      return;

    convertBST(root.right, sum);

    sum[0] += root.val;
    root.val = sum[0];

    convertBST(root.left, sum);
  }

  public TreeNode convertBST(TreeNode root) {
    int[] sum = new int[1];

    convertBST(root, sum);

    return root;
  }

  // Question 6: Make BST from Preorder (Leetcode 1008)
  // https://www.geeksforgeeks.org/problems/construct-bst-from-post-order/1
  // we can remove lowerBound as we are going in the left direction first
  // <=========== Make BST from Preorder ===========>
  public TreeNode makeBSTFromPreorder(int[] preorder, int[] idx, int upperBound) {
    if (idx[0] >= preorder.length || preorder[idx[0]] >= upperBound) {
      return null;
    }

    TreeNode root = new TreeNode(preorder[idx[0]]);
    idx[0]++;

    root.left = makeBSTFromPreorder(preorder, idx, root.val);
    root.right = makeBSTFromPreorder(preorder, idx, upperBound);

    return root;
  }

  public TreeNode bstFromPreorder(int[] preorder) {
    int[] idx = new int[1];
    return makeBSTFromPreorder(preorder, idx, Integer.MAX_VALUE);
  }

  // Question 7: Check if a Binary Tree is BST or not
  // Is BST (https://www.geeksforgeeks.org/problems/check-for-bst/1)
  // <=========== Check if a Binary Tree is BST or not ===========>
  class BstPair {
    int max;
    int min;
    boolean isBst;

    public BstPair() {
    }

    public BstPair(int max, int min, boolean isBst) {
      this.max = max;
      this.min = min;
      this.isBst = isBst;
    }
  }

  public BstPair checkIfBst(TreeNode root) {
    if (root == null) {
      return new BstPair(Integer.MIN_VALUE, Integer.MAX_VALUE, true); // -inf, inf, true
    }

    BstPair leftPair = checkIfBst(root.left);
    BstPair rightPair = checkIfBst(root.right);

    BstPair ansPair = new BstPair();

    ansPair.isBst = leftPair.isBst && rightPair.isBst && leftPair.max < root.val && root.val < rightPair.min;

    ansPair.min = Math.min(leftPair.min, root.val); // leftPair.min should always be minimum except when root.left = // null
    ansPair.max = Math.max(rightPair.max, root.val); // rightPair.max should always be max except when root.right = // null

    return ansPair;
  }

  public boolean isBST(TreeNode root) {
    return checkIfBst(root).isBst;
  }

  // Main Function
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 5, 8, 10, 12, 13, 15, 18 };

    TreeNode root = buildBST(arr, 0, arr.length - 1);
    display(root);
  }
}
