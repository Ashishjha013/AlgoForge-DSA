// Generic Tree Construction

import java.util.*;
import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
  int data;
  ArrayList<TreeNode> children;

  public TreeNode(int data) {
    this.data = data;
    this.children = new ArrayList<>();
  }
}

public class Question1 {
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

  public static void displayTree(TreeNode root) {
    // Printing the current node data
    System.out.print(root.data + " -> ");

    // Printing all children of the current node
    for (TreeNode child : root.children) {
      System.out.print(child.data + ", ");
    }

    // Indicating the end of children list
    System.out.println();

    // Recursively printing each child subtree
    for (TreeNode child : root.children) {
      displayTree(child);
    }
  }

  //Questioin No. 1: Find the size of tree
  public static int getSize(TreeNode root) {
    int totalSize = 0;

    for (TreeNode child : root.children) {
      totalSize += getSize(child);
    }

    return totalSize + 1;
  }

  // Questioin No. 2: Find the maximum value in tree
  public static int getMax(TreeNode root) {
    int treeMax = root.data;

    for(TreeNode child : root.children) {
      int childMax = getMax(child);
      treeMax = Math.max(treeMax, childMax);
    }
    return treeMax;
  }

  // Questioin No. 3: Find the height of tree
  public static int getHeight(TreeNode root) {
    if (root == null) {
      return -1;
    }
    int treeHeight = -1;

    for(TreeNode child : root.children) {
      int childHeight = getHeight(child);
      treeHeight = Math.max(treeHeight, childHeight);
    }
    return treeHeight + 1;
  }

  // Mirror the tree
  public static void mirrorTree(TreeNode root) {
    if (root == null) {
      return;
    }
    for(TreeNode child : root.children) {
      mirrorTree(child);
    }

    int left = 0, right = root.children.size() - 1;
    while(left < right) {
      TreeNode temp = root.children.get(left);
      root.children.set(left, root.children.get(right));
      root.children.set(right, temp);

      left++;
      right--;
    }
  }

  // Remove leaf nodes from the tree
  public static void removeLeafNodes(TreeNode root) {
    if(root == null) {
      return;
    }

    for(int i=root.children.size()-1; i>=0; i--) {
      TreeNode child = root.children.get(i);
      if(child.children.size() == 0) {
        root.children.remove(i);
      }
    }

    for (TreeNode child : root.children) {
      removeLeafNodes(child);
    }

  }

  //linearise the tree
  public static TreeNode getTail(TreeNode node) {
    while(node.children.size() == 1) {
      node = node.children.get(0);
    }
    return node;
  }

  // Main function
  public static void main(String[] args) {
    // Example input array representing a generic tree
    int[] dataArray = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, -1, 40, 80, -1, 90, 110, -1, 120, -1, -1, 100, -1, -1,
        -1 };

    // Construct the generic tree
    TreeNode root = constructTree(dataArray);

    // System.out.println("Size of tree " + getSize(root));
    // System.out.println("Maximum value in tree " + getMax(root));
    // System.out.println("Height of tree " + getHeight(root));

    // Mirror the tree
    // mirrorTree(root);

    // Remove leaf nodes from the tree
    // removeLeafNodes(root);

    // Linearize the tree
    TreeNode newRoot = getTail(root);
    displayTree(newRoot);
  }
}
