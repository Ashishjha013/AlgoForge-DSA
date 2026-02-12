import java.util.ArrayList;
import java.util.Stack;

// Generic Tree
class TreeNode {
  int data;
  ArrayList<TreeNode> children;

  public TreeNode(int data) {
    this.data = data;
    children = new ArrayList<>();
  }
}

class Main {
  // Constructing a generic tree from an array
  public static TreeNode constructTree(int[] dataArray) {
    Stack<TreeNode> st = new Stack<>();
    TreeNode root = null;

    for (int i = 0; i < dataArray.length; i++) {
      if (dataArray[i] == -1) {
        st.pop();
      } else {

        TreeNode newNode = new TreeNode(dataArray[i]);

        if (st.size() == 0) {
          root = newNode;
        } else {
          st.peek().children.add(newNode);
        }

        st.push(newNode);
      }
    }
    return root;
  }

  // Displaying a generic tree
  public static void display(TreeNode root) {
    System.out.print(root.data + " -> ");

    for (TreeNode child : root.children) {
      System.out.print(child.data + ", ");
    }

    System.out.println();

    for (TreeNode child : root.children) {
      display(child);
    }
  }

  // Size of a generic tree
  public static int getSize(TreeNode root) {
    int totalSize = 0;

    for (TreeNode child : root.children) {
      totalSize += getSize(child);
    }
    return totalSize + 1;
  }

  // Maximum value in a generic tree
  public static int getMaximum(TreeNode root) {
    int treeMax = root.data;

    for (TreeNode child : root.children) {
      int childMax = getMaximum(child);
      treeMax = Math.max(treeMax, childMax);
    }
    return treeMax;
  }

  // Height of a generic tree
  public static int getHeight(TreeNode root) {
    if (root == null) {
      return -1;
    }

    int treeHeight = -1;

    for (TreeNode child : root.children) {
      int childHeight = getHeight(child);
      treeHeight = Math.max(treeHeight, childHeight);
    }
    return treeHeight + 1;
  }

  // Mirror a generic tree
  public static TreeNode makeMirror(TreeNode root) {
    int childrenSize = root.children.size();

    int left = 0;
    int right = childrenSize - 1;

    while (left <= right) {
      TreeNode leftMirror = makeMirror(root.children.get(left));
      TreeNode rightNode = root.children.get(right);
      TreeNode rightMirror = left < right ? makeMirror(rightNode) : rightNode;

      root.children.set(left, rightMirror);
      root.children.set(right, leftMirror);

      left++;
      right--;
    }

    return root;
  }

  // Remove leaf nodes
  public static void removeLeafNodes(TreeNode root) {
    for (int i = root.children.size() - 1; i >= 0; i--) {
      TreeNode child = root.children.get(i);

      if (child.children.size() == 0) {
        root.children.remove(i);
      }
    }

    for (TreeNode child : root.children) {
      removeLeafNodes(child);
    }
  }

  // Find tail (for linearization)
  public static TreeNode findTail(TreeNode node) {
    TreeNode temp = node;

    while (temp.children.size() > 0) {
      temp = temp.children.get(0);
    }

    return temp;
  }

  // Linearize (inefficient)
  public static TreeNode lineariseGT(TreeNode root) {
    for (TreeNode child : root.children) {
      lineariseGT(child);
    }

    while (root.children.size() > 1) {
      int childrenSize = root.children.size();

      TreeNode lastChild = root.children.get(childrenSize - 1);
      TreeNode secondLastChild = root.children.get(childrenSize - 2);

      TreeNode tail = findTail(secondLastChild);

      root.children.remove(childrenSize - 1);
      tail.children.add(lastChild);
    }

    return root;
  }

  // Linearize (better)
  public static TreeNode lineariseGT_better(TreeNode root) {
    if (root.children.size() == 0) {
      return root;
    }

    TreeNode lastChildTail = lineariseGT_better(root.children.get(root.children.size() - 1));

    while (root.children.size() > 1) {
      int childrenSize = root.children.size();

      TreeNode lastChild = root.children.get(childrenSize - 1);
      TreeNode secondLastChild = root.children.get(childrenSize - 2);

      TreeNode secondLastChildTail = lineariseGT_better(secondLastChild);

      root.children.remove(childrenSize - 1);
      secondLastChildTail.children.add(lastChild);
    }

    return lastChildTail;
  }

  // Find target
  public static boolean find(TreeNode root, int target) {
    if (root.data == target) {
      return true;
    }

    for (TreeNode child : root.children) {
      boolean targetExists = find(child, target);

      if (targetExists) {
        return true;
      }
    }

    return false;
  }

  // Node to root path
  public static ArrayList<TreeNode> nodeToRootPath(TreeNode root, int target) {
    if (root.data == target) {
      ArrayList<TreeNode> base = new ArrayList<>();
      base.add(root);
      return base;
    }

    for (TreeNode child : root.children) {
      ArrayList<TreeNode> childPath = nodeToRootPath(child, target);

      if (childPath.size() > 0) {
        childPath.add(root);
        return childPath;
      }
    }

    return new ArrayList<>();
  }

  // Lowest Common Ancestor
  public static TreeNode findLCA(TreeNode root, int tar1, int tar2) {
    ArrayList<TreeNode> ntrPath1 = nodeToRootPath(root, tar1);
    ArrayList<TreeNode> ntrPath2 = nodeToRootPath(root, tar2);

    int i = ntrPath1.size() - 1;
    int j = ntrPath2.size() - 1;

    while (i >= 0 && j >= 0 &&
        ntrPath1.get(i).data == ntrPath2.get(j).data) {
      i--;
      j--;
    }

    return ntrPath1.get(i + 1);
  }

  // Check mirror
  public static boolean isMirror(TreeNode n1, TreeNode n2) {
    if (n1.data != n2.data ||
        n1.children.size() != n2.children.size()) {
      return false;
    }

    for (int i = 0, j = n2.children.size() - 1; j >= 0; i++, j--) {

      boolean isChildrenMirror = isMirror(n1.children.get(i), n2.children.get(j));

      if (!isChildrenMirror) {
        return false;
      }
    }
    return true;
  }

  // Check symmetric
  public static boolean isTreeSymmetric(TreeNode root) {
    return isMirror(root, root);
  }

  public static void main(String[] args) {
    int[] dataArray = {
        10, 20, 50, -1, 60, -1, -1,
        30, 70, -1, 80, 100, -1, 110, -1, -1,
        90, -1, -1,
        40, 120, -1, 130, -1, -1, -1
    };

    TreeNode root = constructTree(dataArray);

    System.out.println("LCA of 80 & 100: "
        + findLCA(root, 80, 100).data);
  }
}
