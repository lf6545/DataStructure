package DataStructure.Graph;

import DataStructure.ArrayAndList.QueueByList;

/*
* 无向图实现:使用邻接表
* */
public class Graph {
    private final int V;//顶点数量
    private int E;//边的数量
    private QueueByList<Integer>[] adj;//邻接表

    //构造方法,创建包含V个顶点但不包含边的图
    public Graph(int V){
        this.V = V;
        this.E = 0;
        this.adj = new QueueByList[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new QueueByList<Integer>();
        }
    }

    //获取途中顶点数量
    public int V(){
        return V;
    }

    //获取图中边的数量
    public int E(){
        return E;
    }

    //向图中添加一条边v-w
    public void addEdge(int v,int w){
        //顶点校验,判断图中是否包含该顶点
        if (v<0 ||v>=V||w<0||w>=V){
            System.out.println("构造边失败!原因:当前图中不存在顶点"+v+"或者"+w+"!");
            return;
        }
        //添加v-w边
        if (adj[v].contains(w)||adj[w].contains(v)){
            //v-w边已经存在
            System.out.println(v+"-"+w+"的边已经存在!");
            return;
        }else{
            System.out.println("已构建边"+v+"-"+w+"");
            adj[v].enqueue(w);
            adj[w].enqueue(v);
            E++;
        }
    }

    //获取与顶点v相邻的所有顶点
    public QueueByList<Integer> adj(int v){
        //参数检验
        if (v<0||v>=V){
            return null;
        }
        return adj[v];
    }
}
