package ADT;

import  java.util.Queue;

import java.util.LinkedList;

public class avlTree {
    private  class Node{
        Node(int val){
            this.val=val;
            this.height=1;
        }
        int val;
        Node left;
        Node  right;
        int height;
    }
    Node root;
    void del(int val){
        this.root=del(root,val);
    }
    void  insert(int val){
        this.root=insert(root,val);
    }
    void updateheight(Node t){
        t.height=Math.max(getheight(t.left),getheight(t.right))+1;
    }
    Node insert(Node root,int val){
        Node newnode=new Node(val);
        if(root==null)
            return newnode;
        if(val>root.val)
            root.right=insert(root.right,val);
        else
            root.left=insert(root.left,val);
        updateheight(root);
        int balfactor=getBalancedFactor(root);
        int lbalfactor=getBalancedFactor(root.left);
        int rbalfactor=getBalancedFactor(root.right);
        if(balfactor>1 && lbalfactor>=0)
            return  rroate(root); //LL情况 进行右旋
        if(balfactor>1 && lbalfactor<0)
        {
            root.left=lroate(root.left);
            return  rroate(root); //先左旋变成lr 再右旋
        }
        if(balfactor<-1 && rbalfactor<0)
            return  lroate(root); //rr
       if(balfactor<-1 && rbalfactor>=0)
       {
           root.right=rroate(root.right);
           return  lroate(root);
       }
       return  root;
    }
    Node lroate(Node  y){  // 左旋
        Node  x=y.right;
        Node  temp=x.left;
        x.left=y;
        y.right=temp;
        updateheight(y);
        updateheight(x);
        return  x;
    }

    Node rroate(Node y){
        Node x=y.left;
        Node temp=x.right;
        x.right=y;
        y.left=temp;
        updateheight(y);
        updateheight(x);
        return  x;
    }
    void pr(){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        int curheight=getheight(root);
        while(q.size()>0){
            Node t=q.poll();
            if(t.height!=curheight){
                curheight--;
                System.out.println();
            }
            System.out.print(t.val+"  ");
            if(t.left!=null) q.add(t.left);
            if(t.right!=null) q.add(t.right);
        }

    }


    public      int getheight(Node node){
        if(node==null) return  0; return  node.height;
    }

    public  int getBalancedFactor(Node node){

        return  node==null?0:getheight(node.left)-getheight(node.right);
    }

    public  boolean isBST(Node rt){
        if(rt==null) return  true;
        if(rt.left==null && rt.right==null) return  true;
        if(rt.left==null)
            return  rt.right.val>rt.val && isBST(rt.right);
        if(rt.right==null)
            return  rt.left.val<rt.val && isBST(rt.left);
        return  rt.left.val<rt.val && rt.right.val>rt.val && isBST(rt.left) && isBST(rt.right);

    }
    Node  del(Node t,int val){
            if(t==null) return null;  //val 不存在
            if(t.val==val)
            {
                if(t.left==null && t.right==null) return  null;
                else if(t.left==null)  t=t.right;
                else if(t.right==null) t=t.left;
                else {    //左右子树均不为空
                    Node tar=t.right;
                    while(tar.left!=null)
                        tar=tar.left;
                    t.val=tar.val;
                    t.right=del(t.right,t.val); //
                }
            }
            if(val>t.val)
                t.right=del(t.right,t.val);
            if(val<t.val)
                t.left=del(t.left,t.val);
            updateheight(t);
            int balfactor=getBalancedFactor(t);
            int lbalfactor=getBalancedFactor(t.left);
            int rbalfactor=getBalancedFactor(t.right);
            if(balfactor>1 && lbalfactor>=0)
                return  rroate(root); //LL情况 进行右旋
            if(balfactor>1 && lbalfactor<0)
            {
                t.left=lroate(t.left);
                return  rroate(t); //先左旋变成lr 再右旋
            }
            if(balfactor<-1 && rbalfactor<0)
                return  lroate(t); //rr
            if(balfactor<-1 && rbalfactor>=0)
            {
                t.right=rroate(t.right);
                return  lroate(t);
            }
        return  t;


    }
    public  static  void main(String[] args){
        int[] a={16,3,7,11,9, 28,18,14,15};
        avlTree tree=new avlTree();
        for(int x:a)
        {
            tree.insert(x);
            tree.pr();
            System.out.println();
            System.out.println();
        }
    }

}
