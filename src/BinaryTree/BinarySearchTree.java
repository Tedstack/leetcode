package BinaryTree;
import DS.ListNode;
import DS.TreeNode;

import java.util.*;

public class BinarySearchTree {
    public List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> BST=new Stack<>();
        if(root!=null){
            result.add(root.val);
            if(root.right!=null)
                BST.push(root.right);
            if(root.left!=null)
                BST.push(root.left);
        }
        TreeNode cur;
        while(!BST.isEmpty()) {
            cur = BST.pop();
            result.add(cur.val);
            if(cur.right!=null)
                BST.push(cur.right);
            if(cur.left!=null)
                BST.push(cur.left);
        }
        return result;
    }

    public List<Integer> inOrderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> BST=new Stack<>();
        TreeNode cur=root;
        while(cur!=null || !BST.isEmpty()){
            while(cur!=null){
                BST.push(cur);
                cur=cur.left;
            }
            cur=BST.pop();
            result.add(cur.val);
            cur=cur.right;
        }
        return result;
    }

    public List<Integer> postOrderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> BST=new Stack<>();
        TreeNode lastVisited=null;
        TreeNode cur=root;
        while(cur!=null || !BST.empty()){
            while(cur!=null){
                BST.push(cur);
                cur=cur.left;
            }
            TreeNode top=BST.peek();
            if(top.right==null || lastVisited==top.right){
                BST.pop();
                result.add(top.val);
                lastVisited=top;
            }else
                cur=top.right;
        }
        return result;
    }
    //leetcode 99:recover the binary search tree
    public void recoverTree(TreeNode root) {
        TreeNode wp1=null,wp2=null;
        Stack<TreeNode> BST=new Stack<>();
        if(root!=null)
            BST.push(root);
        while(!BST.isEmpty())
        if(wp1!=null && wp2!=null) {
            int temp = wp2.val;
            wp2.val = wp1.val;
            wp1.val = temp;
        }
    }
    //leetcode 98:
    public boolean isValidBST(TreeNode root) {
        List<Integer> result=inOrderTraversal(root);
        int previous=result.get(0);
        for(int i=1;i<result.size();i++){
            if(result.get(i)<=previous)
                return false;
            else
                previous=result.get(i);
        }
        return true;
    }
    //leetcode 109
    public TreeNode sortedListToBST(ListNode head) {
        int count=0;
        ListNode p=head;
        while(p!=null){
            count++;
            p=p.next;
        }
        return dfs(head,count);
    }
    private TreeNode dfs(ListNode head,int size){
        if(head==null || size==0)
            return null;
        TreeNode root=new TreeNode(0);
        int left_size=size/2;
        int right_size=size-left_size-1;
        root.left=dfs(head,left_size);
        ListNode p=head;
        for(int i=0;i<size;i++)
            p=p.next;
        root.val=p.val;
        root.right=dfs(p.next,right_size);
        return root;
    }
}
