package algorithm;


import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class BinaryTree {


    public TreeNode constructTreeWithInorderAndPostOrder(int[] inorder, int[] postorder) {

        return buildWithInorderAndPostOrder(0, inorder.length - 1, inorder, postorder, 0);
    }


    private TreeNode buildWithInorderAndPostOrder(int start, int end, int[] inorder, int[] postorder, int offset) {

        if (postorder == null || start > end)
            return null;


        TreeNode node = new TreeNode(postorder[end - offset]);
        int index = getIndex(inorder, postorder[end - offset]);
        node.left = buildWithInorderAndPostOrder(start, index - 1, inorder, postorder, offset);
        node.right = buildWithInorderAndPostOrder(index + 1, end, inorder, postorder, offset + 1);

        return node;
    }

    public TreeNode constructTreeWithInorderAndPreOrder(int[] inorder, int[] preorder) {

        return buildWithInorderAndPreOrder(0, inorder.length - 1, inorder, preorder, 0);
    }

    private TreeNode buildWithInorderAndPreOrder(int start, int end, int[] inorder, int[] preorder, int offset) {

        if (preorder == null || start > end)
            return null;

        TreeNode node = new TreeNode(preorder[start + offset]);
        int index = getIndex(inorder, preorder[start + offset]);
        node.left = buildWithInorderAndPreOrder(start, index - 1, inorder, preorder, offset + 1);
        node.right = buildWithInorderAndPreOrder(index + 1, end, inorder, preorder, offset);
        return node;
    }


    private int getIndex(int[] nums, int value) {
        if (nums == null || nums.length == 0)
            return -1;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] == value)
                return i;

        return -1;
    }

    /*
    Binary Tree Level Order Traversal
    Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
     */
    public List<List<Integer>> BinaryTreeLevelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null)
            return result;

        Queue<TreeNode> treeQueue = new LinkedList<TreeNode>();
        treeQueue.offer(root);
        int i = treeQueue.size();


        List<Integer> intList = new ArrayList<Integer>();

        while (i > 0) {
            TreeNode temp = ((LinkedList<TreeNode>) treeQueue).poll();
            intList.add(temp.val);
            if (temp.left != null)
                treeQueue.offer(temp.left);

            if (temp.right != null)
                treeQueue.offer(temp.right);

            i--;

            if (i == 0) {
                i = treeQueue.size();
                result.add(intList);
                intList = new ArrayList<Integer>();
            }
        }
        return result;
    }


    public List<List<Integer>> BinaryTreeLevelOrderTraversal_method2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        travelTree(0, root, result);

        return result;
    }

    /*
    Binary Tree Level Order Traversal II
    Given a binary tree, return the bottom-up level order traversal of its nodes' values. (from left to right,
level by level from leaf to root)
For example: Given binary tree {3,9,20,#,#,15,7},
3
/ \
9 20
/ \
15 7
return its level order traversal as:
[
[15,7],
[9,20],
[3]
     */
    public List<List<Integer>> BinaryTreeLevelOrderTraversal2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Stack<List<Integer>> tempResult = new Stack<List<Integer>>();

        if (root == null)
            return result;

        Queue<TreeNode> treeQueue = new LinkedList<TreeNode>();
        treeQueue.offer(root);
        int i = treeQueue.size();

        List<Integer> intList = new ArrayList<Integer>();

        while (i > 0) {
            TreeNode temp = ((LinkedList<TreeNode>) treeQueue).poll();
            intList.add(temp.val);
            if (temp.left != null)
                treeQueue.offer(temp.left);

            if (temp.right != null)
                treeQueue.offer(temp.right);

            i--;

            if (i == 0) {
                i = treeQueue.size();
                tempResult.push(intList);
                intList = new ArrayList<Integer>();
            }
        }

        while (tempResult.size() > 0) {
            result.add(tempResult.pop());
        }
        return result;
    }


    public List<List<Integer>> BinaryTreeLevelOrderTraversal2_method2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();  //if using LinkedList here, will cost much time
        if (root == null)
            return result;

        travelTree(0, root, result);

        List<List<Integer>> resultRevers = new ArrayList<List<Integer>>();

        for (int i = 0; i < result.size(); i++)
            resultRevers.add(result.get(result.size() - i - 1));

        return resultRevers;

    }

    /*
    Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its zigzag level order traversal as:
    [
      [3],
      [20,9],
      [15,7]
    ]
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        travelTree(0, root, result);

        List<List<Integer>> finalResult = new ArrayList<List<Integer>>();

        for (int i = 0; i < result.size(); i++) {
            if (i % 2 == 1)
                Collections.reverse(result.get(i));
            finalResult.add(result.get(i));
        }

        return finalResult;
    }

    private void travelTree(int level, TreeNode root, List<List<Integer>> result) {
        if (root == null)
            return;

        if (result.size() <= level) result.add(new ArrayList<Integer>());
        result.get(level).add(root.val);

        travelTree(level + 1, root.left, result);
        travelTree(level + 1, root.right, result);
    }


}
