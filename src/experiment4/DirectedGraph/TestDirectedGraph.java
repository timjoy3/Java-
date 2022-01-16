package experiment4.DirectedGraph;

import java.util.Scanner;

public class TestDirectedGraph {
    public static void main(String[] args) {
        System.out.println("请输入图的顶点数:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println("请输入图的边数:");
        int m = input.nextInt();
        System.out.println("请输入边的信息(两个顶点,一个带权)");
        //0 1 1  0 2 12  1 2 9  1 3 3  3 2 4  3 4 13  2 4 5  3 5 15  4 5 4
        int [][] edgeMatrix = new int[m][3];
        for (int i = 0; i < m; i++){
            // System.out.print("第"+String.valueOf(i+1)+"条边:");
            for (int j = 0; j < 3; j++)
            edgeMatrix[i][j] = input.nextInt();
        }
        DirectedGraph myDirectedGraph = new DirectedGraph();
        myDirectedGraph.InitMatrix();
        myDirectedGraph.CreateMatrix(edgeMatrix);
        System.out.println("输入邻接矩阵为:");
        myDirectedGraph.PrintMatrix(n);
        System.out.println("Prim算法生成最小生成树为:");
        int[] result = myDirectedGraph.DijKstra(0,n);//最小生成树
        // myDirectedGraph.PrintEdge(edges);
        System.out.println("顶点0到图中所有顶点之间的最短距离为：");
        for(int i = 0;i < result.length;i++) 
            System.out.print(result[i]+" ");
        input.close();
    }
}
