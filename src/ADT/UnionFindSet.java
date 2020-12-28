package ADT;

import java.util.Arrays;

public class UnionFindSet {
    int weight[];
    int f[];
    UnionFindSet(int n){
        this.f=new int[n];
        this.weight=new int[n];
        Arrays.fill(weight,1);
        for(int i=0;i<n;i++)
            f[i]=i;
    }
    public  int  cfind(int i){
        if(i==f[i])
            return  i;
        int fa=cfind(f[i]);
        f[i]=fa;
        return  fa;
    }
    public  void  union(int a,int b ){
        int fa=cfind(a);
        int fb=cfind(b);
        if(weight[fa]<weight[fb]){
            f[fa]=f[b];
            weight[fb]+=weight[f[a]];
        }
        else {
            f[fb]=fa;
            weight[fa]+=weight[fb];
        }
    }

}
