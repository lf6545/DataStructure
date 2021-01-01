package DataStructure.Graph.test;

import DataStructure.ArrayAndList.QueueByList;
import DataStructure.Graph.DepthFirstSearch;
import DataStructure.Graph.Graph;

/*
* 测试图的深度优先遍历
* */
public class TestDepthFirstSearch {
    public static void main(String[] args) {
        //创建一个图
        Graph graph = new Graph(15);
        System.out.println("当前图中共有:"+graph.V()+"个顶点.");
        System.out.println("当前图中共有:"+graph.E()+"条边.");

        System.out.println("-------------------------------");
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(1,5);
        graph.addEdge(2,9);
        graph.addEdge(3,9);
        graph.addEdge(3,6);
        graph.addEdge(4,6);
        graph.addEdge(5,6);
        graph.addEdge(6,7);
        graph.addEdge(6,8);
        graph.addEdge(8,9);

        graph.addEdge(10,12);
        graph.addEdge(10,11);
        graph.addEdge(13,14);

        System.out.println("---------------------------------");
        System.out.println("当前图中共有:"+graph.E()+"条边.");

        //创建深度优先搜索对象
        DepthFirstSearch dfs = new DepthFirstSearch(graph, 1);

        System.out.println("与顶点相通的顶点个数:"+dfs.count());
        QueueByList<Integer> queue = dfs.connected();
//        while (!queue.isEmpty()){
//            System.out.print(queue.dequeue()+" ");
//        }
        for (Object o : queue) {
            System.out.print(o+" ");
        }

    }
}
