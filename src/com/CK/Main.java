package com.CK;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null || root2 == null)
            return false;
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        inOrder(root1, list1);
        inOrder(root2, list2);
        int left = 0, right = list2.size() - 1;
        while (left < list1.size() && right >= 0) {
            int sum = list1.get(left) + list2.get(right);
            if (sum == target)
                return true;
            if (sum < target)
                left++;
            else
                right--;
        }

        return false;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}