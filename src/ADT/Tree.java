package ADT;

import org.junit.Test;

public class Tree {

    public Tree(int val){
        this.root=new node(val);
    }
   public node root;
    public Tree ConstructTreeByPost(String s){
        return null;
    }
    public  static  void main(String[] args){
        int[][]a={{0,2,4,3},{3,0,100,3},{5,100,0,-3},{100,-1,4,0}};
        for(int k=0;k<4;k++){
            for(int i=0;i<4;i++)
                for(int j=0;j<4;j++)
                    a[i][j]=Math.min(a[i][j],a[i][k]+a[k][j]);
            for(int i=0;i<4;i++)
                System.out.println(a[i][0]+"  "+a[i][1]+" "+a[i][2]+" "+a[i][3]);
            System.out.println();

        }
    }
  public   void preoder(node t){
        if(t==null) return;
        System.out.print(t.val+" ");
        preoder(t.left);
        preoder(t.right);
    }

 public    void inoder(node t){
        if(t==null) return;
        inoder(t.left);
        System.out.print(t.val+" ");
        inoder(t.right);
    }

   public void postoder(node t){
        if(t==null) return;
        preoder(t.left);
        postoder(t.right);
        System.out.print(t.val+" ");
    }


}
