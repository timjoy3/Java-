package experiment4.DirectedGraph;

class directedEdge{
    public int fromVex;
    public int endVex;
    public int weight;
    public directedEdge(int fromVex,int endVex,int weight){
        this.fromVex = fromVex;
        this.endVex = endVex;
        this.weight = weight;
    }
}
public class DirectedGraph {
    public int MaxVertexNum = 20;
    public int MaxEdgeNum = 40;
    public int INF = Integer.MAX_VALUE;
    public int[][] adjmatrix;

    public DirectedGraph(){
        this.adjmatrix = new int[MaxVertexNum][MaxVertexNum];
    }

    // 初始化邻接矩阵表示的有向带权图
    public void InitMatrix() {
    	int i, j;
    	for (i = 0; i < MaxVertexNum; i++)
    		for (j = 0; j < MaxVertexNum; j++)
    			if (i == j)
    				adjmatrix[i][j] = 0;
    			else
    				adjmatrix[i][j] = INF;
    }

    // 建立邻接矩阵表示的有向带权图
    public void CreateMatrix(int [][] edgeMatrix) {
		for (int[] matrix : edgeMatrix) {
			int i = matrix[0];
			int j = matrix[1];
			int w = matrix[2];
			adjmatrix[i][j] = w;
		}
    }

    // 输出邻接矩阵表示的有向带权图
    public void PrintMatrix(int n) {
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

    public int[] DijKstra(int node,int n) {//顶点node,顶点个数n
        int[] result = new int[n];   //用于存放顶点node到其它顶点的最短距离
        boolean[] Visit = new boolean[n];  //用于判断顶点是否被遍历
        for(int i = 0;i < n;i++) {
            result[i] = adjmatrix[node][i];
            Visit[i] = false;
        }
        Visit[node] = true;  //表示顶点node已被遍历
        for(int i = 0;i < n;i++) {
            int min = INF;    //用于暂时存放顶点node到i的最短距离，初始化为Integer型最大值
            int k = 0;
            for(int j = 0;j < n;j++) {  //找到顶点node到其它顶点中距离最小的一个顶点
                if(!Visit[j] && result[j] != INF && min > result[j]) {
                    min = result[j];
                    k = j;
                }
            }
            Visit[k] = true;    //将距离最小的顶点，记为已遍历
            for(int j = 0;j < n;j++) {  //然后，将顶点node到其它顶点的距离与加入中间顶点k之后的距离进行比较，更新最短距离
                if(!Visit[j]) {  //当顶点j未被遍历时
                    //首先，顶点k到顶点j要能通行；这时，当顶点node到顶点j的距离大于顶点node到k再到j的距离或者顶点node无法直接到达顶点j时，更新顶点node到顶点j的最短距离
                    if(adjmatrix[k][j] != INF && (result[j] > min + adjmatrix[k][j] || result[j] == INF))
                        result[j] = min + adjmatrix[k][j];
                }
            }
            System.out.print("第"+String.valueOf(i+1)+"次:");
            for(int z = 0;z < result.length;z++) 
                System.out.print(result[z]+" ");
            System.out.println();
        }
        return result;
    }
}
