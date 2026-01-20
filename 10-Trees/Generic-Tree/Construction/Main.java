// Generic Tree Construction

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

public class Main {
  public static TreeNode constructTree(int[] dataArray) {
    Stack<TreeNode> st = new Stack<>();
    TreeNode root = null;

    for(int i=0; i<dataArray.length; i++) {
      if(dataArray[i] == -1) {
        st.pop();
      } else {
        TreeNode newNode = new TreeNode(dataArray[i]);

        if(st.size() == 0) {
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
    for(TreeNode child : root.children) {
      System.out.print(child.data + ", ");
    }

    // Indicating the end of children list
    System.out.println();

    // Recursively printing each child subtree
    for(TreeNode child : root.children) {
      displayTree(child);
    }
  }

  // Main function
  public static void main(String[] args) {
    // Example input array representing a generic tree
    int[] dataArray = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, -1, 40, 80, -1, 90, 110, -1, 120, -1, -1, 100, -1, -1, -1};
    
    // Construct the generic tree
    TreeNode root = constructTree(dataArray);
    
    // Display the tree (you can implement a display method if needed)
    displayTree(root);
  }
}
