package ADT;

public class Kmp {
    public  static  void  main(String[] args){
        System.out.println(new Kmp().kmp("1234234","234"));
    }
    int [] setnext(String s){
        int[] next=new int[s.length()];
        next[0]=0;
        int now=0;
        int cur=1;
        while(cur<s.length()){
            if(s.charAt(now)==s.charAt(cur))
            {
               now++; next[cur]=now;cur++;
            }
            else if(now!=0)
                now=next[now-1];
            else {
                next[cur]=0;
                cur++;
            }
        }   return  next;
    }
    int  kmp(String s1,String s2){
        int[] next=setnext(s2);
        int i=0;int j=0;
        while(i<s1.length() && j<s2.length())
        {
            if(s1.charAt(i)==s2.charAt(j)){
                i++;j++;
            }
            else if(j!=0)j=next[j];
            else i++;
        }
        if(j==s2.length()) return i-j;
        return -1;
    }
}
