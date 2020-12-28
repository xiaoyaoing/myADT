package ADT;

import org.junit.Test;

public class Heap {
    boolean isMaxHeap=true;
    int size; //堆大小
    int [] heap;
     public static  int[] heapsort(int[] a,boolean isMaxHeap){
         return  new Heap(a,isMaxHeap).heapsort();
     }
     void swap(int i,int j){
         int temp=heap[j];
         heap[j]=heap[i];
         heap[i]=temp;
     }
     public  Heap(boolean isMaxHeap){
         this.isMaxHeap=isMaxHeap;
         this.heap=new int[100]; //默认100大小

     }

    public  Heap(int[] arry,boolean isMaxheap){
         this.isMaxHeap=isMaxheap;
         this.heap=arry;
         this.size=arry.length;
        for(int i=size/2;i>=0;i--)
            adjustD(i,this.isMaxHeap);
    }
    void adjustD(int i,boolean isMaxheap){
        int left=2*i+1;
        int right=2*i+2;
        if(left>=size)
            return;
        if(right>=size)
        {   if(isMaxheap)
        {if(heap[i]<heap[left])
            swap(i,left);}
            else if (heap[i]>heap[left])
                swap(i,left);
            return;}
        int j;
        if(isMaxheap)
        {if(heap[i]>=heap[left] && heap[i]>=heap[right]) return;
         j=heap[left]>heap[right]?left:right;}
        else
        {if(heap[i]<=heap[left] && heap[i]<=heap[right]) return;
            j=heap[left]<heap[right]?left:right;}
        swap(i,j);
        adjustD(j,isMaxheap);
    }
    void adjustU(int i,boolean isMaxheap){
        int curi=i;
        int pari=(i-1)/2;
        while(curi!=0 && (isMaxheap && heap[pari]<heap[curi]) || (!isMaxheap && heap[pari]>heap[curi]))
        {
            swap(curi,pari);
            curi=pari;
            pari=(curi-1)/2;
        }
    }
    public  void insert(int val){
        if(size==heap.length){
            int[] Bheap=new int[2*heap.length];
            for(int i=0;i<heap.length;i++)
                Bheap[i]=heap[i];
            this.heap=Bheap;
        }
           heap[size]=val;
           adjustU(size,isMaxHeap);
           size++;

    }
    public  void del(){
         heap[0]=heap[size-1];
         adjustD(0,isMaxHeap);
         size--;

    }
    public  int[] heapsort(){
         int[] ans=new int[heap.length];
         for(int i=size-1;i>=0;i--)
         {ans[i]=heap[0];
            heap[0]=heap[i];
            size--;
            adjustD(0,isMaxHeap);
            pr();
         }
        return  ans;
    }
    public  int get(int i){
         return  heap[i];
    }

    public  boolean isheap(int i){
         int left=2*i+1;
         int right=2*i+2;
         if(left>=size)
             return  true;
         if(right>=size)
             return  isMaxHeap?heap[left]<=heap[i]:heap[left]>=heap[i];
         if(isMaxHeap)
         return  heap[i]>=heap[left] && heap[i]>=heap[right] && isheap(left) && isheap(right);
         return  heap[i]<=heap[left] && heap[i]<=heap[right] && isheap(left) && isheap(right);
    }


    public void pr() {
         for(int i=0;i<size;i++)
             System.out.print(heap[i]+" ");
         System.out.println();
    }
}
