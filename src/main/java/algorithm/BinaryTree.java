package algorithm;


import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;e`q
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


    /*
     Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
     */

    public List<List<Integer>> pathSumII(TreeNode root, int sum) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null)
            return result;

        traversePathSum(root, sum, new LinkedList<Integer>(), result);

        return result;
    }

    public void traversePathSum(TreeNode root, int sum, Deque<Integer> sumList, List<List<Integer>> result) {
        if (root == null)
            return;

        sumList.addLast(root.val);
        int diff = sum - root.val;
        if (diff == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<Integer>(sumList));
            //  return;
        }
        //        List<Integer> listLeft = new ArrayList<Integer>(sumList);
        //        List<Integer> listRight = new ArrayList<Integer>(sumList);
        traversePathSum(root.left, diff, sumList, result);
        traversePathSum(root.right, diff, sumList, result);
        sumList.removeLast();
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
        while (tmp != null || !treeNodes.isEmpty()) {

            while (tmp != null) {
                treeNodes.add(tmp);
                tmp = tmp.left;
            }

            if (!treeNodes.isEmpty()) {
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
        treeNodes.push(root);

        TreeNode temp = root;
        TreeNode pre = null;

        while (!treeNodes.isEmpty()) {

            temp = treeNodes.peek();

            if ((temp.right == null && temp.left == null) || (pre != null && (pre == temp.left || pre == temp.right))) {
                result.add(temp.val);
                treeNodes.pop();
                pre = temp;
            } else {
                if (temp.right != null) {
                    treeNodes.push(temp.right);
                }

                if (temp.left != null)
                    treeNodes.push(temp.left);
            }
        }
        return result;
    }


    public List<Integer> binaryTreePostorderTraversal_method2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;

        Stack<TreeNode> treeNodes = new Stack<TreeNode>();
        Stack<TreeNode> leftNodes = new Stack<TreeNode>();

        TreeNode temp = root;

        while (temp != null || !leftNodes.isEmpty()) {
            treeNodes.add(temp);

            if (temp.left != null)
                leftNodes.add(temp.left);

            while (temp.right != null) {
                treeNodes.add(temp.right);
                temp = temp.right;

                if (temp.left != null)
                    leftNodes.add(temp.left);
            }

            if (!leftNodes.isEmpty())
                temp = leftNodes.pop();

        }

        while (!treeNodes.isEmpty())
            result.add(treeNodes.pop().val);
        return result;
    }


    /*
    Given a binary tree
struct TreeLinkNode {
TreeLinkNode *left;
TreeLinkNode *right;
TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next
pointer should be set to NULL.
Initially, all next pointers are set to NULL.
Note:
You may only use constant extra space. You may assume that it is a perfect binary tree (ie, all
leaves are at the same level, and every parent has two children). For example, Given the following
perfect binary tree,
1
/ \
2 3
/ \ / \
4 5 6 7
After calling your function, the tree should look like:
1 -> NULL
/ \
2 -> 3 -> NULL
/ \ / \
4->5->6->7 -> NULL
     */
    public Node PopulatingNextRightPointersinEachNode(Node root) {
        if (root == null)
            return null;

        Queue<Node> nodes = new LinkedList<Node>();
        Node pre = null;
        nodes.add(root);


        while (!nodes.isEmpty()) {
            Node temp = nodes.remove();
            if (nodes.isEmpty() || pre.right == temp) {
                temp.next = null;
                pre = temp;
            } else
                temp.next = nodes.peek();

            if (temp.left != null) {
                nodes.add(temp.left);
                nodes.add(temp.right);
            }

        }

        return root;
    }


    /*
    the tree could be any binary tree.
    1
    / \
    2 3
    / \ \
    4 5 7

    After calling your function, the tree should look like:
    1 -> NULL
    / \
    2 -> 3 -> NULL
   / \    \
  4-> 5 -> 7 -> NULL

     not complete, give up now*/
    public Node PopulatingNextRightPointersinEachNode2(Node root) {
        if (root == null)
            return null;

        Node first = null;
        Node last = null;
        Node p = root;
        while (p != null) {
            if (first == null) {
                if (p.left != null)
                    first = p.left;
                else if (p.right != null)
                    first = p.right;
            }

            if (p.left != null) {
                if (last != null)
                    last.next = p.left;
                last = p.left;
            }

            if (p.right != null) {
                if (last != null)
                    last.next = p.right;

                last = p.right;
            }

            if (p.next != null)
                p = p.next;
            else {
                p = first;
                first = null;
                last = null;
            }
        }

        return root;

        /*
        if (root == null)
            return null;

        Queue<Node> nodes = new LinkedList<Node>();
        nodes.add(root);

        Node pre = null;
        Node nextLast = root;


        while (!nodes.isEmpty()) {
            Node temp = nodes.remove();
            if (nodes.isEmpty() || nextLast == temp) {
                temp.next = null;
                nextLast = null;
            } else {
                temp.next = pre;
            }

            if (nextLast == null) {
                if (temp.right != null) {
                    nextLast = temp.right;
                } else if (temp.left != null)
                    nextLast = temp.left;
            }

            pre = temp;
            if (temp.right != null)
                nodes.add(temp.right);

            if (temp.left != null)
                nodes.add(temp.left);
        }

        return root;
        */

    }


/*
Convert Sorted List to Binary Search Tree
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */

    public TreeNode converSortedListToBST(ListNode head) {

        return buildTreeNodeByListNode(head, null);
    }

    private TreeNode buildTreeNodeByListNode(ListNode start, ListNode end) {
        if (start == end)
            return null;

        ListNode pre = start;
        ListNode post = start;

        while (pre != end && pre.next != end) {
            pre = pre.next.next;
            post = post.next;
        }

        TreeNode treeNode = new TreeNode(post.val);
        treeNode.left = buildTreeNodeByListNode(start, post);
        treeNode.right = buildTreeNodeByListNode(post.next, end);
        return treeNode;
    }

     /*
    Convert Sorted Array to Binary Search Tree
     */

    public TreeNode convertSortedArrayToBST(int[] nums) {
        return buildTreeNodeByArray(nums, 0, nums.length);
    }

    private TreeNode buildTreeNodeByArray(int[] nums, int start, int end) {

        if (start >= end)
            return null;

        int middle = (end + start) / 2;

        TreeNode treeNode = new TreeNode(nums[middle]);
        treeNode.left = buildTreeNodeByArray(nums, start, middle);
        treeNode.right = buildTreeNodeByArray(nums, middle + 1, end);
        return treeNode;
    }


    /*
    Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
     */
    public void flattenBinaryTreeToLinkedList_method1(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> treeStack = new Stack<TreeNode>();
        treeStack.push(root);
        TreeNode parent = root;

        while (!treeStack.isEmpty()) {
            TreeNode peekNode = treeStack.pop();
            if (peekNode.right != null)
                treeStack.push(peekNode.right);

            if (peekNode.left != null)
                treeStack.push(peekNode.left);

            if (peekNode == parent) {
                continue;
            }

            parent.right = peekNode;
            parent.left = null;
            parent = peekNode;
        }
    }

    public void flattenBinaryTreeToLinkedList_method2(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> treeStack = new Stack<TreeNode>();
        treeStack.push(root);
        TreeNode parent = root;

        while (!treeStack.isEmpty()) {
            TreeNode peekNode = treeStack.pop();

            TreeNode temp = peekNode;

            if (temp != parent) {
                parent.right = temp;
                parent.left = null;
                parent = temp;
            }

            while (temp.left != null) {
                if (temp.right != null)
                    treeStack.push(temp.right);
                temp.right = temp.left;
                temp.left = null;
                temp = temp.right;
                parent = temp;
                continue;
            }

            if (temp.right != null)
                treeStack.push(temp.right);
        }
    }


    /*
    Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
     */
    public boolean validateBinarySearchTree(TreeNode root) {
        Integer minValue = Integer.MIN_VALUE;
        Integer maxValue = Integer.MAX_VALUE;
        return isValidBSTRecursive(root, minValue, maxValue);
    }

    private boolean isValidBSTRecursive(TreeNode root, Integer minValue, Integer maxValue) {
        if (root == null)
            return true;


        int leftMinValue = minValue;
        int leftMaxValue = root.val < maxValue ? root.val : maxValue;

        int rightMinValue = root.val > minValue ? root.val : minValue;
        int rightMaxValue = maxValue;

        boolean leftResult = true;
        boolean rightResult = true;

        if (root.left != null)
            leftResult = isValidBSTRecursive(root.left, leftMinValue, leftMaxValue);

        if (root.right != null)
            rightResult = isValidBSTRecursive(root.right, rightMinValue, rightMaxValue);

        boolean rootVal = true;


        if (root.val == Integer.MAX_VALUE) {
            if (minValue >= Integer.MAX_VALUE)
                rootVal = false;
        } else if (root.val == Integer.MIN_VALUE) {
            if (maxValue <= Integer.MIN_VALUE)
                rootVal = false;
        } else {
            if (root.val >= maxValue || root.val <= minValue)
                rootVal = false;
        }

        return leftResult && rightResult && rootVal;
    }


    public void recoverBinarySearchTree(TreeNode root) {
        if (root == null)
            return;

        TreeNode p = root;
        while (p != null) {
            TreeNode left = p.left;
            TreeNode right = p.right;
            if (left == null && right == null)
                return;

            if (left != null && left.val > p.val) {
                Integer temp = p.val;
                p.val = left.val;
                left.val = temp;
                p = p.left;
            }

            if (right != null && right.val < p.val) {
                Integer temp = p.val;
                p.val = right.val;
                right.val = temp;
                p = p.right;
            }
        }
    }


    /*
    Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
     */

    public List<String> binaryTreePaths(TreeNode root){

        List<String> result = new ArrayList<String>();

        StringBuilder temp = new StringBuilder("");
        ReverseTreePreOrder(root,result,temp);
        return result;
    }

    private void ReverseTreePreOrder(TreeNode root, List<String> result,StringBuilder temp) {

        if (root == null)
            return;

        if(temp.length() == 0)
            temp.append(root.val);
        else
           temp.append("->" + root.val);

        if (root.left == null && root.right == null) {
            result.add(temp.toString());
            return;
        }

        if (root.left != null){
            StringBuilder left = new StringBuilder(temp);
            ReverseTreePreOrder(root.left, result, left);
        }

        if(root.right != null) {
            StringBuilder right = new StringBuilder(temp);
            ReverseTreePreOrder(root.right, result, right);
        }
    }



    /*
    Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
     */
    public int SumRoottoLeafNumbers(TreeNode root){

        List<Integer> result = new ArrayList<Integer>();
        addSumForTree(root,0,result);

        Integer finalResult = 0;

        for(Integer data : result){
            finalResult += data;
        }

        return finalResult;
    }

    private void addSumForTree(TreeNode root,int amount,List<Integer> result){
        if (root == null)
            return;

        amount = amount * 10 + root.val;
        if (root.left == null && root.right == null) {
            result.add(amount);
            return;
        }

        if (root.left != null){
            addSumForTree(root.left, amount, result);
        }

        if(root.right != null) {
            addSumForTree(root.right, amount, result);
        }
    }

}

