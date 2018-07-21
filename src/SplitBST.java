/**
 * @author ksharma
 */
public class SplitBST {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode[] splitBST(TreeNode root, int V) {

        TreeNode newRoot=splitBSTUtil(root,V,null);
        if(newRoot==null){
            return null;
        }
        TreeNode[] nodes=new TreeNode[]{newRoot,root};
        return nodes;
    }
    public TreeNode splitBSTUtil(TreeNode root, int V,TreeNode parent) {
        if(root==null){
            return null;
        }
        if(root.val==V){
            if(parent==null){
                return null;
            }
            TreeNode rc=root.right;
            if(parent.left==root){
                parent.left=rc;
            }else{
                parent.right=rc;
            }
            TreeNode newRoot=root;
            newRoot.right=null;
            return newRoot;
        }
        if(V<root.val){
            return splitBSTUtil(root.left,V,root);
        }else{
            return splitBSTUtil(root.right,V,root);
        }
    }
}
