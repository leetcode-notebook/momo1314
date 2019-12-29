class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return isEqual(root1,root2);
    }
    public boolean isEqual(TreeNode root1,TreeNode root2){
        if (root1 == null && root2 == null) return true;
        if ( (root1 == null && root2 != null) || (root1 != null && root2 == null) || (root1.val!=root2.val) ) return false;
        return isEqual(root1.left,root2.right)&&isEqual(root1.right,root2.left)
            ||isEqual(root1.left,root2.left)&&isEqual(root1.right,root2.right);
    }
}