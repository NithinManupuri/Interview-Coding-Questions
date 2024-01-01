package Ibm;

public class BST {
    private class Node{
        Node left;
        Node right;
        int val;
        int height;
        public Node(int val){
            this.val=val;
        }
        public int getVal(){
            return this.val;
        }
    }

    private Node root;
    public BST(){

    }
    public int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }
    public void insert(int val){
        root=insertBst(root,val);
    }
    private Node insertBst(Node node,int val){
        if(node==null){
            node=new Node(val);
            return node;
        }
        if(val<node.val){
            node.left=insertBst(node.left,val);
        }
        if(val>node.val){
            node.right=insertBst(node.right,val);
        }
        node.height=Math.abs(height(node.left)-height(node.right))+1;

        return node;
    }

    public void  display(){
         treeData(root,"RootNode:");
    }
    public void treeData(Node node,String data){
        if(node==null){
            return;
        }
        System.out.println(data+node.val);
        treeData(node.left,"LeftNode:"+node.val+": ");
        treeData(node.right,"RightNode:"+node.val+": ");
    }

    public void balanced(){
        boolean b=check(root);
        System.out.print(b);
    }
    private boolean check(Node node){
        if(node==null){
            return true;
        }
        return Math.abs(height(node.left)-height(node.right))<=1 && check(node.left) && check(node.right);
    }

    public  void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.val+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public  void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.val+" ");
        inOrder(node.right);
    }
    public  void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val+" ");
    }
    public static void main(String[] args){
        BST bst=new BST();
        int[] num={6,3,4,2,13,5};
        for(int i=0;i< num.length;i++){
            bst.insert(num[i]);
        }
        bst.display();
        bst.balanced();
        bst.preOrder();
        bst.inOrder();
        bst.postOrder();
    }


}
