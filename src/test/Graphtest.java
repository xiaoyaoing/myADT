package test;

import ADT.Graph;
import ADT.Tree;
import ADT.node;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class Graphtest {
    PrintStream oldPrintStream = System.out; //将原来的System.out交给printStream 对象保存
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    @Before
   public void init(){

      // System.setOut(new PrintStream(bos));
    }
    @Test
    public  void printcycletest1()
    { int[] vrtexs={1,2,3,4,5,6,7,8};
        int[][] gra=new int[8][8];
        for(int i=0;i<4;i++)
            gra[i][i+1]=1;
        gra[4][1]=1;
        gra[3][5]=1;
        gra[5][6]=1;
        gra[6][7]=1;
        gra[7][5]=1;
        Graph graph=new Graph(vrtexs,gra);
        graph.printallthecycle();
        assertEquals(bos.toString(),"12341\n" +
                "5675\n");
    }
    @Test
    public  void printcycletest2(){
        int[] vrtexs={0,1,2,3,4};
        int [][] gra=new int[5][5];
        gra[0][1]=1;
        gra[1][2]=1; gra[1][3]=1;gra[2][3]=1;gra[3][0]=1;
        gra[3][4]=1;gra[4][0]=1;
        Graph graph=new Graph(vrtexs,gra);
        graph.printallthecycle();
        System.out.print(bos.toString());
    }

    @Test
    public  void treetest(){
        Tree tree=new Tree(5);
        tree.root.left=new node(4);
        tree.root.right=new node(6);
        tree.root.left.right=new node(7);
        tree.root.left.left=new node(8);
        tree.root.right.left=new node(9);
        tree.root.right.right=new node(10);
        tree.preoder(tree.root);
        System.out.println();
        tree.inoder(tree.root);
        System.out.println();
        tree.postoder(tree.root);

    }

}
