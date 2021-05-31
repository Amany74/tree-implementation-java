package com.company;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        BinaryTree bi = new BinaryTree();
        // Creating a binary tree
        TreeNode rootNode = createBinaryTree();
        System.out.println("Spiral/Zigzag traversal of binary tree :");
      bi.spiralOrZigzagLevelOrder(rootNode);
int num = bi.getLeafNumber( rootNode );
        System.out.println("number of leaves : " + num);
        bi.PrintLeaveNode(rootNode);
       bi.PrintAllPathsToLeaf(rootNode,new int[1000],0);
       int y = bi.getMaximumRec(rootNode);
        System.out.println("max number "+ y );
       int res =  bi.findMin(rootNode);
        System.out.println("min key found  : " + res);
        bi.inOrder(rootNode);
    }

    public static  TreeNode createBinaryTree()
    {
        TreeNode rootNode =new TreeNode(40);
        TreeNode node20=new TreeNode(20);
        TreeNode node10=new TreeNode(10);
        TreeNode node30=new TreeNode(30);
        TreeNode node60=new TreeNode(60);
        TreeNode node50=new TreeNode(50);
        TreeNode node70=new TreeNode(70);

        rootNode.left=node20;
        rootNode.right=node60;

        node20.left=node10;
        node20.right=node30;

        node60.left=node50;
        node60.right=node70;
        return rootNode;
    }
}
