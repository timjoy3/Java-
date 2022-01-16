package experiment4.UndirectedGraph;

import java.util.ArrayList;

class edge{
    public int fromVex;
    public int endVex;
    public int weight;
    public edge(int fromVex,int endVex,int weight){
        this.fromVex = fromVex;
        this.endVex = endVex;
        this.weight = weight;
    }
}

public class UndirectedGraph {
    public int MaxVertexNum = 20;
    public int MaxEdgeNum = 40;
    public int INF = Integer.MAX_VALUE;
    public int[][] adjmatrix;


    public UndirectedGraph(){
        this.adjmatrix = new int[MaxVertexNum][MaxVertexNum];
    }

    // 初始化邻接矩阵表示的无向带权图
    void InitMatrix() {
    	int i, j;
    	for (i = 0; i < MaxVertexNum; i++)
    		for (j = 0; j < MaxVertexNum; j++)
    			if (i == j)
    				adjmatrix[i][j] = 0;
    			else
    				adjmatrix[i][j] = INF;
    }

    // 建立邻接矩阵表示的无向带权图
    void CreateMatrix(int [][] edgeMatrix) {
		for (int[] matrix : edgeMatrix) {
			int i = matrix[0];
			int j = matrix[1];
			int w = matrix[2];
			adjmatrix[i][j] = adjmatrix[j][i] = w;
		}
    }

    // 输出邻接矩阵表示的无向带权图
    void PrintMatrix(int n) {
    	int i, j;
    	for (i = 0; i < n; i++) {
    		for (j = 0; j < n; j++) {
    			if (adjmatrix[i][j] == INF)
                    System.out.print("\t∞");
    			else
                    System.out.print("\t"+adjmatrix[i][j]+" ");
    		}
            System.out.println();
    	}
    }

    public ArrayList<edge> Prim(int n) {
        boolean[] visit = new boolean[n];   //记录顶点是否被访问，如果已被访问，则置相应顶点的元素值为-2
        for(int i = 0;i < n;i++)
            visit[i] = false;
        ArrayList<Integer> listVisited = new ArrayList<Integer>(); //保存已经遍历过的顶点
        ArrayList<edge> edgeVisited = new ArrayList<edge>(); //保存已经遍历过的边
        visit[0] = true;    //初始随意选择一个顶点作为起始点，此处选择顶点0,表示顶点0被访问
        listVisited.add(0); 
        System.out.println(n);
        while(listVisited.size() < n) {  //当已被遍历的顶点数等于给定顶点数时，退出循环
            int minDistance = INF;    //用于寻找最小权值，初始化为int最大值，相当于无穷大的意思
            int minV = 0;   //用于存放未被遍历的顶点中与已被遍历顶点有最小权值的顶点
            int minI = 0;   //用于存放已被遍历的顶点与未被遍历顶点有最小权值的顶点  ；即G[minI][minV]在剩余的权值中最小
            for(int i = 0;i < listVisited.size();i++) {   //i 表示已被访问的顶点
                int v1 = listVisited.get(i);
                for(int j = 0;j < n;j++) {
                    if(!visit[j]) {    //满足此条件的表示，顶点j未被访问
                        if(adjmatrix[v1][j] != INF && adjmatrix[v1][j] < minDistance) {//G[v1][j]值为-1表示v1和j是非相邻顶点
                            minDistance = adjmatrix[v1][j];
                            minV = j;
                            minI = v1;
                        }
                    }
                }
            }
            visit[minV] = true;
            listVisited.add(minV);
            edge edgeAdd = new edge(minI,minV,minDistance);
            edgeVisited.add(edgeAdd);
        }
        System.out.println("使用Prim算法，对于给定图中的顶点访问顺序为:");
        System.out.println(listVisited);
        return edgeVisited;
    }

    // 输出边集数组
    public void PrintEdge(ArrayList<edge> edges) {
    	for (int i = 0; i < edges.size(); i++)
            System.out.println("<"+ edges.get(i).fromVex+","+edges.get(i).endVex+","+edges.get(i).weight+">");
    }
}
