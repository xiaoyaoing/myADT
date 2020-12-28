package test;

import ADT.Heap;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class HeapTest {
    int[] a;
    @Test
    public  void ConstructTest(){
        int[] rarr=new int[1000];
        for(int i=0;i<1000;i++)
            rarr[i]= (int) (Math.random()%100000);
        Heap heap=new Heap(rarr,true);
        assertEquals(heap.isheap(0),true);

    }
     void  heapsorttest(){
         int[] rarr=new int[1000];
         for(int i=0;i<1000;i++)
             rarr[i]= (int) (Math.random()%100000);
         a=Heap.heapsort(rarr,true);
         Arrays.sort(rarr);
         assertArrayEquals(rarr,a);
    }
    @Test
    public  void HeapsortTest1(){
       heapsorttest();
    }

    @Test
    public  void HeapSortTest2(){
        heapsorttest();
    }
    @Test
    public  void HeapSortTest3(){
        heapsorttest();
    }
    @Test
    public  void insertTest(){

       int[] a={12, 2, 16, 30, 28, 10, 16, 20, 6, 18  };
        Heap heap=new Heap(a,true);
        heap.pr();
       int[] ans= heap.heapsort();
       for(int i:ans)
           System.out.print(i+"  ");
    }
}
