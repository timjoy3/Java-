package experiment4.UndirectedGraph;

import java.util.ArrayList;
import java.util.Scanner;

public class TestUndirectedGraph {
    public static void main(String[] args) {
        System.out.println("请输入图的顶点数:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println("请输入图的边数:");
        int m = input.nextInt();
        System.out.println("请输入边的信息(两个顶点,一个带权)");
        //0 1 6  0 2 1  0 3 5  1 4 3  1 2 5  2 3 5  2 4 6  2 5 4  3 5 2  4 5 6
        int [][] edgeMatrix = new int[m][3];
        for (int i = 0; i < m; i++){
            // System.out.print("第"+String.valueOf(i+1)+"条边:");
            for (int j = 0; j < 3; j++)
            edgeMatrix[i][j] = input.nextInt();
        }
        UndirectedGraph myUndirectedGraph = new UndirectedGraph();
        myUndirectedGraph.InitMatrix();
        myUndirectedGraph.CreateMatrix(edgeMatrix);
        System.out.println("输入邻接矩阵为:");
        myUndirectedGraph.PrintMatrix(n);
        System.out.println("Prim算法生成最小生成树为:");
        ArrayList<edge> edges = myUndirectedGraph.Prim(n);//最小生成树
        myUndirectedGraph.PrintEdge(edges);
        input.close();
    }
}