package DataStructure.Graph;

import DataStructure.ArrayAndList.QueueByList;
import com.sun.deploy.util.Waiter;

/*
* 图的广度优先搜索
* */
public class BreadthFirstSearch {
    private boolean[] marked;//索引当做顶点,值用来标记当前顶点是否被搜索
    private int count;//记录与顶点相通的个数
    private QueueByList<Integer> waitSearch;//用来存储带搜索邻接表的顶点
    private int s;

    //搜早方法
    public BreadthFirstSearch(Graph G,int s){
        this.s = s;
        this.marked = new boolean[G.V()];
        for (int i = 0; i < marked.length; i++) {
            marked[i] = false;
        }
        this.count = 0;
        this.waitSearch = new QueueByList<>();
        bfs(G,s);
    }

    //使用广度优先,找出图G中与顶点v相通的所有顶点
    private void bfs(Graph G,int v){
        //遍历当前顶点的邻接表,将未搜索的顶点进入waitSearch队列
        for (Object o : G.adj(v)) {
            if (!marked[(int) o]){
                //将未搜索的顶点进入待搜索队列中
                waitSearch.enqueue((Integer) o);
                //将进入队列的顶点设置为已搜索
                marked[(int) o] = true;
                count++;
            }
        }
        while (!waitSearch.isEmpty()){
            bfs(G,waitSearch.dequeue());
        }
    }

    //判断顶点w是否与顶点s相通
    public boolean marked(int w){
        return marked[w];
    }

    //获取与顶点s相同的顶点数量
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
