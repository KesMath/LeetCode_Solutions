package LeetCode;

public class SearchBinarySearchTree {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int val) {
             this.val = val;
         }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
    public TreeNode searchBST(TreeNode root, int val) {
         if(root.val == val){
             return root;
         }
         else{
             if(val < root.val){
                 if(root.left != null){
                     root = root.left;
                     return searchBST(root, val);
                 }
                 else{
                     root = null;
                 }
             }
             else{
                 if(root.right != null){
                     root = root.right;
                     return searchBST(root, val);
                 }
                 else{
                     root = null;
                 }
             }
         }
         return root;
    }

    public static void main(String[] args) {
         SearchBinarySearchTree o = new SearchBinarySearchTree();
         TreeNode child1 = o.new TreeNode(2, o.new TreeNode(1),
                                                 o.new TreeNode(3));
         TreeNode child2 = o.new TreeNode(7);

         TreeNode root = o.new TreeNode(4, child1, child2);
         System.out.println(o.searchBST(root,1).val);
    }
}
