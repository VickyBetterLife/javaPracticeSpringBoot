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

        while (treeQueue.size() > 0) {
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

        for (int i = 1; i < result.size(); i += 2) {
            Collections.reverse(result.get(i));
        }

        return result;
    }

    /*
    Given a binary tree, check whether it is a mirror of itself(ie, symmetric around its center)
For example, this tree is symmetric:
1
/ \
2 2
/ \ / \
3 4 4 3
But the following tree is not.
1
/ \
2 2
\ \
3 3
     */
    public boolean SymmetricTree_method1(TreeNode root) {

        if (root == null)
            return true;

        Queue<TreeNode> treeQueue = new LinkedList<TreeNode>();
        treeQueue.offer(root);
        int i = treeQueue.size();


        List<Integer> intList = new ArrayList<Integer>();

        while (treeQueue.size() > 0) {
            TreeNode temp = ((LinkedList<TreeNode>) treeQueue).poll();

            intList.add(temp.val);

            if (temp.val != Integer.MAX_VALUE) {

//            if ((temp.left == null && temp.right != null) || (temp.left != null && temp.right == null))
//                return false;

                if (temp.left != null)
                    treeQueue.offer(temp.left);
                else {
                    TreeNode nodeLeft = new TreeNode(Integer.MAX_VALUE);
                    treeQueue.offer(nodeLeft);
                }

                if (temp.right != null)
                    treeQueue.offer(temp.right);
                else {
                    TreeNode nodeRight = new TreeNode(Integer.MAX_VALUE);
                    treeQueue.offer(nodeRight);
                }
            }

            i--;

            if (i == 0) {
                i = treeQueue.size();
                List<Integer> pre = new ArrayList<Integer>(intList);
                Collections.reverse(intList);
                if (!pre.equals(intList))
                    return false;
                intList = new ArrayList<Integer>();
            }
        }
        return true;
    }


    public boolean SymmetricTree_method2(TreeNode root) {

        if (root == null)
            return true;

        Queue<TreeNode> treeQueue = new LinkedList<TreeNode>();
        treeQueue.offer(root);
        int i = treeQueue.size();


        List<Integer> intList = new ArrayList<Integer>();

        while (treeQueue.size() > 0) {
            TreeNode temp = ((LinkedList<TreeNode>) treeQueue).poll();

            intList.add(temp.val);

            if (temp.val != Integer.MAX_VALUE) {

//            if ((temp.left == null && temp.right != null) || (temp.left != null && temp.right == null))
//                return false;

                if (temp.left != null)
                    treeQueue.offer(temp.left);
                else {
                    TreeNode nodeLeft = new TreeNode(Integer.MAX_VALUE);
                    treeQueue.offer(nodeLeft);
                }

                if (temp.right != null)
                    treeQueue.offer(temp.right);
                else {
                    TreeNode nodeRight = new TreeNode(Integer.MAX_VALUE);
                    treeQueue.offer(nodeRight);
                }
            }

            i--;

            if (i == 0) {
                i = treeQueue.size();
                List<Integer> pre = new ArrayList<Integer>(intList);
                Collections.reverse(intList);
                if (!pre.equals(intList))
                    return false;
                intList = new ArrayList<Integer>();
            }
        }
        return true;
    }


    private void travelTree(int level, TreeNode root, List<List<Integer>> result) {
        if (root == null)
            return;

        if (result.size() <= level) result.add(new ArrayList<Integer>());
        result.get(level).add(root.val);

        travelTree(level + 1, root.left, result);
        travelTree(level + 1, root.right, result);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null)
            return true;

        if ((p == null && q != null) || (p != null && q == null))
            return false;

        if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /*
    Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
     */
    private boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;


        return travelTreeByHeight(root) != -1;
    }

    private int travelTreeByHeight(TreeNode root) {

        if (root == null)
            return 0;

        int leftHeight = travelTreeByHeight(root.left);
        int rightHeight = travelTreeByHeight(root.right);

        if (leftHeight == -1 || rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return rightHeight > leftHeight ? (rightHeight + 1) : (leftHeight + 1);
    }

    /*
    Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

    Note: A leaf is a node with no children.

    Example:

    Given the below binary tree and sum = 22,

          5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1
    return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        int diff = sum - root.val;
        if (diff == 0 && root.left == null && root.right == null)
            return true;

        boolean leftVal = hasPathSum(root.left, diff);
        boolean rightVal = hasPathSum(root.right, diff);

        return leftVal || rightVal;
    }


    public List<Integer> binaryTreePreorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;

        Stack<TreeNode> treeNodes = new Stack<TreeNode>();
        treeNodes.add(root);

        while (treeNodes.size() > 0) {
            TreeNode tmp = treeNodes.pop();
            result.add(tmp.val);

            if (tmp.right != null)
                treeNodes.add(tmp.right);

            if (tmp.left != null)
                treeNodes.add(tmp.left);
        }

        return result;
    }

    public List<Integer> binaryTreeInorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            if (root == null)
                return result;

            Stack<TreeNode> treeNodes = new Stack<TreeNode>();

            TreeNode tmp = root;
            while (tmp !=null || !treeNodes.isEmpty()) {

                while (tmp != null) {
                    treeNodes.add(tmp);
                    tmp = tmp.left;
                }

                if(!treeNodes.isEmpty()){
                    TreeNode lastNode = treeNodes.pop();
                    result.add(lastNode.val);
                    tmp = lastNode.right;
                }
            }
            return result;
    }

    public List<Integer> binaryTreePostorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;

        Stack<TreeNode> treeNodes = new Stack<TreeNode>();
        treeNodes.add(root);

        TreeNode temp = root;
        TreeNode pre = null;

        while(!treeNodes.isEmpty()){

            temp = treeNodes.peek();

            if((temp.right == null && temp.left == null) || (pre!=null && (pre == temp.left || pre == temp.right))){

            }
            while(temp.right!=null) {
                treeNodes.add(temp.right);
                temp = temp.right;
            }
        }
        while(!treeNodes.isEmpty())
            result.add(treeNodes.pop().val);
        return result;
    }


    public List<Integer> binaryTreePostorderTraversal_method2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;

        Stack<TreeNode> treeNodes = new Stack<TreeNode>();
        Stack<TreeNode> leftNodes = new Stack<TreeNode>();

        TreeNode temp = root;

        while(temp != null || !leftNodes.isEmpty()){
            treeNodes.add(temp);

            if(temp.left != null)
                leftNodes.add(temp.left);

            while(temp.right!=null) {
                treeNodes.add(temp.right);
                temp = temp.right;

                if(temp.left != null)
                    leftNodes.add(temp.left);
            }

            if(!leftNodes.isEmpty())
                temp = leftNodes.pop();

        }

       while(!treeNodes.isEmpty())
           result.add(treeNodes.pop().val);
        return result;
    }
}
