package ADT;

import java.util.*;

public class Graph {
    class vetrx{
        int id;
        int val;
        public  vetrx(){

        }
        public vetrx(int i, int i1) {
            this.id=i;
            this.val=i1;
        }
    }
    vetrx[] vetrxs;
    int vnum;
    HashMap<vetrx ,LinkedList<vetrx>> graph=new HashMap<>();
    int[][] w;
    HashMap<vetrx,Integer> Dijkstra(vetrx v){
        HashMap<vetrx,Integer> ans=new HashMap<>();

        return  null;
    }
    public  Graph(int[] vet,int[][] gra){
        this.vnum=vet.length;
        this.vetrxs=new vetrx[vnum];
        for(int i=0;i<vnum;i++)
        {   vetrxs[i]=new vetrx(i,vet[i]); }
        for(int i=0;i<vnum;i++){
            LinkedList<vetrx> vs=new LinkedList<>();

            for(int j=0;j<vnum;j++){
               if(gra[i][j]!=0)
                   vs.add(vetrxs[j]);
            }
            graph.put(vetrxs[i],vs);
        }
    }
    LinkedList<vetrx> path=new LinkedList();
    void dfs(vetrx v,int n , boolean[] vis){
        if(n==vnum+2)
            return;
        path.set(n,v);
        if(vis[v.id]){
            int first=path.indexOf(v);
            for(int i=first;i<=n;i++)
                System.out.print(path.get(i).id);
            System.out.println();
            return;
        }
        vis[v.id]=true;
        for(vetrx nxt:graph.get(v))
            dfs(nxt,n+1,vis);
        vis[v.id]=false;
    }

    public  void printallthecycle(){
        for(int i=0;i<vnum+2;i++)
           path.add(new vetrx());
        LinkedList<vetrx> p=new LinkedList<>();
        boolean vis[] =new boolean[vnum];
        p.add(vetrxs[0]);
        dfs(vetrxs[0],1,vis);

    }

   public  ArrayList<vetrx> Tsort(){
       ArrayList<vetrx> ans=new ArrayList<>();
       int[] rudu=new int[vnum];
       int[] cudu=new int[vnum];
       for(vetrx v:graph.keySet()){
           for(vetrx w:graph.get(v)){
               rudu[w.id]++;
               cudu[v.id]++;
           }
       }
       Queue<vetrx> q=new LinkedList<>();
       for(vetrx v:vetrxs)
           if(rudu[v.id]==0)
               q.add(v);
         while(q!=null){
            vetrx cur=q.poll();
            ans.add(cur);
            for(vetrx v:graph.get(cur))
            {rudu[v.id]--;
                if(rudu[v.id]==0)
                q.add(v);
            }
    }return  ans;
}}
