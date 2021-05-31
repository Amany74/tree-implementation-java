package com.company;
import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    // constructor to take data
    public TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}
public class BinaryTree {
    TreeNode root;


    //PREORDER
    //-------------------------------------------------------------------------------
// recursive method
    public void preOrderRecursive(TreeNode root) {
        if (root != null) {
            System.out.printf("%d", root.data);
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }

// iterative method

    public void preOrder(TreeNode root) {
        if (root == null) return;
        // la2n kda mfe4 3nasr

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode n = stack.pop();
            System.out.printf("%d", n.data);
            if (n.right != null) stack.push(n.right);
            if (n.left != null) stack.push(n.left);
        }

    }


//-------------------------------------------------------------------

    // in order traversal .
    // recursive
    public void inOrderRecursive(TreeNode root) {
        if (root != null) {
            inOrderRecursive(root.left);
            System.out.printf("%d \t", root.data);
            inOrderRecursive(root.right);
        }
    }

    // iterative
    public void inOrder(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode currentNode = root;
        while (!s.empty() || currentNode != null) {
            if (currentNode != null) {
                s.push(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode n = s.pop();
                System.out.printf("%d \t", n.data);
                currentNode = n.right;
            }
        }

    }


    //--------------------------------------------------------------------
// postOrder
    // recursion
    public void postOrderRecursion(TreeNode root) {
        if (root != null) {
            postOrderRecursion(root.left);
            postOrderRecursion(root.right);
            System.out.printf("%d", root.data);
        }
    }
//iterative


//------------------------------------------------------------------------

    // level order binary Tree
    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.printf("%d ", tempNode.data);
            if (tempNode.left != null)
                queue.add(tempNode.left);
            if (tempNode.right != null)
                queue.add(tempNode.right);
        }

    }

    //-------------------------------------------------------------------------

    // reverse level order Traversal
    public void reverseLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        queue.add(root);
        while (queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            if (tempNode.left != null) queue.add(tempNode.left);
            if (tempNode.right != null) queue.add(tempNode.right);
            stack.push(tempNode);

        }

        while (!stack.isEmpty()) {
            System.out.println("{" + stack.pop().data + "}");
        }
    }


    //---------------------------------------------------------------------
// spiral or zigzag order traversal
    public void spiralOrZigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        boolean directionflag = false;
        while (!stack.isEmpty()) {
            Stack<TreeNode> tempStack = new Stack<>();
            while (!stack.isEmpty()) {
                TreeNode tempNode = stack.pop();
                System.out.printf("%d \n", tempNode.data);
                if (!directionflag) {
                    if (tempNode.left != null)
                        tempStack.push(tempNode.left);
                    if (tempNode.right != null)
                        tempStack.push(tempNode.right);
                } else {
                    if (tempNode.right != null)
                        tempStack.push(tempNode.right);
                    if (tempNode.left != null)
                        tempStack.push(tempNode.left);
                }
            }
            directionflag = !directionflag;
            stack = tempStack;


        }
    }
    //---------------------------------------------------------------------

    //count leaf Nodes in  Binary tree
    public int getLeafNumber(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1; // de kda leaf
        else {
return getLeafNumber(root.left) + getLeafNumber(root.right);
        }
    }

    // printing those counted leaf Nodes
    public void PrintLeaveNode(TreeNode root ){
        if(root == null ) {
            return ;
        }
        if(root.left == null && root.right == null)
            System.out.printf("%d " , root.data); // la2et leaf etb3
        PrintLeaveNode(root.left);
        PrintLeaveNode(root.right);
    }

//---------------------------------------------
    // print all paths to leaf in a binary Tree
    public void PrintAllPathsToLeaf(TreeNode root , int [] path ,int len){
        if(root == null) return ;
// storing data in array
        path[len] = root.data;
        len++;

        if(root.left == null && root.right == null){
            PrintArray(path , len);
            return ;}
        PrintAllPathsToLeaf(root.left , path ,len);
        PrintAllPathsToLeaf(root.right , path ,len);

    }
public void PrintArray(int [] path , int len ){
        for(int i  = 0 ; i < len ; i++  ) {
            System.out.print("  "+ path[i]);
        }
    System.out.println( );
}
//------------------------------------------------------------------
    // printing max number in Binary Tree
    //iterative
    public int getMax(TreeNode root ){
        Queue <TreeNode> queue = new LinkedList <> ();
        queue.add(root);
        int max = root.data ;
        while(!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            if( tempNode.data > max  )    max = tempNode.data;
            if(tempNode.left != null)
                queue.add(tempNode.left);
            if(tempNode.right!=null)
                queue.add(tempNode.right);
        }
return max ;
    }

    //By recursion
    public static  int getMaximumRec(TreeNode root)
    {
        int max=Integer.MIN_VALUE;
        int value=0;
        int left,right;
        if(root != null)
        {
            value=root.data;
            left=getMaximumRec(root.left);
            right=getMaximumRec(root.right);

            if(left>right)
            {
                max=left;
            }
            else
            {
                max=right;
            }

            if(max < value)
            {
                max=value;
            }
        }

        return max;
    }

// creating a bin search tree
public  boolean search ( TreeNode root , int key ){
    while (root != null){  // finished and not found
        if(key == root.data)    return true ; // i find it
            else if (key < root.data)  { root = root.left ;   // go left
         return   search(root,key);
            }
        else {
            root = root.right; // go right
           return search(root,key);
        }
    }
    return false ;
}


// finf the min element found at far left
    // Max search for the most right
    public int findMin(TreeNode root ) {
        if (root == null) return -1;  // empty tree
        else if (root.left == null)   //most leaf node
            return root.data;
        else
        return findMin(root.left);

    }




}
