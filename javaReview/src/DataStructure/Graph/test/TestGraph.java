package DataStructure.Graph.test;

import DataStructure.ArrayAndList.QueueByList;
import DataStructure.Graph.Graph;

/*
* 测试无向图
* */
public class TestGraph {
    public static void main(String[] args) {
        //创建一个图
        Graph graph = new Graph(15);
        System.out.println("当前图中共有:"+graph.V()+"个顶点.");
        System.out.println("当前图中共有:"+graph.E()+"条边.");

        System.out.println("-------------------------------");
        graph.addEdge(1,2);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(5,3);
        graph.addEdge(6,8);
        graph.addEdge(6,7);
        graph.addEdge(12,8);
        graph.addEdge(1,11);

        System.out.println("-------------------------------");
        System.out.println("当前图中共有:"+graph.E()+"条边.");

        QueueByList<Integer> adj = graph.adj(1);
        System.out.println("与1顶点相邻的顶点有:");
        while (!adj.isEmpty()){
            System.out.print(adj.dequeue()+" ");
        }
    }
}
