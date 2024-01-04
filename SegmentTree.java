package Ibm;

public class SegmentTree {


    public class Node {
        int startIndex;
        int endIndex;
        int data;
        Node left;
        Node right;

        public Node(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;

        }
    }
        Node root;
        public SegmentTree(int[] arr){
            this.root=constructTree(0,arr.length-1,arr);
        }
        private Node constructTree(int s,int e,int[] arr){
            if(s==e){
               Node node=new Node(s,e);
               node.data=arr[s];
               return node;
            }
            Node newnode=new Node(s,e);
            int  mid=s+(e-s)/2;
            newnode.left=this.constructTree(s,mid,arr);
            newnode.right=this.constructTree(mid+1,e,arr);
            newnode.data=newnode.left.data+ newnode.right.data;
            return newnode;
        }

        public void update(int index,int val){
            this.root.data=update(index,val,root);
        }
        private int  update(int index,int val,Node node) {
            if (index>=node.startIndex && node.endIndex >= index) {
                if (node.startIndex == index && node.endIndex == index) {
                    node.data = val;
                    return node.data;
                } else {
                    int left= update(index, val, node.left);
                    int right = update(index, val, node.right);
                    node.data = left + right;
                    return node.data;
                }
            }
            return node.data;
        }
        public void display(){
            display(this.root);
        }
        private void display(Node node){
            String str="";
            if(node.left!=null){
                str+="In interval [ "+node.left.startIndex+","+node.left.endIndex+"] the val is "+node.left.data;
            }else {
                str+="there is no left node";

            }

            str+="In interval [ "+node.startIndex+","+node.endIndex+"] the val is "+node.data;
            if(node.right!=null){
                str+="In interval [ "+node.right.startIndex+","+node.right.endIndex+"] the val is "+node.right.data;
            }else {
               str=str+"there is no right node";

            }
            System.out.println(str);
          if(node.left!=null) {
              display(node.left);
          }
          if(node.right!=null) {
              display(node.right);
          }
        }

    public void interval(int s,int e){
            int val=interval(s,e,root);
            System.out.print(val);
    }
         private int interval(int s,int e,Node node){
            if(node.startIndex>=s && node.endIndex<=e){
                return node.data;

            } else if (node.startIndex>e || node.endIndex<s) {
              return 0;
            }
            else{
                return  this.interval(s,e,node.left)+this.interval(s,e,node.right);
            }
    }
    public static void main(String[] args){
            int[] arr={1,2,3,4,5};
            SegmentTree st=new SegmentTree(arr);
           // st.update(2,0);
           // st.display();
            st.interval(1,3);
    }

}
