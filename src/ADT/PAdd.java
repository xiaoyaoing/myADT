package ADT;


public class PAdd {  //数据结构作业
    public PAdd(int a[]){
        this.coef=a[0]; this.exp=a[1];
        PAdd temp=this;
        for(int i=2;i<a.length;i+=2){
            temp.next=new PAdd(null,a[i],a[i+1]);
            temp=temp.next;
        }
    }

    public PAdd(PAdd next, int coef, int exp){
        this.next=next;
        this.coef=coef;
        this.exp=exp;
    }
    public PAdd(){
        ;
    }
    public PAdd next;
    public   int   coef ;
    public   int    exp;



    public PAdd add(PAdd node1, PAdd node2){
           PAdd ans=new PAdd();
           PAdd res=ans;
           while(node1!=null && node2!=null){
               if(node1.exp==node2.exp)
               {
                   if(node1.coef+node2.coef!=0)
                   {ans.next=new PAdd(null,node1.coef+node2.coef,node1.exp); ans=ans.next;}
                    node1=node1.next;
                    node2=node2.next;

               }
               else if(node1.exp<node2.exp)
               {
                   ans.next=new PAdd(null,node2.coef,node2.exp);
                   ans=ans.next;
                   node2=node2.next;
               }
               else {
                   ans.next=new PAdd(null,node1.coef,node1.exp);
                   ans=ans.next;
                   node1=node1.next;
               }
           }
           if(node1==null && node2==null) ;
           else if(node1==null) ans.next=node2;
           else ans.next =node1;
           return  res.next;
    }

    public static int Josephus(int n,int m){
        int[] a=new int[n];
        boolean vis[] = new boolean[n];
        int p=0;
        int num=n;
        int x=n-1;
        while(x>0){
            int i=1;
            while(i<m)
            {if(!vis[p])
             i++;
                p=(p+1)%n;
                }
            while(vis[p])
                p=(p+1)%n;
            vis[p]=true;
            while(vis[p])
            p=(p+1)%n;
            x--;
        }
        return  p+1;

    }
}

