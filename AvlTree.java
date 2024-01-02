package Ibm;

public class AvlTree {

    private class Node{
        private  Node left;
        private Node right;
        int height;
        int val;
        public Node(int val){
            this.val=val;
        }
        public int getVal(){
            return val;
        }
    }
    public AvlTree(){

    }
    private Node root;

    public int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }
    public int height(){
        return root.height;
    }
    public void  insert(int val){
       root= insert(root,val);

    }
    private Node insert(Node node,int val){
        if(node==null){
            node=new Node(val);
            return node;
        }
        if(val<node.val){
            node.left=insert(node.left,val);
        }
        if(node.val<val){
            node.right=insert(node.right,val);
        }
        node.height=Math.max(height(node.left),height(node.right)+1);
        return rotate(node);
    }

    private Node rotate(Node node){
        if(height(node.left)-height(node.right)>1){
            if(height(node.left.left)-height(node.left.right)>0){
                //right right
                return rightRotate(node);
            }
            if(height(node.left.left)-height(node.left.right)<0){
                //left right
                node.left=leftRotate(node.left);
                return rightRotate(node);
            }

        }
        if(height(node.left)-height(node.right)<-1){
            if(height(node.right.left)-height(node.right.right)<0){
                return leftRotate(node);
            }
            if(height(node.right.left)-height(node.right.right)>0){
                node.right=rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node rightRotate(Node p){
        Node c=p.left;
        Node t=c.right;
        c.right=p;
        p.left=t;
        p.height=Math.max(height(p.left),height(p.right)+1);
        c.height=Math.max(height(c.left),height(c.right)+1);
        return c;
    }
    private Node  leftRotate(Node c){
        Node p=c.right;
        Node t=p.left;
        p.left=c;
        c.right=t;
        p.height=Math.max(height(p.left),height(p.right)+1);
        c.height=Math.max(height(c.left),height(c.right)+1);
        return p;
    }

     public  static void main(String[] args){
        AvlTree avlTree=new AvlTree();
        for(int i =0;i<1000;i++){
            avlTree.insert(i);
        }
        int ans=avlTree.height();
        System.out.print(ans);

     }

}
