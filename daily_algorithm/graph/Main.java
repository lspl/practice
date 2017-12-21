package graph;

import java.util.*;

/**
 * @create 2017-12-20 17:10
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {4, 7, 7},  {7, 4, 7},  {2, 8, 8},  {8, 2, 8},  {0, 1, 10}, {1, 0, 10}, {0, 5, 11}, {5, 0, 11},
                {1, 8, 12}, {8, 1, 12}, {3, 7, 16}, {7, 3, 16}, {1, 6, 16}, {6, 1, 16}, {5, 6, 17}, {6, 5, 17},
                {1, 2, 18}, {2, 1, 18}, {6, 7, 19}, {7, 6, 19}, {3, 4, 20}, {4, 3, 20}, {3, 8, 21}, {8, 3, 21},
                {2, 3, 22}, {3, 2, 22}, {3, 6, 24}, {6, 3, 24}, {4, 5, 26}, {5, 4, 26},
        };

        int[][] matrix0 = {
                {4, 7, 7}, {2, 8, 8}, {0, 1, 10}, {0, 5, 11}, {1, 8, 12}, {3, 7, 16}, {1, 6, 16}, {5, 6, 17},
                {1, 2, 18}, {6, 7, 19}, {3, 4, 20}, {3, 8, 21}, {2, 3, 22}, {3, 6, 24}, {4, 5, 26},
        };

        Graph graph = GraphGenerator.generateGraph(matrix);
        Graph graph0 = GraphGenerator.generateGraph(matrix0);

        // bfs
//        List<Node> list1 = BFS.bfs(graph.nodes.get(0));
//        for (Node n : list1) {
//            System.out.print(n.value + " ");
//        }

        // dfs
//        List<Node> list2 = DFS.dfs(graph.nodes.get(0));
//        for (Node n : list2) {
//            System.out.print(n.value + " ");
//        }

        // 拓扑排序
//        List<Node> list3 = TopologySort.topologySort(graph0);
//        for (Node n : list3) {
//            System.out.print(n.value + " ");
//        }

        // Kruskal算法
//        Set<Edge> set1 = Kruskal.kruskal(graph);
//        for (Edge e : set1) {
//            System.out.print(e.weight + " ");
//        }

        // prim算法
//        Set<Edge> set2 = Prim.prim(graph);
//        for (Edge e : set2) {
//            System.out.print(e.weight + " ");
//        }

        // dijkstra算法
//        HashMap<Node, Integer> map1 = Dijkstra.dijkstra1(graph1.nodes.get(0));
//        for (Map.Entry<Node, Integer> me : map1.entrySet()) {
//            System.out.println(me.getKey().value + ":" + me.getValue());
//        }
        HashMap<Node, Integer> map2 = Dijkstra.dijkstra2(graph0.nodes.get(0), graph.nodes.size());
        for (Map.Entry<Node, Integer> me : map2.entrySet()) {
            System.out.println(me.getKey().value + ":" + me.getValue());
        }
    }
}