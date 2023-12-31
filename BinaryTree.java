package Ibm;

import java.util.Scanner;

public class BinaryTree {

 public BinaryTree(){

 }

    private class Node{
        Node left;
        Node right;
        int val;
        public Node(int val){
            this.val=val;
        }
    }
    private Node root;

    public  void insert(Scanner sc){
        System.out.println("Enter the value for root node:");
        int val= sc.nextInt();
        root=new Node(val);
        populate(sc,root);

    }
    private void populate(Scanner sc,Node root){
        System.out.println("Do you want to enter the left node:");
        boolean left=sc.nextBoolean();
        if(left) {
            System.out.println("Enter the value of left Node:");
            int val = sc.nextInt();
            root.left = new Node(val);
            populate(sc, root.left);
        }
        System.out.println("Do you want to enter the right node:");
        boolean right=sc.nextBoolean();
        if(right){
            System.out.println("Enter the value of right Node:");
            int val = sc.nextInt();
            root.left = new Node(val);
            populate(sc, root.left);
        }
    }

    public void display(){
        treeDisplay(root,0);
    }

    private  void treeDisplay(Node node,int level){
        if(node==null) {
            return;
        }
        treeDisplay(node.right,level+1);
        if(level!=0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
                System.out.println("|------>"+node.val);

        }else {
            System.out.println(node.val);
        }
        treeDisplay(node.left,level+1);
    }
    public static void main(String[] args){
        BinaryTree bt=new BinaryTree();
        Scanner sc=new Scanner(System.in);
        bt.insert(sc);
        bt.display();
    }

}
