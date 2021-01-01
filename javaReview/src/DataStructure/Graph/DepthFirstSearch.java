package DataStructure.Graph;

import DataStructure.ArrayAndList.QueueByList;

/*
* 图的深度优先搜索
* */
public class DepthFirstSearch {
    private boolean[] marked;//索引代表顶点,值表示当前顶点是否被搜索
    private int count;//记录与定点s相同的顶点个数
    private int s;//要搜索的顶点s


    //构造
    public DepthFirstSearch(Graph G,int s){
        this.s = s;
        this.marked = new boolean[G.V()];
        for (int i = 0; i < marked.length; i++) {
            marked[i] = false;
        }
        this.count = 0;
        dfs(G,s);
    }

    //使用深度优先,搜索出图g中与顶点v相通的所有顶点
    private void dfs(Graph G,int v){
        //参数校验
        if (v<0||v>G.V()){
            System.out.println("图"+G+"中不存在顶点"+v);
            return;
        }
        //将顶点v设置为已搜索
        marked[v] = true;
        count++;
        //遍历顶点v的邻接表
        for (Object o : G.adj(v)) {
            int i = (Integer)o;
            if (!marked[i]){
                dfs(G,i);
            }
        }
    }

    //判断顶点w是否与顶点v相通
    public boolean marked(int w){
        return marked[w];
    }

    //获取与顶点s相同的顶点总数
    public int count(){
        return count-1;
    }

    //获取与顶点v相通的所有顶点
    public QueueByList<Integer> connected(){
        QueueByList<Integer> queue = new QueueByList<>();
        for (int i = 0; i < marked.length; i++) {
            if (marked[i]){
                if (i!=s){
                    queue.enqueue(i);
                }
            }
        }
        return queue;
    }
}
